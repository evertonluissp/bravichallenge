package com.evertonluissp.bravichallenge.services;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig(classes = BracketsService.class)
public class BracketsServiceTest {

    @Autowired
    private BracketsService service;

    @ParameterizedTest
    @ValueSource(strings = {
            "()",
            "{}",
            "[]",
            "()[]",
            "(){}",
            "[]{}",
            "(){}[]",
            "[{()}](){}"
    })
    public void isBalancedBrackets_validInputs_shouldReturnsTrue(String input) {
        assertThat(service.isBalancedBrackets(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(",
            "}",
            "[",
            "()[",
            "()}",
            "]{}",
            "(){[]",
            "[{()]()}"
    })
    public void isBalancedBrackets_invalidInputs_shouldReturnsFalse(String input) {
        assertThat(service.isBalancedBrackets(input)).isFalse();
    }

}
