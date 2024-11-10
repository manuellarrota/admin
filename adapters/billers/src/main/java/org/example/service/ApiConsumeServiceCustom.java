package org.example.service;

/**
 * Abstraccion de api con distintos objetos de respuesta
 *
 * @param <CDRESPONSE>
 * @param <CDREQUEST>
 * @param <CDSRESPONSE>
 * @param <CRSREQUEST>
 * @param <DRESPONSE>
 * @param <DREQUEST>
 * @param <CERESPONSE>
 * @param <CEREQUEST>
 * @param <RRESPONSE>
 * @param <RREQUEST>
 */
public interface ApiConsumeServiceCustom <CDRESPONSE, CDREQUEST, CDSRESPONSE, CRSREQUEST, DRESPONSE, DREQUEST, CERESPONSE, CEREQUEST,RRESPONSE,RREQUEST >{
    CDRESPONSE  consultaDeuda(CDREQUEST request);
    CDSRESPONSE  consultaDeudas(CRSREQUEST request);
    /**
     * Realiza el pago de un producto o servicio
     */
    DRESPONSE directa(DREQUEST request);
    CERESPONSE consultaEstado(CEREQUEST request);
    RRESPONSE reversa(RREQUEST request);
}
