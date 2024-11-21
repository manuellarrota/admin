package com.manu.crud_generator;

import com.manu.crud_generator.generators.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.util.List;

@Slf4j
@Mojo(name = "generate")
public class GenerateMojo extends AbstractMojo{

    @Parameter(defaultValue = "${project.basedir}/src/main/java", property = "sourceDirectory", required = true)
    private File sourceDirectory;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        log.info("Comenzando leyendo entidades");
        // Directorio donde se encuentran las clases de entidad
        String directorioEntidades = "src/main/java/com/manu/crud_generator/entities/";
        EntityReader lectorEntidades = new EntityReader();
        List<Class<?>> entidades = lectorEntidades.leerEntidades(directorioEntidades);

        // Crear instancia del generador de repositorios
        GeneratorRepository generadorRepositorio = new GeneratorRepository();
        GeneratorDto generatorDto = new GeneratorDto();
        GeneratorService generatorService = new GeneratorService();
        GeneratorServiceImpl generatorServiceImpl = new GeneratorServiceImpl();
        GeneratorCotroller generatorCotroller = new GeneratorCotroller();

        // Iterar sobre las clases de entidad y generar repositorios
        for (Class<?> entidad : entidades) {
            log.info("Procesando entidad: " + entidad.getName());
            // Obtener el nombre de la clase de entidad
            String nombreClase = entidad.getSimpleName();

            // Generar el repositorio para la clase de entidad actual
            generadorRepositorio.generarCodigoRepositorio(nombreClase, "id", entidad.getPackageName()); // Aquí podrías especificar el campo clave primaria
            try {
                generatorDto.generarCodigoDto(nombreClase, entidad.getPackageName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            generatorService.generarCodigoService(nombreClase, entidad.getPackageName());
            generatorServiceImpl.generarCodigoServiceImpl(nombreClase, entidad.getPackageName());
            generatorCotroller.generarControllers(nombreClase, entidad.getPackageName());
        }
    }
}
