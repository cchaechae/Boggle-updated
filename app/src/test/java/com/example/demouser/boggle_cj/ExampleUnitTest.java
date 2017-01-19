package com.example.demouser.boggle_cj;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    BoogleDictionary dictionary;
    String correct = "";
    String wrong = "";

    @Before
    public void setUp(){

        ArrayList<String> validList = new ArrayList<>();
        validList.add("about");
        validList.add("other");
        validList.add("east");
        validList.add("easter");

        HashMap<String, Boolean> wordMap = new HashMap<String, Boolean>();

        dictionary = new BoogleDictionary(validList, wordMap);
    }
    @Test
    public void addition_isCorrect() throws Exception {

        dictionary.putWord("about");
        dictionary.putWord("west");
        dictionary.putWord("other");

        assertEquals(dictionary.checkWord("about"), true);
        assertEquals(dictionary.checkWord("west"), false);
        assertEquals(dictionary.checkWord("east"), true);
        assertEquals(dictionary.checkWord("mountain"), false);

        assertEquals(dictionary.getValue("about"), true);
        assertEquals(dictionary.getValue("west"), false);


        //dictionary.iterate(correct, wrong);
        assertEquals(dictionary.getCorrect(), "other\nabout\n");
        assertEquals(dictionary.getWrong(), "west\n");
    }
}