package com.example.demouser.boggle_cj;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    BoogleDictionary dictionary;

    @Before
    public void setUp(){

        ArrayList<String> validList = new ArrayList<>();
        validList.add("about");
        validList.add("other");
    }
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
}