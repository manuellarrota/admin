package com.manu.crud_generator.utils.controller.impl;



import com.manu.crud_generator.utils.controller.CustomCrudRestController;
import com.manu.crud_generator.utils.dto.GenericErrorDto;
import com.manu.crud_generator.utils.service.CustomCrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

@Slf4j
public class CustomCrudRestControllerImpl<T, DTO, S extends CustomCrudService<T,DTO>> implements CustomCrudRestController<T, DTO, S> {

    final S service;

    @Autowired
    public CustomCrudRestControllerImpl(S service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<DTO> save(DTO dto, BindingResult result) throws GenericErrorDto {
        log.info("Save " + dto);
        if (result.hasErrors()) {
            log.error(result.toString());
            return (ResponseEntity<DTO>) ResponseEntity.badRequest();
        }
        try {
            dto = service.saveDto(dto);
        } catch (Exception|Error e) {
            log.error(e.toString());
            return (ResponseEntity<DTO>) ResponseEntity.unprocessableEntity();
        }
        log.info("Saved " + dto);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<DTO> get(Long id, BindingResult result) throws GenericErrorDto {
        DTO dtoResponse;
        try{
            dtoResponse = service.getByIdDto(id);
        }catch (Exception|Error e) {
            log.error(e.toString());
            return (ResponseEntity<DTO>) ResponseEntity.unprocessableEntity();
        }
        return ResponseEntity.ok(dtoResponse);
    }


    @Override
    public ResponseEntity<Page<DTO>> getAll(Pageable pageable) throws GenericErrorDto {
        return ResponseEntity.ok(service.getAllDto(pageable));
    }

    @Override
    public ResponseEntity<DTO> update(DTO dto, BindingResult result) throws GenericErrorDto {
        log.info("Update " + dto);
        if (result.hasErrors()) {
            log.error(result.toString());
            return (ResponseEntity<DTO>) ResponseEntity.badRequest();
        }
        try {
            dto = service.updateDto(dto);
        } catch (Exception|Error e) {
            log.error(e.toString());
            return (ResponseEntity<DTO>) ResponseEntity.unprocessableEntity();
        }
        log.info("Updated " + dto);
        return  ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<String> delete(String id) throws GenericErrorDto {
        return ResponseEntity.ok("ok");
    }
}
