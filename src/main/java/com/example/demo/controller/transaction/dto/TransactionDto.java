package com.example.demo.controller.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class TransactionDto {
    private int id;
    private int origen;
    private int destination;
    private int amount;

}