package com.manu.crud_generator.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BPTransactionDto{
            @JsonProperty("${attribute.jsonName}")
        private Long id;
                @JsonProperty("${attribute.jsonName}")
        private String name;
    }