package com.example.demouser.boggle_cj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by demouser on 1/13/17.
 */

public class BoogleDictionary {

    private ArrayList<String> list = new ArrayList<String>();

    public BoogleDictionary(InputStream wordListStream) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;

        while((line = in.readLine()) != null) {
            String word = line.trim();

            //  Your code here
            //new array list for the whole list of strings
            //from the hardware to the memory
            list.add(word);
        }
    }

}
