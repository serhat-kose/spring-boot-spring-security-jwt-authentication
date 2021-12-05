package com.serhat.web.security.responses;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String firstName;
    private String lastName;
    private String userName;

    private Object roles;
}
