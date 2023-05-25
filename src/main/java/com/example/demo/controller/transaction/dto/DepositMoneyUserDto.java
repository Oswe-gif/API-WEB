package com.example.demo.controller.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class DepositMoneyUserDto {
    private int moneyAmount;
    private int accountNumber;
}