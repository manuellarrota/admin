package com.manu.adapter.service.impl;

import com.manu.adapter.dto.TransactionRequestDto;
import com.manu.adapter.dto.TransactionResponseDto;
import com.manu.adapter.service.RailingService;
import org.springframework.stereotype.Service;

@Service
public class RailingServiceImpl implements RailingService {
    @Override
    public TransactionResponseDto consulta(TransactionRequestDto transactionRequestDto) {
        return null;
    }

    @Override
    public TransactionResponseDto directa(TransactionRequestDto transactionRequestDto) {
        return null;
    }

    @Override
    public TransactionResponseDto reversa(TransactionRequestDto transactionRequestDto) {
        return null;
    }

    @Override
    public TransactionResponseDto cancelacion(TransactionRequestDto transactionRequestDto) {
        return null;
    }
}
