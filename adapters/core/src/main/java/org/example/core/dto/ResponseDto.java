package org.example.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ResponseDto {
    private Long codigoError;
    private String descripcionError;
    private String fechaHoraRespBiller;
    private String pagoOperacionNumero;
}
