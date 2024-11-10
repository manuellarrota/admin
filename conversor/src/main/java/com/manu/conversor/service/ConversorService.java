package com.manu.conversor.service;

import java.util.List;

public interface ConversorService<R,T> {
    T consulta(R request);
    List<T> consultaListado(R request);
    T directa(R request);

    T reversa(R request);
}
