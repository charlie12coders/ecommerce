package com.charlie.server.request;

import com.charlie.server.models.AddressDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersDtoRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;
    private String Country;
    private String state;
    private String city;
    private boolean rememberMe;
}
