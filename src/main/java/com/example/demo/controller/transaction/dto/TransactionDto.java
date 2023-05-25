package com.example.demo.controller.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;

@Data
@AllArgsConstructor
@Generated
public class TransactionDto {
    private int id;
    private int origen;
    private int destination;
    private int amount;

}