package com.manu.conversor.entities.claro.impl;

import com.manu.conversor.entities.claro.ConsultaResponse;
import com.manu.conversor.entities.claro.ConsutaRequest;
import com.manu.conversor.service.ConversorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ConversorServiceImpl  implements ConversorService<ConsutaRequest, ConsultaResponse> {

    @Override
    public ConsultaResponse consulta(ConsutaRequest request) {
        log.info(request.toString());
        return null;
    }

    @Override
    public List<ConsultaResponse> consultaListado(ConsutaRequest request) {
        return null;
    }

    @Override
    public ConsultaResponse directa(ConsutaRequest request) {
        return null;
    }

    @Override
    public ConsultaResponse reversa(ConsutaRequest request) {
        return null;
    }
}
