package com.manu.crud_generator.controllers;

import com.manu.crud_generator.entities.BPTraza;
import com.manu.crud_generator.services.BPTrazaService;
import com.manu.crud_generator.dtos.BPTrazaDto;
import com.manu.crud_generator.utils.controller.impl.CustomCrudRestControllerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;

@Controller
@RequestMapping(value = "BPTraza")
public class BPTrazaController extends CustomCrudRestControllerImpl<BPTraza, BPTrazaDto, BPTrazaService>
{

    public BPTrazaController(BPTrazaService service) {
            super(service);
        }
}
