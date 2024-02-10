package com.charlie.server.service;


import com.charlie.server.request.UsersDtoRequest;
import com.charlie.server.response.LoginResponse;
import com.charlie.server.response.RegisterResponse;

public interface IUserService {
    RegisterResponse Register(UsersDtoRequest usersDto);
    LoginResponse Login(String email, String password, boolean rememberme);
}
