package org.example.core.enums;

public enum Methods {
    CONSULTADEUDA("consultaDeuda"), CONSULTADEUDAS("consultaDeudas"), DIRECTA("directa"),
    CONSULTAESTADO("consultaEstado"), REVERSA("reversa");
    private String value;

    Methods(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
