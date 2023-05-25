package com.example.demo.controller.accountUser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class AccountDTO {
    private int id;
    private String type;
    private int money=0;
    private String dateCreated;
    private int user;

}