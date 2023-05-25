package com.example.demo.controller.accountUser;

import com.example.demo.controller.accountUser.dto.UserResponseDTO;
import com.example.demo.controller.accountUser.dto.UserDto;
import com.example.demo.controller.accountUser.dto.AccountResponseDTO;
import com.example.demo.service.rabbitMQ.accountUser.ServiceSendUserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private ServiceSendUserRequest serviceSendUserRequest;

    @PostMapping(path = "/user/savings-user")
    public UserResponseDTO createUser(@RequestBody UserDto userDto) throws JsonProcessingException {
        return serviceSendUserRequest.createUser(userDto);
    }
    @GetMapping(path = "/user/check-accounts/{idDocument}")
    public List<AccountResponseDTO> getAllAccounts(@PathVariable int idDocument) throws JsonProcessingException {
        return serviceSendUserRequest.consultAccounts(idDocument);
    }

    @GetMapping(path = "/user/all-Users")
    public List<UserResponseDTO> getAllUsers() throws JsonProcessingException {
        return serviceSendUserRequest.getUsers();
    }

}