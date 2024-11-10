package com.manuellarrota.admin.entities;

import com.manuellarrota.admin.entities.common.Domain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
@Table(name = "menu")
public class Menu extends Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String url;
    private String icon;

    @ManyToMany(fetch = FetchType.LAZY)  // Relación de muchos a muchos
    @JoinTable(
            name = "menu_role",               // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Rol> allowedRoles = new ArrayList<>();

    public Menu(String name, String url, String icon, List<Rol> allowedRoles) {
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.allowedRoles = allowedRoles;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
