package com.manu.crud_generator.controllers;

import com.manu.crud_generator.entities.BPTransaction;
import com.manu.crud_generator.services.BPTransactionService;
import com.manu.crud_generator.dtos.BPTransactionDto;
import com.manu.crud_generator.utils.controller.impl.CustomCrudRestControllerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.modelmapper.ModelMapper;

@Controller
@RequestMapping(value = "BPTransaction")
public class BPTransactionController extends CustomCrudRestControllerImpl<BPTransaction, BPTransactionDto, BPTransactionService>
{

    public BPTransactionController(BPTransactionService service) {
            super(service);
        }
}
