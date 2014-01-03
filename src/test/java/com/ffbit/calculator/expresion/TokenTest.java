package com.ffbit.calculator.expresion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TokenTest {

    private final Token token = new Token("1", TokenType.LITERAL);

    @Test
    public void itShouldHaveLexemeAndType() throws Exception {
        assertThat(token.getLexeme(), is("1"));
        assertThat(token.getType(), is(TokenType.LITERAL));
    }

    @Test
    public void itShouldBeEqual() throws Exception {
        assertThat(token, is(new Token("1", TokenType.LITERAL)));
    }

}
