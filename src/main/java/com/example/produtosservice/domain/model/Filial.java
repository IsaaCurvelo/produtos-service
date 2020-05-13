package com.example.produtosservice.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filial {

    private Long id;
    private String nome;
    private List<Estoque> estoques;

}
