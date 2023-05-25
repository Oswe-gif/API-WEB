package com.example.demo.controller.accountUser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Generated
public class UserResponseDTO {
    private Integer document;
    private String name;
    private String lastName;
    private String dateCreated;
}