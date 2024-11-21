package com.manuellarrota.admin.entities;


import com.manuellarrota.admin.entities.common.Domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "users")
public class User extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mail;
    private String password;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Binnacle> binnacles;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}