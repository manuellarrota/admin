package org.example.service;

/**
 * Abstraccion de api
 *
 * @param <REQUEST> Clase tipo request
 * @param <RESPONSE> Clase tipo response
 */
public interface ApiConsumeService <REQUEST, RESPONSE>{

    RESPONSE  consultaDeuda(REQUEST request);
    RESPONSE  consultaDeudas(REQUEST request);
    /**
     * Realiza el pago de un producto o servicio
     */
    RESPONSE directa(REQUEST request);
    RESPONSE consultaEstado(REQUEST request);
    RESPONSE reversa(REQUEST request);
}
