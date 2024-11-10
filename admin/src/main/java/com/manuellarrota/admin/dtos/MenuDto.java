package com.manuellarrota.admin.dtos;


import com.manuellarrota.admin.entities.Rol;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {
    private Long id;

    private String name;
    private String url;
    private String icon;

    @ElementCollection
    private List<Rol> allowedRoles;

}
