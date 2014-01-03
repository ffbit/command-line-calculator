package com.ffbit.calculator.expresion;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TokenTest {

    @Test
    public void itShouldHaveLexemeAndType() throws Exception {
        Token token = new Token("1", TokenType.LITERAL);

        assertThat(token.getLexeme(), is("1"));
        assertThat(token.getType(), is(TokenType.LITERAL));
    }

    @Test
    public void itShouldBeEqual() throws Exception {
        Token token = new Token("1", TokenType.LITERAL);

        assertThat(token, is(new Token("1", TokenType.LITERAL)));
    }

}
