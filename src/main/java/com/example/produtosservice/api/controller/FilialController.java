package com.example.produtosservice.api.controller;

import com.example.produtosservice.domain.mapper.FilialMapper;
import com.example.produtosservice.domain.model.Filial;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("filiais")
public class FilialController {

    @Autowired
    private FilialMapper filialMapper;

    @GetMapping
    public List<Filial> listar() {
        return filialMapper.listar();
    }

    @GetMapping("/{id}")
    public Filial buscar(@PathVariable Long id) {
        return filialMapper.porId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Filial cadastrar(@RequestBody Filial filial) {
        this.filialMapper.inserir(filial);
        return filial;
    }

    @PutMapping("/{filialId}")
    public Filial atualizar(@RequestBody Filial filial, @PathVariable Long filialId) {
        Filial filialExistente = this.filialMapper.porId(filialId);
        BeanUtils.copyProperties(filial, filialExistente, "id");
        this.filialMapper.atualizar(filialExistente);
        return filialExistente;
    }
}
