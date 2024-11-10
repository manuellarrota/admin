package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.service.ApiRouterService;
import org.example.core.domain.BPTransaction;
import org.example.core.dto.RequestDto;
import org.example.core.dto.ResponseDto;
import org.example.core.repository.BPTransactionRepository;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.example.core.enums.Methods.*;

@Service
@Slf4j
public class ApiRouterServiceImpl implements ApiRouterService<RequestDto, ResponseDto> {


    private ApplicationContext applicationContext;
    private final BPTransactionRepository BPTransactionRepository;
    private final Map<String, Object> beanMap = new ConcurrentHashMap<>();

    @Autowired
    public ApiRouterServiceImpl(ApplicationContext applicationContext, BPTransactionRepository BPTransactionRepository) {
        this.applicationContext = applicationContext;
        this.BPTransactionRepository = BPTransactionRepository;
    }

    /**
     * Invoca un servicio y su metodo a partir de sus nombres y parametros.
     * Debe estar en el contexto para que funcione.
     *
     * @param serviceName nombre del servicio.
     * @param method        Metodo que se quiere ejecutar.
     * @param parameters    Parametros del metodo.
     * @throws NoSuchBeanDefinitionException
     */
    @Override
    public Object routeService(String serviceName, String method, Object ...parameters) throws NoSuchBeanDefinitionException {
        String className = serviceName+"ServiceImpl";
        Object bean = obtenerBean(className);
        Object response;

        if (bean != null) {
            try {
                Class<?>[] tiposParametros = obtenerTiposParametros(parameters);
                Method metodo = bean.getClass().getMethod(method, tiposParametros);
                response = metodo.invoke(bean, parameters);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new NoSuchBeanDefinitionException("el metodo "+method+" del bean no se encuentra");
            }
        } else {
            throw new NoSuchBeanDefinitionException("el bean "+className+" no se encuentra");
        }
        return response;
    }

    // Para obtener los tipos de parámetros
    private Class<?>[] obtenerTiposParametros(Object... parametros) {
        Class<?>[] tiposParametros = new Class<?>[parametros.length];
        for (int i = 0; i < parametros.length; i++) {
            tiposParametros[i] = parametros[i].getClass();
        }
        return tiposParametros;
    }

    // Para obtener el bean del mapa o cargarlo desde el contexto de Spring
    private Object obtenerBean(String nombreClase) {
        return beanMap.computeIfAbsent(nombreClase, applicationContext::getBean);
    }

    @Override
    public ResponseDto consultaDeuda(RequestDto requestDto) {
        ResponseDto responseDto = null;
        try {
            responseDto = (ResponseDto) routeService(requestDto.getServiceName(), CONSULTADEUDA.getValue(), requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido ({}), Error: \n\r {} ", requestDto.getServiceName(), ex.getLocalizedMessage());
        }
        BPTransactionRepository.save(new BPTransaction(1L, CONSULTADEUDA.getValue()));
        return responseDto;
    }

    @Override
    public ResponseDto consultaDeudas(RequestDto requestDto) {
        log.info("ApiRouter, consultandos a " + requestDto);
        try {
            routeService(requestDto.getServiceName(), CONSULTADEUDAS.getValue(), requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe (%s), Error: \n\r %s ", requestDto.getBillerName(), ex.toString() );
        }

        BPTransactionRepository.save(new BPTransaction(1L, CONSULTADEUDAS.getValue()));
        return null;
    }

    @Override
    public ResponseDto directa(RequestDto requestDto) {
        log.info("ApiRouter, directa a:\n " + requestDto);
        try {
            routeService(requestDto.getServiceName(), DIRECTA.getValue(), requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe (%s), Error: \n\r %s ", requestDto.getBillerName(), ex.toString() );
        }

        BPTransactionRepository.save(new BPTransaction(1L, DIRECTA.getValue()));
        return null;
    }

    @Override
    public ResponseDto consultaEstado(RequestDto requestDto) {
        log.info("ApiRouter, directa a:\n " + requestDto);
        try {
            routeService(requestDto.getServiceName(), CONSULTAESTADO.getValue(), requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe (%s), Error: \n\r %s ", requestDto.getBillerName(), ex.toString() );
        }

        BPTransactionRepository.save(new BPTransaction(1L, CONSULTAESTADO.getValue()));
        return null;
    }

    @Override
    public ResponseDto reversa(RequestDto requestDto) {
        log.info("ApiRouter, directa a:\n " + requestDto);
        try {
            routeService(requestDto.getServiceName(), REVERSA.getValue(), requestDto);
        }catch (Exception ex){
            log.info("Error el servicio requerido no existe (%s), Error: \n\r %s ", requestDto.getBillerName(), ex.toString() );
        }

        BPTransactionRepository.save(new BPTransaction(1L, REVERSA.getValue()));
        return null;
    }
}
