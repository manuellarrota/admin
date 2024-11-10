package com.manuellarrota.admin.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuOption {
    private String label;
    private String url;
    private String icon;


    public MenuOption(String label, String url, String icon) {
        this.label = label;
        this.url = url;
        this.icon = icon;
    }
}
