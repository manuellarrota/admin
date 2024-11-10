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
public class CustomCrudServiceImpl<T, DTO, R extends CustomCrudRepository<T>> implements CustomCrudService<T, DTO> {

    protected final R repository;
    private final ModelMapper modelMapper;
    private final Class<T> typeClassInstance;
    private final Class<DTO> typeClassDTO;
    @Autowired
    public CustomCrudServiceImpl(R repository, ModelMapper modelMapper, Class<T> typeClassInstance, Class<DTO> typeClassDTO) {
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
    public DTO saveDto(DTO dto) {
        return getDto(save(getInstance(dto)));
    }

    @Override
    public DTO getByIdDto(Long id) {
        return getDto(getById(id));
    }

    @Override
    public Page<DTO> getAllDto(Pageable pageable) {
        List<DTO> listDto = new ArrayList<>();
        Page<T> pagesInstance = repository.findAll(pageable);
        pagesInstance.getContent().forEach(instance -> listDto.add(getDto(instance)));
        return new PageImpl<>(listDto, pageable, pagesInstance.getTotalElements());
    }

    @Override
    public DTO updateDto(DTO entityDto) {
        return saveDto(entityDto);
    }

    @Override
    public DTO getDto(T instance) {
        //log.info("Mapeando: " + typeClassInstance + " >> " + typeClassDTO);
        if (instance != null) {
            return modelMapper.map(instance, typeClassDTO);
        }
        return modelMapper.map(new Object(), typeClassDTO);
    }

    @Override
    public T getInstance(DTO dto) {
        //log.info("Mapeando: " + typeClassDTO + " >> " + typeClassInstance);
        if (dto != null) {
            return modelMapper.map(dto, typeClassInstance);
        }
        return modelMapper.map(new Object(), typeClassInstance);
    }
}
