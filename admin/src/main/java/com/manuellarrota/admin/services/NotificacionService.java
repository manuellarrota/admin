package com.manuellarrota.admin.services;

import com.manuellarrota.admin.entities.Notificacion;

import java.util.List;

public interface NotificacionService {
    List<Notificacion> findAll();

    Notificacion findById(Long id);

    Notificacion save(Notificacion notificacion);

    void delete(Long id);
}