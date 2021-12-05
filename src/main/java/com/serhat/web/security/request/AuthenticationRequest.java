package com.serhat.web.security.request;

import lombok.*;

@Data
public class AuthenticationRequest {

    private String userName;
    private String password;
}
