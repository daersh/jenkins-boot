package com.ohgiraffers.bootproject.controller;

import com.ohgiraffers.bootproject.dto.CalculatorDTO;
import com.ohgiraffers.bootproject.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorControllerTests {
    @Autowired
    private CalculatorService calculatorService;

    /* 설명. 테스트코드의 "given"에 해당*/
    private static Stream<Arguments> provideDTOSource(){
        return Stream.of(
                Arguments.of(new CalculatorDTO(1,2)),
                Arguments.of(new CalculatorDTO(3,5)),
                Arguments.of(new CalculatorDTO(10,-2))
        );
    }

    @DisplayName("두 수의 합 구하기 테스트")
    @ParameterizedTest      // 여러가지 테스트 케이스를 한번에 하기 위해 기존 "@TEST" 대신 이걸 사용함
    @MethodSource("provideDTOSource")
    void testPlus(CalculatorDTO input){
        //when
        int expected = input.getNum1()+input.getNum2();
        //then
        int actual = calculatorService.plus(input).getSum();
        assertEquals(expected,actual);

    }




}