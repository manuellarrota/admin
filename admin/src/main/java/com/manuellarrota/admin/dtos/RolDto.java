package com.manuellarrota.admin.dtos;

import com.manuellarrota.admin.entities.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class RolDto {
    private Long id;
    private String nombre;
    private List<Usuario> usuarios;
}
