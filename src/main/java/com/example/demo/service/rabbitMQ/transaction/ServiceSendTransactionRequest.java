package com.example.demo.service.rabbitMQ.transaction;

import com.example.demo.controller.transaction.dto.DepositMoneyUserDto;
import com.example.demo.controller.transaction.dto.TransactionDto;
import com.example.demo.controller.transaction.dto.TransactionResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
@AllArgsConstructor
@NoArgsConstructor
public class ServiceSendTransactionRequest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public String convertBodytoToString(TransactionDto transactionDto) throws JsonProcessingException {
        System.out.println("Hola");
        return objectMapper.writeValueAsString(transactionDto);
    }

    public TransactionResponseDTO sendTransactionRequest(TransactionDto transactionDto) throws JsonProcessingException {
        System.out.println("Hola");
        /*rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("plantaFila","Alerta", sensorsDto);
        rabbitTemplate.convertAndSend("plantaFila","Registro", sensorsDto);*/
        return new TransactionResponseDTO(1,2,3, 56789);
    }
    public DepositMoneyUserDto sendDepositRequest (DepositMoneyUserDto depositMoneyUserDto) throws JsonProcessingException {
        /*rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("plantaFila","Alerta", sensorsDto);
        rabbitTemplate.convertAndSend("plantaFila","Registro", sensorsDto);*/
        return new DepositMoneyUserDto(1,2);
    }
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}