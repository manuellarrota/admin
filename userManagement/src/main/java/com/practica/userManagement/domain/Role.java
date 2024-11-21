package com.practica.userManagement.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "practica_role")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
}
