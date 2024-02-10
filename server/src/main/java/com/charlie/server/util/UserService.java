package com.charlie.server.util;

import com.charlie.server.models.UsersDto;
import com.charlie.server.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsersDto findByEmail = userRepository.findByEmail(email);
        if(findByEmail==null){
            return null;
        } else if (findByEmail.getEmail().equals(email)) {
            return new User(findByEmail.getEmail(), findByEmail.getPassword(), new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("User is valid");
        }
    }
}
