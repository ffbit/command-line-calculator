package com.ffbit.calculator.expresion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.junit.Assert.assertThat;

import static com.ffbit.calculator.expresion.TokenType.*;

public class TokenTypeTest {

    @Test
    public void AdditionShouldHaveSamePrecedenceAsAddition() throws Exception {
        assertThat(ADDITION.getPrecedence(), is(comparesEqualTo(ADDITION.getPrecedence())));
    }

}
