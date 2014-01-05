package com.ffbit.calculator.expresion;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RpnEvaluatorTest {

    @Test
    public void itShouldEvaluateEmptyListOfTokensToZero() throws Exception {
        RpnEvaluator evaluator = new RpnEvaluator();

        assertThat(evaluator.evaluate(Collections.<Token>emptyList()), is(0));
    }

}
