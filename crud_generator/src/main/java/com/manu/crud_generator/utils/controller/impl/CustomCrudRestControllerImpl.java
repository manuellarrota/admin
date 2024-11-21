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
public class CustomCrudRestControllerImpl<T, D, S extends CustomCrudService<T, D>> implements CustomCrudRestController<T, D, S> {

    final S service;

    @Autowired
    public CustomCrudRestControllerImpl(S service) {
        this.service = service;
    }


    @Override
    public ResponseEntity<D> save(D d, BindingResult result) throws GenericErrorDto {
        log.info("Save " + d);
        if (result.hasErrors()) {
            log.error(result.toString());
            return (ResponseEntity<D>) ResponseEntity.badRequest();
        }
        try {
            d = service.saveDto(d);
        } catch (Exception|Error e) {
            log.error(e.toString());
            return (ResponseEntity<D>) ResponseEntity.unprocessableEntity();
        }
        log.info("Saved " + d);
        return ResponseEntity.ok(d);
    }

    @Override
    public ResponseEntity<D> get(Long id, BindingResult result) throws GenericErrorDto {
        D dResponse;
        try{
            dResponse = service.getByIdDto(id);
        }catch (Exception|Error e) {
            log.error(e.toString());
            return (ResponseEntity<D>) ResponseEntity.unprocessableEntity();
        }
        return ResponseEntity.ok(dResponse);
    }


    @Override
    public ResponseEntity<Page<D>> getAll(Pageable pageable) throws GenericErrorDto {
        return ResponseEntity.ok(service.getAllDto(pageable));
    }

    @Override
    public ResponseEntity<D> update(D d, BindingResult result) throws GenericErrorDto {
        log.info("Update " + d);
        if (result.hasErrors()) {
            log.error(result.toString());
            return (ResponseEntity<D>) ResponseEntity.badRequest();
        }
        try {
            d = service.updateDto(d);
        } catch (Exception|Error e) {
            log.error(e.toString());
            return (ResponseEntity<D>) ResponseEntity.unprocessableEntity();
        }
        log.info("Updated " + d);
        return  ResponseEntity.ok(d);
    }

    @Override
    public ResponseEntity<String> delete(String id) throws GenericErrorDto {
        return ResponseEntity.ok("ok");
    }
}
