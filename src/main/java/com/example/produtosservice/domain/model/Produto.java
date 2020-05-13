package com.example.produtosservice.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Produto {

    private Long id;
    private String nome;
    private BigDecimal preco;

}
