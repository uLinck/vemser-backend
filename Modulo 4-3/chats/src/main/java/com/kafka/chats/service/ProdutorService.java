package com.kafka.chats.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.chats.NomeChat;
import com.kafka.chats.dto.MensagemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    @Value(value = "${spring.kafka.consumer.client-id}")
    private String usuario;

    public void enviarMensagem(List<NomeChat> nomeChatList, String mensagem) throws JsonProcessingException {
        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setUsuario(usuario);
        mensagemDTO.setMensagem(mensagem);
        mensagemDTO.setDataCriacao(LocalDateTime.now());

        String mensagemStr = objectMapper.writeValueAsString(mensagemDTO);

        for(NomeChat nome : nomeChatList) {

            MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagemStr)
                    .setHeader(KafkaHeaders.TOPIC, nome.getTopico())
                    .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                    .setHeader(KafkaHeaders.PARTITION_ID, nome.getParticao());

            Message<String> message = stringMessageBuilder.build();
            ListenableFuture<SendResult<String, String>> enviadoParaTopico = kafkaTemplate.send(message);

            enviadoParaTopico.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onSuccess(SendResult result) {
                    log.info(" Log enviado para o kafka com o texto: {} ", mensagem);
                }

                @Override
                public void onFailure(Throwable ex) {
                    log.error(" Erro ao publicar duvida no kafka com a mensagem: {}", mensagem, ex);
                }
            });
        }
    }
}
