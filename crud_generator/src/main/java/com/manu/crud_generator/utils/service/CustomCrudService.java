package com.manu.crud_generator.utils.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @param <T>
 * @param <DTO>
 */
public interface CustomCrudService<T, DTO> {

    T save(T entity);
    T getById(Long id);
    Page<T> getAll(Pageable pageable);
    T update(Long id, T entity);
    void delete(Long id);
    DTO saveDto(DTO dto);
    DTO getByIdDto(Long id);
    Page<DTO> getAllDto(Pageable pageable);
    DTO updateDto(DTO entityDto);

    DTO getDto(T instance);

    /**
     * transforma dto en una instancia.
     *
     * @param dto objeto representativo de la instancia.
     * @return Instancia.
     */
    T getInstance(DTO dto);
}
