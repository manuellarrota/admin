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

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    private List<Notificacion> notificaciones;

    @OneToMany(mappedBy = "usuario")
    private List<Bitacora> bitacoras;

    // Getters y Setters
}