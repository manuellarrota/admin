package com.manuellarrota.admin.entities;


import com.manuellarrota.admin.entities.common.Domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "bitacora")
public class Bitacora extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha;
    private String accion;
    private String detalle;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
