package com.example.produtosservice.api.controller;

import com.example.produtosservice.domain.mapper.ProdutoMapper;
import com.example.produtosservice.domain.model.Produto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoMapper produtoMapper;

    @GetMapping
    public List<Produto> listar() {
        return produtoMapper.listar();
    }

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        return produtoMapper.porId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar(@RequestBody Produto produto) {
        this.produtoMapper.inserir(produto);
        return produto;
    }

    @PutMapping("/{produtoId}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Long produtoId) {
        Produto produtoExistente = this.produtoMapper.porId(produtoId);
        BeanUtils.copyProperties(produto, produtoExistente, "id");
        this.produtoMapper.atualizar(produtoExistente);
        return produtoExistente;
    }
}
