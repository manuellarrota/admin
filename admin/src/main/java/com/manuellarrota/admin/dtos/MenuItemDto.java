package com.manuellarrota.admin.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MenuItemDto {
    private String id;
    private String name;
    private String url;
    private String icon;
    private List<MenuItemDto> subMenu;
}
