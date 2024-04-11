package com.ohgiraffers.bootproject.service;

import com.ohgiraffers.bootproject.dto.CalculatorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public CalculatorDTO plus(CalculatorDTO calculatorDTO) {
        calculatorDTO.setSum(calculatorDTO.getNum1()+calculatorDTO.getNum2());
        System.out.println("calculatorDTO = " + calculatorDTO);
        return calculatorDTO;
    }



}
