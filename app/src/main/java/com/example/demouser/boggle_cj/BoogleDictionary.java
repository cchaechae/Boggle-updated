package com.example.demouser.boggle_cj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by demouser on 1/13/17.
 */

public class BoogleDictionary {

    private ArrayList<String> dictionary = new ArrayList<String>();
    public HashMap<String, Boolean> wordMap = new HashMap<String, Boolean>();

    public String correct = "";
    public String wrong = "";

    public BoogleDictionary(InputStream wordListStream) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;

        while((line = in.readLine()) != null) {
            String word = line.trim();

            //  Your code here
            //new array list for the whole list of strings
            //from the hardware to the memory
            dictionary.add(word);
        }
    }

    /**
     * Add boolean values to HashMap
     * @param obj
     */
    public void putWord(String obj){

        wordMap.put(obj, checkWord(obj));
    }

    public boolean checkWord(String obj){

        if (dictionary.contains(obj))
            return true;

        else
            return false;
    }

    public boolean getValue(String obj){

        return wordMap.get(obj).booleanValue();
    }

    public HashMap<String, Boolean> getMap(){

        return wordMap;
    }

    public void iterate(){

        for(String key: wordMap.keySet()){

            if (getValue(key))
                correct += key;

            else
                wrong += key;
            //if you uncomment below code, it will throw java.util.ConcurrentModificationException
            //studentGrades.remove("Alan");
        }

    }

    public String getCorrect(){

        return correct;
    }

    public String getWrong(){

        return wrong;
    }


}
