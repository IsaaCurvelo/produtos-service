package com.example.produtosservice.domain.service;

import com.example.produtosservice.ProdutosServiceApplication;
import com.example.produtosservice.domain.mapper.EstoqueMapper;
import com.example.produtosservice.domain.model.Estoque;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstoqueService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    EstoqueMapper estoqueMapper;

    @Transactional
    public void cadastrarEstoqueEEnviarMensagem(Estoque estoque) {

        estoqueMapper.inserir(estoque);

        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(ProdutosServiceApplication.topicExchangeName,
                "lancamento.nota",
                estoque.getId());
    }

}
