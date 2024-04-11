package com.ohgiraffers.bootproject.dto;


import lombok.Builder;
import lombok.Data;

@Data
public class CalculatorDTO {
    private int num1;
    private int num2;
    private int sum;

    public CalculatorDTO(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}
