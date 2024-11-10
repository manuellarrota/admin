package org.example.connectors.cashinmercadopago.mercadoprepaid;

import lombok.extern.slf4j.Slf4j;
import org.example.connectors.cashinmercadopago.mercadoprepaid.dto.ConsultaDeudaRequest;
import org.example.connectors.cashinmercadopago.mercadoprepaid.dto.ConsultaDeudaResponse;
import org.example.core.dto.RequestDto;
import org.example.core.dto.ResponseDto;
import org.example.service.ApiConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MercadoPrePaidServiceImpl implements ApiConsumeService<RequestDto, ResponseDto> {

    @Value("${connectors.autorizadores.personaldeudasbajas.mensaje}")
    private String mensaje;
    private MercadoPrePaidClientImpl mercadoPrePaidClientImpl;

    @Autowired
    public MercadoPrePaidServiceImpl(MercadoPrePaidClientImpl mercadoPrePaidClientImpl) {
        this.mercadoPrePaidClientImpl = mercadoPrePaidClientImpl;
    }

    @Override
    public ResponseDto consultaDeuda(RequestDto requestDto) {
        ResponseDto responseDto = new ResponseDto();
        log.info("Mensajeeee: "+mensaje);
        ConsultaDeudaResponse consultaDeudaResponse = mercadoPrePaidClientImpl.consultaDeuda(new ConsultaDeudaRequest(requestDto));
        responseDto.setPagoOperacionNumero(consultaDeudaResponse.toString());

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
