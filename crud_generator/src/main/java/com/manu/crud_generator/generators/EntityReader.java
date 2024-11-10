package com.manu.crud_generator.generators;

import jakarta.persistence.Entity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class EntityReader {

    public List<Class<?>> leerEntidades(String directorio) {
        List<Class<?>> entidades = new ArrayList<>();
        log.info("Leyendo entidades.. " + directorio);
        try {
            // Obtener la lista de archivos en el directorio de clases
            File directorioClases = new File(directorio);
            List<File> archivos = (List<File>) FileUtils.listFiles(directorioClases, new String[] {"java"}, true);
            log.info("Leyendo " + directorioClases.getAbsolutePath());
            log.info("Tenemos "+ archivos.size()+" archivos");
            // Cargar las clases
            for (File archivo : archivos) {


                String nombreArchivo = archivo.getName();
                String nombreClase = nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.'));
                String nombreCompletoClase = directorio.replace(File.separatorChar, '.') + nombreClase;
                log.info("Procesando " + nombreArchivo);
                log.info("nombreClase " + nombreClase);
                log.info("nombreCompletoClase " + nombreCompletoClase);

                // Cargar la clase utilizando el cargador de clases
                Class<?> clase = Class.forName("com.manu.crud_generator.entities."+nombreClase);

                // Verificar si la clase tiene anotaciones que la identifiquen como una entidad
                // Por ejemplo, podrías tener una anotación personalizada como @Entidad
                // Si la clase tiene esta anotación, la agregamos a la lista de entidades
                if (clase.isAnnotationPresent(Entity.class)) {
                    entidades.add(clase);
                }
            }
        } catch (ClassNotFoundException | UncheckedIOException e) {
            log.error("No se pudo leer las entidades: " + e.getCause());
            e.printStackTrace();
        }

        return entidades;
    }
}
