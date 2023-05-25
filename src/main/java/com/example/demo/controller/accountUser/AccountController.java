package com.example.demo.controller.accountUser;

import com.example.demo.controller.accountUser.dto.AccountDTO;
import com.example.demo.controller.accountUser.dto.AccountResponseDTO;
import com.example.demo.service.rabbitMQ.accountUser.ServiceSendAccountRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    @Autowired
    private ServiceSendAccountRequest serviceSendAccountRequest;

    @PostMapping(path = "/account/savings-account")
    public AccountResponseDTO createAccount(@RequestBody AccountDTO accountDto) throws JsonProcessingException{
        System.out.println("Create account");
        return serviceSendAccountRequest.insertAccount(accountDto);
    }

    @GetMapping(path = "/account/check-balance/{idAccount}")
    public AccountResponseDTO checkBalance(@PathVariable int idAccount) throws JsonProcessingException {
        return serviceSendAccountRequest.checkBalance(idAccount);
    }

}