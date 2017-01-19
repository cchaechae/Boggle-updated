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

public class BoogleDictionary
{

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

        while((line = in.readLine()) != null)
        {
            String word = line.trim();

            if (word.length() >= MIN_WORD_LENGTH)
                list.add(word);
        }

        generateBoard();

        validList = generateValidList(board, validList);

        while (validList.size()<5 || validList.size()>15)
        {
            generateBoard();

            ArrayList<String> newList = new ArrayList<String>();
            newList=  generateValidList(board, newList);

            validList = newList;
        }

    }


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

        if (wordMap.isEmpty())
        {

            correctWords = "";
            wrongWords = "";

//            System.out.println("word map is empty");
        }

        else {
            for (String key : wordMap.keySet()) {

                if (getValue(key)){
                    correctWords += key + "\n";
//                    System.out.println("correct words: " + correctWords);
                }

                else{
                    wrongWords += key + "\n";
//                    System.out.println("wrong words: "+ wrongWords);
                }

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


    public ArrayList<String> generateValidList(char[][] newBoard, ArrayList<String> inputList)
    {
        if (newBoard == null)
        {
            throw new NullPointerException("The board cannot be null");
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


    private void generateList(char[][] newBoard, int row, int column, String prefix, List<String> validWords)
    {
        assert newBoard != null;
        assert validWords != null;

        for (int i = Math.max(0, row - 1); i < Math.min(newBoard.length, row + 2); i++)
        {
            for (int j = Math.max(0, column - 1); j < Math.min(newBoard[0].length, column + 2); j++)
            {
                if (i != row || j != column)
                {
                    String word = prefix+ newBoard[i][j];

                    if (list.contains(word))
                    {
                        validWords.add(word);
                    }

                    if (isValidPrefix(word))
                    {
                        generateList(newBoard, i, j, word, validWords);
                    }
                }
            }
        }
    }


    public ArrayList<String> getValidList()
    {
        return validList;
    }



    // check if there is word starting with this prefix using binary search
    public boolean isValidPrefix(String prefix)
    {
        int lo = 0;
        int hi = list.size();

        // when lo=hi, thats the target index
        while (lo < hi)
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

