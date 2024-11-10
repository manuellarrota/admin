package com.manuellarrota.admin.services.impl;

import com.manuellarrota.admin.entities.Menu;
import com.manuellarrota.admin.repositories.MenuRepository;
import com.manuellarrota.admin.services.MenuService;
import com.manuellarrota.admin.util.MenuOption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuOption> findAll() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> userRoles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)  // Obtiene el rol con el prefijo "ROLE_"
                .map(role -> role.replace("ROLE_", ""))  // Elimina el prefijo "ROLE_"
                .collect(Collectors.toSet());  // Colecta los roles sin "ROLE_"
        return menuRepository.findMenusByRoles(new ArrayList<>(userRoles)).stream().map(
                menu -> new MenuOption(menu.getName(),  menu.getUrl(), menu.getIcon() )
        ).toList();
    }

    @Override
    public Menu findById(Long id) {
        return menuRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Menu save(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);
    }
}