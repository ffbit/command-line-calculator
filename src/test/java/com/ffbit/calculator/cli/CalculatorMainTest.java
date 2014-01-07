package com.ffbit.calculator.cli;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class CalculatorMainTest {

    @Rule
    public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

    @Rule
    public StandardOutputStreamLog systemOutMock = new StandardOutputStreamLog();

    @Test
    public void itShouldOutEmptyLineOnEmptyInput() throws Exception {
        systemInMock.provideText(String.format("%n"));

        CalculatorMain.main(new String[]{});

        assertThat(systemOutMock.getLog(), is(String.format("%n")));
    }

}
