package com.manu.crud_generator.generators;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
public class GeneratorService {

    public void generarCodigoService(String nombreClase, String rutaPaquetes) {

        // Inicializar Velocity
        Velocity.init();
        log.info("generando repositorio...");
        // Crear un contexto Velocity
        VelocityContext contexto = new VelocityContext();
        contexto.put("nombreClase", nombreClase);
        contexto.put("rutaPaquetes", rutaPaquetes.substring(0, rutaPaquetes.lastIndexOf('.')));

        // Cargar la plantilla
        Template plantilla = Velocity.getTemplate("src/main/resources/templates/Service.vm");

        // Procesar la plantilla y escribir el código en un archivo
        try {
            // Directorio de salida
            String directorioSalida = "src/main/java/com/manu/crud_generator/services/";
            // Nombre del archivo
            String nombreArchivo = nombreClase + "Service.java";
            log.info("generando service: " + nombreArchivo);
            // Crear directorios si no existen
            new File(directorioSalida).mkdirs();

            // Crear el archivo de salida
            FileWriter escritor = new FileWriter(directorioSalida + nombreArchivo);

            // Procesar la plantilla y escribir el código en el archivo
            plantilla.merge(contexto, escritor);

            // Cerrar el escritor
            escritor.flush();
            escritor.close();

            log.info("Service generado exitosamente: " + directorioSalida + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
