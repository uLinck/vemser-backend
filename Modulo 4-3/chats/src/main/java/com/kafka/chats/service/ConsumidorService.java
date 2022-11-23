package com.kafka.chats.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.chats.dto.MensagemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {

    private static final String ROXO = "\u001B[35m";

    private static final String RESET = "\u001B[0m";

    private final ObjectMapper objectMapper;

    @KafkaListener(
            clientIdPrefix = "${spring.kafka.consumer.client-id}",
            groupId = "${spring.kafka.consumer.group-id}",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic.chat1}", partitions = {"0"})}
    )
    public void consumirTodasMensagensGeral(@Payload String mensagem,
                                           @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                           @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                           @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO myMessage = objectMapper.readValue(mensagem, MensagemDTO.class);

        log.info(ROXO+"{} {}: {}"+RESET,
                myMessage.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")),
                myMessage.getUsuario(),
                myMessage.getMensagem());
    }

    @KafkaListener(
            clientIdPrefix = "${spring.kafka.consumer.client-id}" + "private",
            groupId = "${spring.kafka.consumer.group-id}",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic.chat1}", partitions = {"4"})}
    )
    public void consumirChatIndividual(@Payload String mensagem,
                                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                       @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO myMessage = objectMapper.readValue(mensagem, MensagemDTO.class);

        log.info("{} {}(privada): {}",
                myMessage.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")),
                myMessage.getUsuario(),
                myMessage.getMensagem());
    }

}
