package com.manuellarrota.admin.services;

import com.manuellarrota.admin.entities.Notification;

import java.util.List;

public interface NotificacionService {
    List<Notification> findAll();

    Notification findById(Long id);

    Notification save(Notification notification);

    void delete(Long id);
}