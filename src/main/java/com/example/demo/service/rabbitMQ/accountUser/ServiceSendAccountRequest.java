package com.example.demo.service.rabbitMQ.accountUser;

import com.example.demo.controller.accountUser.dto.AccountDTO;
import com.example.demo.controller.accountUser.dto.AccountResponseDTO;
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
public class ServiceSendAccountRequest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public String convertBodytoToString(AccountDTO accountDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(accountDTO);
    }

    public AccountResponseDTO insertAccount(AccountDTO accountDTO) throws JsonProcessingException {
        /*rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("plantaFila","Alerta", sensorsDto);
        rabbitTemplate.convertAndSend("plantaFila","Registro", sensorsDto);*/
        //Comentario de prueba
        return new AccountResponseDTO(2,"corriente",5678,"22-233-44",12);
    }
    public AccountResponseDTO checkBalance (int idAccount) throws JsonProcessingException {
        //COmentario prueba
        System.out.println("Hola");
        /*rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("plantaFila","Alerta", sensorsDto);
        rabbitTemplate.convertAndSend("plantaFila","Registro", sensorsDto);*/
        return new AccountResponseDTO(34,"ahorros",78900,"45-78-78",23);
    }
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
