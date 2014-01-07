package com.ffbit.calculator.cli;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class CalculatorMainTest {
    private String[] ARGS = new String[]{};

    private String EMPTY_NEW_LINE = String.format("%n");
    private String EMPTY_STRING = "";
    private String ONE = 1 + EMPTY_NEW_LINE;

    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public StandardOutputStreamLog systemOutMock = new StandardOutputStreamLog();

    @Test
    public void itShouldOutNothingOnEmptyInput() throws Exception {
        systemInMock.provideText(EMPTY_NEW_LINE);

        CalculatorMain.main(ARGS);

        assertThat(systemOutMock.getLog(), is(EMPTY_STRING));
    }

    @Test
    public void itShouldOutOneOnOne() throws Exception {
        systemInMock.provideText(ONE);

        CalculatorMain.main(ARGS);

        assertThat(systemOutMock.getLog(), is(ONE));
    }

}
