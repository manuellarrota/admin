package com.practica.userManagement.domain;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String nickname;
    private String mail;
    private String password;
    private String roles;
}
