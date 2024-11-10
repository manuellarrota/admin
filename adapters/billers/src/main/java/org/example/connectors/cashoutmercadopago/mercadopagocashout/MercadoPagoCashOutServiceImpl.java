package org.example.connectors.cashoutmercadopago.mercadopagocashout;


import lombok.extern.slf4j.Slf4j;

import org.example.core.dto.RequestDto;
import org.example.core.dto.ResponseDto;
import org.example.service.ApiConsumeService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MercadoPagoCashOutServiceImpl implements ApiConsumeService<RequestDto, ResponseDto> {

    @Override
    public ResponseDto consultaDeuda(RequestDto requestDto) {
        log.info("Consulta deuda ");
        return null;
    }

    @Override
    public ResponseDto consultaDeudas(RequestDto requestDto) {
        return null;
    }

    @Override
    public ResponseDto directa(RequestDto requestDto) {
        return null;
    }

    @Override
    public ResponseDto consultaEstado(RequestDto requestDto) {
        return null;
    }

    @Override
    public ResponseDto reversa(RequestDto requestDto) {
        return null;
    }
}
