package com.example.demo.service.rabbitMQ.accountUser;

import com.example.demo.controller.accountUser.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
@EnableRabbit
@AllArgsConstructor
public class ServiceSendUserRequest {
    RestTemplate restTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public String convertBodytoToString(UserDto userDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userDto);
    }

    public void createUser(UserDto userDto) throws JsonProcessingException {
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("accountUserExchange","user", userDto);
    }
    public List<AccountResponseDTO> consultAccounts(int idDocument) throws JsonProcessingException {
        List<AccountResponseDTO> lista;
        lista= restTemplate.getForObject("http://localhost:8081/user/check-accounts/"+idDocument,List.class);
        return lista;
    }

    public List<UserResponseDTO> getUsers() throws JsonProcessingException {
        List<UserResponseDTO> lista;
        lista= restTemplate.getForObject("http://localhost:8081/user/all-Users",List.class);
        return lista;
    }

    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
