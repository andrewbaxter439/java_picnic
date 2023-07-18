package com.codeclub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class PicnicTest
{
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void runs() {
        Picnic test_app = new Picnic();
        Assertions.assertInstanceOf(Picnic.class, test_app);
    }

    @Test
    public void helpOutput() {
        Picnic.main(new String[]{"-h"});
        Assertions.assertTrue(outputStreamCaptor.toString().contains("Usage"));
    }
}
