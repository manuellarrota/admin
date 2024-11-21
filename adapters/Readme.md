# Adapters:

    Proyecto que une los conectores en un solo ejecutable con el fin de escalar hroizontalmente.

# Estructura:

## App:

    Modulo ejecutable, este expone las funciones basicas de un conector consultas, directa y reversa. Consume a Billers 
    como dependencia.

## Billers:
    
    Modulo que funciona como libreria, tiene la logica de todos los conectores y dependiendo del mensaje ejecuta las rutinas
    correspondientes respecto al biller a comunicar.

## Core 

    Modulo que contiene las clases en comun y de acceso a los datos, entidades y repositorios.

### Tabla de servicios:
    En esta tabla se puede obtener la palabra clave para ir al servicio de interes donde la palabra clave es el nombre 
    ServiceImpl. Cuando el ApiRouterServiceImpl en el medodo routeService recibe la palabra clave puede ejecutar el Bean 
    con el nombre del servicio recibido.

####  Tabla de servicios y su nombre en la app

| Nombre servicio        | Palabra a enviar    |
|------------------------|---------------------|
| PERSONAL DEUDA BAJA ML | personalDeudasBajas |
| MercadoPago CashOut    | mercadoPagoCashOut  |
| MercadoPago PrePaid    | mercadoPrePaid      |
