package com.example.demouser.boggle_cj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by demouser on 1/13/17.
 */

public class BoogleDictionary {

    private static final int MIN_WORD_LENGTH = 3;
    private ArrayList<String> list = new ArrayList<String>();
    //String: words that user typed; Boolean: whether its in validList, correct ot wrong
    public HashMap<String, Boolean> wordMap = new HashMap<String, Boolean>();

    // a list of possible words from the randomly generated grid
    private ArrayList<String> validList = new ArrayList<String>();

    public String correctWords = "";
    public String wrongWords = "";
    public String extraWords = "";

    public char[][] board = new char[4][4];
    Random random = new Random();

    public BoogleDictionary(InputStream wordListStream) throws IOException
    {

        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;

        while((line = in.readLine()) != null) {
            String word = line.trim();
            if (word.length() >= MIN_WORD_LENGTH)
                list.add(word);
        }

        //generate a new board
        generateBoard();
        //get a valid list based on the grid
        //if (validList.size()>5)
        validList = generateValidList(board, validList);
        //else

        
        while (validList.size()<5)
        {
            generateBoard();
            ArrayList<String> newList = new ArrayList<String>();
            newList=  generateValidList(board, newList);


            validList = newList;
        }

    }

    /**
     * For the testing
     * @param validList
     */
    public BoogleDictionary(ArrayList<String> validList, HashMap<String,Boolean> wordMap){
        this.validList = validList;
        this.wordMap = wordMap;
    }

    /**
     * Add boolean values to HashMap
     * @param obj
     */
    public void putWord(String obj)
    {

        wordMap.put(obj, checkWord(obj));
    }

    public boolean checkWord(String obj)
    {

        if (validList.contains(obj))
            return true;

        else
            return false;
    }


    public boolean getValue(String obj)
    {

        return wordMap.get(obj).booleanValue();
    }

    public HashMap<String, Boolean> getMap()
    {

        return wordMap;
    }

    public void iterate(){

        if (wordMap.isEmpty()){

            correctWords = "";
            wrongWords = "";

            System.out.println("word map is empty");
        }

        else {
            for (String key : wordMap.keySet()) {

                if (getValue(key)){
                    correctWords += key + "\n";
                    System.out.println("correct words: " + correctWords);
                }

                else{
                    wrongWords += key + "\n";
                    System.out.println("wrong words: "+ wrongWords);
                }
                //if you uncomment below code, it will throw java.util.ConcurrentModificationException
                //studentGrades.remove("Alan");
            }
        }

    }

    public String getCorrect()
    {

        return correctWords;
    }

    public String getWrong(){

        return wrongWords;
    }


    public ArrayList<String> generateValidList(char[][] newBoard, ArrayList<String> inputList)
    {
        if (newBoard == null)
        {
            throw new NullPointerException("The matrix cannot be null");
        }

        for (int i = 0; i < newBoard.length; i++)
        {
            for (int j = 0; j < newBoard[0].length; j++)
            {
                generateList(newBoard, i, j, newBoard[i][j] + "", inputList);
            }
        }
        return inputList;
    }

    private void generateList(char[][] newBoard, int i, int j, String prefix, List<String> validWords)
    {
        assert newBoard != null;
        assert validWords != null;

        for (int i1 = Math.max(0, i - 1); i1 < Math.min(newBoard.length, i + 2); i1++)
        {
            for (int j1 = Math.max(0, j - 1); j1 < Math.min(newBoard[0].length, j + 2); j1++)
            {
                if (i1 != i || j1 != j)
                {
                    String word = prefix+ newBoard[i1][j1];

                    if (list.contains(word))
                    {
                        validWords.add(word);
                    }

                    if (isValidPrefix(word))
                    {
                        generateList(newBoard, i1, j1, word, validWords);
                    }
                }
            }
        }
    }

    public ArrayList<String> getValidList()
    {
        return validList;
    }

    // generate a random grid
    public void generateBoard()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                char newChar = (char) (random.nextInt(26) + 'a');
                board[i][j] = newChar;
            }
        }


    }

    public char[][] getBoard()
    {
        return board;
    }

    // check if there is word starting with this prefix
    public boolean isValidPrefix(String prefix)
    {
        int lo = 0;
        int hi = list.size();

        // when lo=hi, thats the target index
        while (lo<hi)
        {
            int mid = lo + (hi-lo)/2;

            String current = list.get(mid);

            if (current.startsWith(prefix))
                return true;
            // if mid comes before target, move lo higher
            if (current.compareTo(prefix)>0)
                hi = mid-1;
                // if mid comes after target, move hi lower
            else
                lo = mid+1;
        }

        return false;
    }

    public String getExtra(){

        for (String obj: validList){

            if (!wordMap.containsKey(obj)){
                extraWords += obj + ", ";
            }
        }

        return extraWords;
    }


}
