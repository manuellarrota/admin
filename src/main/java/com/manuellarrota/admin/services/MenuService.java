package com.manuellarrota.admin.services;

import com.manuellarrota.admin.entities.Menu;
import com.manuellarrota.admin.util.MenuOption;

import java.util.List;

public interface MenuService {

    List<MenuOption> findAll();
    Menu findById(Long id);
    Menu save(Menu menu);
    void delete(Long id);
}
