package org.example.connectors.cashinmercadopago.mercadoprepaid;

import lombok.extern.slf4j.Slf4j;
import org.example.connectors.cashinmercadopago.mercadoprepaid.dto.*;
import org.example.service.ApiConsumeServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MercadoPrePaidClientImpl implements ApiConsumeServiceCustom<ConsultaDeudaResponse, ConsultaDeudaRequest,
        ConsultaDeudasResponse, ConsultaDeudaRequest, DirectaResponse, DirectaRequest, ConsultaEstadoResponse,
        ConsultaEstadoRequest, ReversaResponse, ReversaRequest> {
    @Value("${connectors.autorizadores.mercadoPrePaid.url-base}")
    private String urlBase;
    private RestTemplate restTemplate;
    @Autowired
    public MercadoPrePaidClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ConsultaDeudaResponse consultaDeuda(ConsultaDeudaRequest request) {
        try {
            String response = restTemplate.getForObject(urlBase, String.class);
            log.info("Response from REST service: " + response);
        }catch (Exception ex){
            log.error("El api {} no se encuentra o no se obtiene respuesta.", urlBase);
        }

        return new ConsultaDeudaResponse();
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
