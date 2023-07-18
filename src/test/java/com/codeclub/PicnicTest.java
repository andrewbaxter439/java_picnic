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
    @Test
    public void testOne() {

        Picnic.main(new String[]{"sandwiches"});
        Assertions.assertEquals(
                "You are bringing sandwiches",
                outputStreamCaptor.toString().trim()
        );
    }

    @Test
    public void testTwo() {

        Picnic.main(new String[]{"apple juice", "oranges"});
        Assertions.assertEquals(
                "You are bringing apple juice and oranges",
                outputStreamCaptor.toString().trim()
        );
    }

    @Test
    public void testMoreThanTwo() {

        Picnic.main(new String[]{"pineapples", "cupcakes", "pomegranate juice"});
        Assertions.assertEquals(
                "You are bringing pineapples, cupcakes and pomegranate juice",
                outputStreamCaptor.toString().trim()
        );
    }

    @Test
    public void testTwoSorted() {

        Picnic.main(new String[]{"oranges", "cupcakes"});
        Assertions.assertEquals(
                "You are bringing cupcakes and oranges",
                outputStreamCaptor.toString().trim()
        );
    }

    @Test
    public void testMoreThanTwoSorted() {

        Picnic.main(new String[]{"pineapples", "cupcakes", "pomegranate juice"});
        Assertions.assertEquals(
                "You are bringing cupcakes, pineapples and pomegranate juice",
                outputStreamCaptor.toString().trim()
        );
    }

}
