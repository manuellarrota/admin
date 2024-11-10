package com.manu.crud_generator.utils.controller;


import com.manu.crud_generator.utils.dto.GenericErrorDto;
import com.manu.crud_generator.utils.service.CustomCrudService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface CustomCrudRestController<T, DTO, S extends CustomCrudService<T,DTO>>{

    @PostMapping("/save")
    ResponseEntity<DTO> save(@ModelAttribute("dto") @Valid DTO dto, BindingResult result) throws GenericErrorDto;

    @GetMapping("/{id}")
    ResponseEntity<DTO> get(@PathVariable Long id, BindingResult result) throws GenericErrorDto;

    @GetMapping("/getall")
    ResponseEntity<Page<DTO>> getAll(Pageable pageable) throws GenericErrorDto;

    @PostMapping("/update")
    ResponseEntity<DTO> update(@ModelAttribute("dto")@Valid DTO dto, BindingResult result) throws GenericErrorDto;

    @PostMapping("/delete")
    ResponseEntity<String> delete(@ModelAttribute("id") String id) throws GenericErrorDto;


}