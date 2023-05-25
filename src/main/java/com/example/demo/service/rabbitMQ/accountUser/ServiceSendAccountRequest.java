package com.example.demo.service.rabbitMQ.accountUser;

import com.example.demo.controller.accountUser.dto.AccountDTO;
import com.example.demo.controller.accountUser.dto.AccountResponseDTO;
import com.example.demo.controller.accountUser.dto.UserResponseDTO;
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
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@EnableRabbit
@AllArgsConstructor
public class ServiceSendAccountRequest {
    RestTemplate restTemplate;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public String convertBodytoToString(AccountDTO accountDTO) throws JsonProcessingException {
        return objectMapper.writeValueAsString(accountDTO);
    }

    public void insertAccount(AccountDTO accountDTO) throws JsonProcessingException {
        System.out.println("Hola");
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("accountUserExchange","account", accountDTO);

    }
    public AccountResponseDTO checkBalance (int idAccount) throws JsonProcessingException {
        AccountResponseDTO accountResponseDTO;
        accountResponseDTO= restTemplate.getForObject("http://localhost:8081/account/check-balance/"+idAccount,AccountResponseDTO.class);
        return accountResponseDTO;
    }
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
