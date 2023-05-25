package com.example.demo.service.rabbitMQ.accountUser;

import com.example.demo.controller.accountUser.dto.*;
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
import java.util.ArrayList;
import java.util.List;

@Component
@EnableRabbit
@AllArgsConstructor
@NoArgsConstructor
public class ServiceSendUserRequest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public String convertBodytoToString(UserDto userDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(userDto);
    }

    public UserResponseDTO createUser(UserDto userDto) throws JsonProcessingException {
        /*rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("plantaFila","Alerta", sensorsDto);
        rabbitTemplate.convertAndSend("plantaFila","Registro", sensorsDto);*/
        return new UserResponseDTO(45, "Pau","lmm","45-78-88");
    }
    public List<AccountResponseDTO> consultAccounts(int idDocument) throws JsonProcessingException {
        /*rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("plantaFila","Alerta", sensorsDto);
        rabbitTemplate.convertAndSend("plantaFila","Registro", sensorsDto);*/
        List<AccountResponseDTO> lista= new ArrayList<>();
        AccountResponseDTO account1=new AccountResponseDTO(2,"corriente",2345,"22-33-44",45);
        AccountResponseDTO account2=new AccountResponseDTO(3,"ahorros",2365,"22-83-44",47);
        lista.add(account1);
        lista.add(account2);
        return lista;
    }
    public List<UserResponseDTO> getUsers() throws JsonProcessingException {
        /*rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        rabbitTemplate.convertAndSend("plantaFila","Alerta", sensorsDto);

        rabbitTemplate.convertAndSend("plantaFila","Registro", sensorsDto);*/
        System.out.println("Holaaaa");

        List<UserResponseDTO> lista= new ArrayList<>();
        UserResponseDTO user1=new UserResponseDTO(23,"pepito", "perez","100-23-45");
        UserResponseDTO user2=new UserResponseDTO(45,"lupe","gutierrez","45-67-89");
        lista.add(user1);
        lista.add(user2);
        return lista;
    }

    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
