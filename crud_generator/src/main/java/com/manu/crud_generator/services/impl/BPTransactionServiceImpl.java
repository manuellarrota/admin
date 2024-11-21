package com.manu.crud_generator.services.impl;

import com.manu.crud_generator.entities.BPTransaction;
import com.manu.crud_generator.repositories.BPTransactionRepository;
import com.manu.crud_generator.services.BPTransactionService;
import com.manu.crud_generator.dtos.BPTransactionDto;
import com.manu.crud_generator.utils.service.impl.CustomCrudServiceImpl;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class BPTransactionServiceImpl extends CustomCrudServiceImpl<BPTransaction, BPTransactionDto, BPTransactionRepository>
implements BPTransactionService{

    public BPTransactionServiceImpl(BPTransactionRepository repository, ModelMapper modelMapper) {
            super(repository, modelMapper, BPTransaction.class, BPTransactionDto.class);
        }
}

