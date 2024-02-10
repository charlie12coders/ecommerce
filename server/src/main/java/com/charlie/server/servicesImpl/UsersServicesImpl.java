package com.charlie.server.servicesImpl;

import com.charlie.server.models.AddressDto;
import com.charlie.server.models.UsersDto;
import com.charlie.server.repository.IUserRepository;
import com.charlie.server.request.UsersDtoRequest;
import com.charlie.server.response.LoginResponse;
import com.charlie.server.response.RegisterResponse;
import com.charlie.server.service.IUserService;
import com.charlie.server.util.JwtHelper;
import com.charlie.server.util.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersServicesImpl implements IUserService {
    private static IUserRepository USER_REPOSITORY;
    private static AuthenticationManager manager;
    private static UserService userService;
    private static JwtHelper jwtHelper;
    private static ModelMapper modelMapper;
    private static BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UsersServicesImpl(IUserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager manager,UserService userService,JwtHelper jwtHelper,ModelMapper modelMapper){
        this.USER_REPOSITORY=userRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.manager=manager;
        this.userService=userService;
        this.jwtHelper=jwtHelper;
        this.modelMapper=modelMapper;
    }
    @Override
    public RegisterResponse Register(UsersDtoRequest usersDto) {
        try{
            UsersDto findByEmail=USER_REPOSITORY.findByEmail(usersDto.getEmail());
            if(findByEmail==null){
                usersDto.setPassword(bCryptPasswordEncoder.encode(usersDto.getPassword()));
                UsersDto users=modelMapper.map(usersDto,UsersDto.class);
                AddressDto addressDto=new AddressDto();
                addressDto.setCountry(usersDto.getCountry());
                addressDto.setState(usersDto.getState());
                addressDto.setCity(usersDto.getCity());
                users.setAddress(addressDto);
                USER_REPOSITORY.save(users);
                return new RegisterResponse("User is successfully registered",HttpStatus.CREATED);
            }else{
                return new RegisterResponse("User are already exist", HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception exception){
            return new RegisterResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public LoginResponse Login(String email, String password, boolean rememberme) {
        try{
            UsersDto findByEmail=USER_REPOSITORY.findByEmail(email);
            boolean matches=bCryptPasswordEncoder.matches(password, findByEmail.getPassword());
            if(findByEmail==null){
                return null;
            }else if(findByEmail.getEmail().equals(email) && matches){
                //this.doAuthenticate(email, password);


                UserDetails userDetails = userService.loadUserByUsername(email);
                String token = this.jwtHelper.generateToken(userDetails);
                return new LoginResponse(token, findByEmail.getEmail(),HttpStatus.OK, "Valid Credentials");
            }else{
                return new LoginResponse("", "",HttpStatus.FORBIDDEN, "Invalid Credentials");
            }
        }
        catch (Exception exception){
            return new LoginResponse("","", HttpStatus.INTERNAL_SERVER_ERROR,exception.getMessage());
        }
    }
    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }
}
