package com.example.produtosservice.domain.mapper;

import com.example.produtosservice.domain.model.Estoque;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EstoqueMapper {

    void inserir(Estoque estoque);

    void atualizar(Estoque estoque);

    Estoque porId(Long id);

    List<Estoque> listar();

}
