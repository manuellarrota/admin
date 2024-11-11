package com.manuellarrota.admin.entities;


import com.manuellarrota.admin.entities.common.Domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "usuario")
public class Usuario extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String contrasena;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Bitacora> bitacoras;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}