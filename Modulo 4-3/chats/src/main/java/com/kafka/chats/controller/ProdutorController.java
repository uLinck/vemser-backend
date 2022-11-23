package com.kafka.chats.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.chats.NomeChat;
import com.kafka.chats.dto.MensagemDTO;
import com.kafka.chats.service.ProdutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {

    private final ProdutorService produtorService;

    @PostMapping("/send-to")
    public void sendTo(@RequestParam List<NomeChat> chats, @RequestParam String mensagem) throws JsonProcessingException {
            produtorService.enviarMensagem(chats, mensagem);
    }
}