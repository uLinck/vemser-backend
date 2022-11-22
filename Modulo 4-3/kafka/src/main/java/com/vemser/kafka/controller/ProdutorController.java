package com.vemser.kafka.controller;

import com.vemser.kafka.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/enviar")
    public void enviarMensagem(String mensagem) {
        produtorService.enviarMensagem(mensagem);
    }

}
