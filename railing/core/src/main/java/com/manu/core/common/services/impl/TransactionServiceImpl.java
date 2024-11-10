package com.manu.core.common.services.impl;

import com.manu.core.common.repository.TransactionRepository;
import com.manu.core.common.services.TransactionService;
import com.manu.core.common.dtos.external.RequestDto;
import com.manu.core.common.dtos.external.ResponseDto;

public class TransactionServiceImpl implements TransactionService<RequestDto, ResponseDto> {

    public final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public ResponseDto consulta(RequestDto requestDto) {

        return null;
    }

    @Override
    public ResponseDto directa(RequestDto requestDto) {
        return null;
    }

    @Override
    public ResponseDto reversa(RequestDto requestDto) {
        return null;
    }

    @Override
    public ResponseDto cancelacion(RequestDto requestDto) {
        return null;
    }
}
