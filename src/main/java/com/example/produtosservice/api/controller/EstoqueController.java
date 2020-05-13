package com.example.produtosservice.api.controller;

import com.example.produtosservice.domain.mapper.EstoqueMapper;
import com.example.produtosservice.domain.model.Estoque;
import com.example.produtosservice.domain.service.EstoqueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("estoques")
public class EstoqueController {

    @Autowired
    private EstoqueMapper estoqueMapper;

    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> listar() {
        return estoqueMapper.listar();
    }

    @GetMapping("/{id}")
    public Estoque buscar(@PathVariable Long id) {
        return estoqueMapper.porId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estoque cadastrar(@RequestBody Estoque estoque) {
        this.estoqueService.cadastrarEstoqueEEnviarMensagem(estoque);
        return estoque;
    }

    @PutMapping("/{estoqueId}")
    public Estoque atualizar(@RequestBody Estoque estoque, @PathVariable Long estoqueId) {
        Estoque estoqueExistente = this.estoqueMapper.porId(estoqueId);
        BeanUtils.copyProperties(estoque, estoqueExistente, "id");
        this.estoqueMapper.atualizar(estoqueExistente);
        return estoqueExistente;
    }
}
