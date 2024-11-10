package com.manu.core.common.services;

import com.manu.core.common.repository.TransactionRepository;

public interface TransactionService<REQUEST, RESPONSE>{

    RESPONSE consulta(REQUEST request);

    RESPONSE directa(REQUEST request);

    RESPONSE reversa(REQUEST request);

    RESPONSE cancelacion(REQUEST request);
}
