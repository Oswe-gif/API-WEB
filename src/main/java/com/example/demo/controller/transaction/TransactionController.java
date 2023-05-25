package com.example.demo.controller.transaction;

import com.example.demo.service.rabbitMQ.transaction.ServiceSendTransactionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.demo.controller.transaction.dto.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {

    @Autowired
    private ServiceSendTransactionRequest serviceSendTransactionRequest;

    @PostMapping(path="/transaction/transfer-money")
    public TransactionResponseDTO doTransaction (@RequestBody TransactionDto transactionDto) throws JsonProcessingException {
        System.out.println("Transaction");
        return serviceSendTransactionRequest.sendTransactionRequest(transactionDto);
    }

    @PostMapping(path="/transaction/deposit-money")
    public DepositMoneyUserDto depositMoney (@RequestBody  DepositMoneyUserDto depositMoneyUserDto) throws JsonProcessingException {
        System.out.println("Deposit");
        return serviceSendTransactionRequest.sendDepositRequest(depositMoneyUserDto);
    }
}