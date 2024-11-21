package com.natural.user.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "app_demo_user")
@Getter @Setter @Data
@AllArgsConstructor @NoArgsConstructor
public class User{

    @Id
    private Long id;

    private String nickName;
    private String mail;
    private String name;
    private String lastName;
    private String password;

}
