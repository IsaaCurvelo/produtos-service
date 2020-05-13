package com.example.produtosservice.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Estoque {

    private Long id;

    private Filial filial;

    private Produto produto;

    private Long quantidade;

}
