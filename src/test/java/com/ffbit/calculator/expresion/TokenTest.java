package com.ffbit.calculator.expresion;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TokenTest {

    private final Token token = new Token("1", TokenType.LITERAL);

    @Test
    public void itShouldHaveLexeme() throws Exception {
        assertThat(token.getLexeme(), is("1"));
    }

    @Test
    public void itShouldHaveType() throws Exception {
        assertThat(token.getType(), is(TokenType.LITERAL));
    }

    @Test
    public void itShouldBeEqual() throws Exception {
        assertThat(token, is(new Token("1", TokenType.LITERAL)));
    }

    @Test
    @Parameters({
            "1, ADDITION",
            "2, LITERAL",
            "+, ADDITION"
    })
    public void itShouldNotBeEqual(String lexeme, TokenType type) throws Exception {
        assertThat(token, is(not(new Token(lexeme, type))));
    }

    @Test
    public void itShouldBeLiteral() throws Exception {
        assertThat(token.isLiteral(), is(true));
    }

}
