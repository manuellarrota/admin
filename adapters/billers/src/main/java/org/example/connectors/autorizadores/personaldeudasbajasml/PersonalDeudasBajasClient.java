package org.example.connectors.autorizadores.personaldeudasbajasml;

import lombok.extern.slf4j.Slf4j;
import org.example.connectors.cashinmercadopago.mercadoprepaid.dto.*;
import org.example.service.ApiConsumeServiceCustom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class PersonalDeudasBajasClient  implements ApiConsumeServiceCustom<ConsultaDeudaResponse, ConsultaDeudaRequest,
        ConsultaDeudasResponse, ConsultaDeudaRequest, DirectaResponse, DirectaRequest, ConsultaEstadoResponse,
        ConsultaEstadoRequest, ReversaResponse, ReversaRequest> {
    @Value("${connectors.autorizadores.mercadoPrePaid.url-base}")
    private String urlBase;
    private RestTemplate restTemplate;

    public PersonalDeudasBajasClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ConsultaDeudaResponse consultaDeuda(ConsultaDeudaRequest request) {
        try {
            ConsultaDeudaResponse consultaDeudaResponse = restTemplate.getForObject(urlBase, ConsultaDeudaResponse.class);
        }catch (Exception exception){
            log.error("Error en la conexion con {}", urlBase);
        }
        return null;
    }

    @Override
    public ConsultaDeudasResponse consultaDeudas(ConsultaDeudaRequest request) {
        return null;
    }

    @Override
    public DirectaResponse directa(DirectaRequest request) {
        return null;
    }

    @Override
    public ConsultaEstadoResponse consultaEstado(ConsultaEstadoRequest request) {
        return null;
    }

    @Override
    public ReversaResponse reversa(ReversaRequest request) {
        return null;
    }
}
