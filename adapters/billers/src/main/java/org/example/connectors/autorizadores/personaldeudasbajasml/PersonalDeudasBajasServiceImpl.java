package org.example.connectors.autorizadores.personaldeudasbajasml;

import lombok.extern.slf4j.Slf4j;
import org.example.connectors.cashinmercadopago.mercadoprepaid.dto.ConsultaDeudaRequest;
import org.example.connectors.cashinmercadopago.mercadoprepaid.dto.ConsultaDeudaResponse;
import org.example.service.ApiConsumeService;
import org.example.core.dto.RequestDto;
import org.example.core.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonalDeudasBajasServiceImpl implements ApiConsumeService<RequestDto, ResponseDto> {

    private PersonalDeudasBajasClient personalDeudasBajasClient;

    @Autowired
    public PersonalDeudasBajasServiceImpl(PersonalDeudasBajasClient personalDeudasBajasClient) {
        this.personalDeudasBajasClient = personalDeudasBajasClient;
    }

    @Override
    public ResponseDto consultaDeuda(RequestDto requestDto) {
        log.info("Consultando Personal Deudas Bajas");
        ConsultaDeudaResponse consultaDeudaResponse = personalDeudasBajasClient.consultaDeuda(new ConsultaDeudaRequest(requestDto));
        ResponseDto responseDto = new ResponseDto();
        return responseDto;
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
