package com.manu.crud_generator.utils.service.impl;


import com.manu.crud_generator.utils.repository.CustomCrudRepository;
import com.manu.crud_generator.utils.service.CustomCrudService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomCrudServiceImpl<T, D, R extends CustomCrudRepository<T>> implements CustomCrudService<T, D> {

    protected final R repository;
    private final ModelMapper modelMapper;
    private final Class<T> typeClassInstance;
    private final Class<D> typeClassDTO;
    @Autowired
    public CustomCrudServiceImpl(R repository, ModelMapper modelMapper, Class<T> typeClassInstance, Class<D> typeClassDTO) {
        this.repository = repository;
        this.modelMapper = modelMapper;
        this.typeClassInstance = typeClassInstance;
        this.typeClassDTO = typeClassDTO;
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
    }


    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public T getById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public Page<T> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T update(Long id, T entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.delete(getById(id));
    }

    @Override
    public D saveDto(D d) {
        return getDto(save(getInstance(d)));
    }

    @Override
    public D getByIdDto(Long id) {
        return getDto(getById(id));
    }

    @Override
    public Page<D> getAllDto(Pageable pageable) {
        List<D> listD = new ArrayList<>();
        Page<T> pagesInstance = repository.findAll(pageable);
        pagesInstance.getContent().forEach(instance -> listD.add(getDto(instance)));
        return new PageImpl<>(listD, pageable, pagesInstance.getTotalElements());
    }

    @Override
    public D updateDto(D entityD) {
        return saveDto(entityD);
    }

    @Override
    public D getDto(T instance) {
        //log.info("Mapeando: " + typeClassInstance + " >> " + typeClassDTO);
        if (instance != null) {
            return modelMapper.map(instance, typeClassDTO);
        }
        return modelMapper.map(new Object(), typeClassDTO);
    }

    @Override
    public T getInstance(D d) {
        //log.info("Mapeando: " + typeClassDTO + " >> " + typeClassInstance);
        if (d != null) {
            return modelMapper.map(d, typeClassInstance);
        }
        return modelMapper.map(new Object(), typeClassInstance);
    }
}
