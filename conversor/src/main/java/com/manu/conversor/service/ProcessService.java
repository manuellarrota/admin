package com.manu.conversor.service;

import java.util.List;

public interface ProcessService<R, D> {
    List<R> consulta();
    R consulta(String parametro);

    R directa(D directa);


}
