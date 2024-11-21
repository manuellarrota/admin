package com.manuellarrota.admin.util;

import com.manuellarrota.admin.entities.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MenuOption {
    private Long id;
    private String name;
    private String url;
    private String icon;
    private List<Role> allowedRoles;

    public MenuOption(Long id, String name, String url, String icon, List<Role> allowedRoles) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.allowedRoles = allowedRoles;
    }
}
