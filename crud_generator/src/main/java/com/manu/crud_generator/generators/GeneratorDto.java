package com.manu.crud_generator.generators;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class GeneratorDto {

    public void generarCodigoDto(String nombreClase, String rutaPaquetes) throws ClassNotFoundException {
        Velocity.init();
        log.info("generando dto...");
        // Crear un contexto Velocity
        VelocityContext contexto = new VelocityContext();

        contexto.put("nombreClase", nombreClase);
        contexto.put("rutaPaquetes", rutaPaquetes.substring(0, rutaPaquetes.lastIndexOf('.')));
        contexto.put("attributes", getAttributesFromEntity(Class.forName(rutaPaquetes+"."+nombreClase)));
        // Cargar la plantilla
        Template plantilla = Velocity.getTemplate("src/main/resources/templates/Dto.vm");

        // Procesar la plantilla y escribir el código en un archivo
        try {
            // Directorio de salida
            String directorioSalida = "src/main/java/com/manu/crud_generator/dtos/";
            // Nombre del archivo
            String nombreArchivo = nombreClase + "Dto.java";
            log.info("generando dto: " + nombreArchivo);
            // Crear directorios si no existen
            new File(directorioSalida).mkdirs();

            // Crear el archivo de salida
            FileWriter escritor = new FileWriter(directorioSalida + nombreArchivo);

            // Procesar la plantilla y escribir el código en el archivo
            plantilla.merge(contexto, escritor);

            // Cerrar el escritor
            escritor.flush();
            escritor.close();

            log.info("Repositorio generado exitosamente: " + directorioSalida + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Map<String, String>> getAttributesFromEntity(Class<?> entityClass) {
        List<Map<String, String>> attributes = new ArrayList<>();

        // Itera sobre todos los campos de la clase
        for (Field field : entityClass.getDeclaredFields()) {
            Map<String, String> attribute = new HashMap<>();
            attribute.put("name", field.getName());
            attribute.put("type", field.getType().getSimpleName()); // Para obtener el nombre del tipo como String
            attributes.add(attribute);
        }

        return attributes;
    }

}
