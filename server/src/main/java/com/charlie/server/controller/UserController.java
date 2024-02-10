package com.charlie.server.controller;

import com.charlie.server.models.UsersDto;
import com.charlie.server.request.UsersDtoRequest;
import com.charlie.server.response.LoginResponse;
import com.charlie.server.response.RegisterResponse;
import com.charlie.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/")
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("register")
    public ResponseEntity<?> Register(@RequestBody UsersDtoRequest usersDto){
        try{
            RegisterResponse register = userService.Register(usersDto);
            if(register.getStatus().equals(HttpStatus.CREATED)){
                return ResponseEntity.ok().body(register);
            }
            return ResponseEntity.badRequest().body(register);
        }
        catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
    @PostMapping("login")
    public ResponseEntity<?> Login(@RequestBody UsersDtoRequest usersDto){
        try{
            LoginResponse login = userService.Login(usersDto.getEmail(), usersDto.getPassword(), usersDto.isRememberMe());
            if(login.getStatus().equals(HttpStatus.OK)){
                return ResponseEntity.ok().body(login);
            }
            return ResponseEntity.badRequest().body(login);
        }
        catch (Exception exception){
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }
}
