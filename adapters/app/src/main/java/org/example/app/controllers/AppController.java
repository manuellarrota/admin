package org.example.app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.service.ApiConsumeService;
import org.example.core.dto.RequestDto;
import org.example.core.dto.ResponseDto;
import org.example.service.ApiRouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("adapters")
@Slf4j
public class AppController implements ApiConsumeService<RequestDto, ResponseDto> {
    /**
     * Serivicio que se encarga de buscar el bean correcto para procesar la solicitud
     */
    private final ApiRouterService<RequestDto, ResponseDto> apiRouterService;
    private static final ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Autowired
    public AppController(ApiRouterService<RequestDto, ResponseDto> apiRouterService) {
        this.apiRouterService = apiRouterService;
    }

    @Override
    @PostMapping
    public ResponseDto consultaDeuda(RequestDto requestDto) {
        startTime.set(System.currentTimeMillis());
        log.info("---------------- Comenzando: {} milisegundos" , startTime.get());
        ResponseDto responseDto = new ResponseDto();
        try {
            responseDto = apiRouterService.consultaDeuda(requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe ({}), Error: \n {} ", responseDto, ex.getLocalizedMessage() );
        }

        imprimeRespuesta(responseDto);
        return responseDto;
    }

    @Override
    public ResponseDto consultaDeudas(RequestDto requestDto) {
        startTime.set(System.currentTimeMillis());
        log.info("---------------- Comenzando: {} milisegundos" , startTime.get());
        ResponseDto responseDto = new ResponseDto();
        try {
            responseDto = apiRouterService.consultaDeudas(requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe ({}), Error: \n {} ", responseDto, ex.getLocalizedMessage() );
        }


        imprimeRespuesta(responseDto);
        return responseDto;
    }

    @Override
    public ResponseDto directa(RequestDto requestDto) {
        startTime.set(System.currentTimeMillis());
        log.info("---------------- Comenzando: {} milisegundos" , startTime.get());
        ResponseDto responseDto = new ResponseDto();
        try {
            responseDto = apiRouterService.directa(requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe ({}), Error: \n {} ", responseDto, ex.getLocalizedMessage() );
        }
        imprimeRespuesta(responseDto);
        return responseDto;
    }

    @Override
    public ResponseDto consultaEstado(RequestDto requestDto) {
        startTime.set(System.currentTimeMillis());
        log.info("---------------- Comenzando: {} milisegundos" , startTime.get());
        ResponseDto responseDto = new ResponseDto();
        try {
            responseDto = apiRouterService.consultaEstado(requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe ({}), Error: \n {} ", responseDto, ex.getLocalizedMessage() );
        }
        imprimeRespuesta(responseDto);
        return responseDto;
    }

    @Override
    public ResponseDto reversa(RequestDto requestDto) {
        startTime.set(System.currentTimeMillis());
        log.info("---------------- Comenzando: {} milisegundos" , startTime.get());
        ResponseDto responseDto = new ResponseDto();
        try {
            responseDto = apiRouterService.reversa(requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe ({}), Error: \n {} ", responseDto, ex.getLocalizedMessage() );
        }
        imprimeRespuesta(responseDto);
        return responseDto;
    }

    private void imprimeRespuesta(ResponseDto responseDto){
        long endTime = System.currentTimeMillis();
        long processingTime = endTime - startTime.get();
        log.info("Respuesta : {}", responseDto);
        log.info("---------------- Demoro: {} milisegundos" , processingTime);
    }

}
