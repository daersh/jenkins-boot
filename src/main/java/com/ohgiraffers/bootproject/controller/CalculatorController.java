package com.ohgiraffers.bootproject.controller;


import com.ohgiraffers.bootproject.dto.CalculatorDTO;
import com.ohgiraffers.bootproject.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CalculatorController {

    CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("")
    public ResponseEntity<String> health_check(){
        System.out.println("통신 완료~");
        String a = "ACK!!!!";
        return ResponseEntity.ok().body(a);
    }

    @GetMapping("/plus")
    public ResponseEntity<CalculatorDTO> plus(@ModelAttribute CalculatorDTO calculatorDTO){
        System.out.println("통신 완료");

        CalculatorDTO result = calculatorService.plus(calculatorDTO);

        return ResponseEntity.ok().body(result);
    }

}
