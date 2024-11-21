package com.manu.crud_generator.services.impl;

import com.manu.crud_generator.entities.BPTraza;
import com.manu.crud_generator.repositories.BPTrazaRepository;
import com.manu.crud_generator.services.BPTrazaService;
import com.manu.crud_generator.dtos.BPTrazaDto;
import com.manu.crud_generator.utils.service.impl.CustomCrudServiceImpl;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class BPTrazaServiceImpl extends CustomCrudServiceImpl<BPTraza, BPTrazaDto, BPTrazaRepository>
implements BPTrazaService{

    public BPTrazaServiceImpl(BPTrazaRepository repository, ModelMapper modelMapper) {
            super(repository, modelMapper, BPTraza.class, BPTrazaDto.class);
        }
}

