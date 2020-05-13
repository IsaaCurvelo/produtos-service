package com.example.produtosservice.domain.mapper;

import com.example.produtosservice.domain.model.Produto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProdutoMapper {

    void inserir(Produto produto);

    void atualizar(Produto produto);

    Produto porId(Long id);

    List<Produto> listar();

}
