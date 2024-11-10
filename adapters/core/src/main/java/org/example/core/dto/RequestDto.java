package org.example.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class RequestDto {
    private String billerName;
    private String codigoPais;
    private String codigoMoneda;
    private String fechaHoraFe;
    private String idCaja;
    private String idOperador;
    private String idTerminal;
    private String idTransaccionFe;
    private String importe;
    private String plataforma;
    private String productoUtilityCode;
    private String serviceName;

}
