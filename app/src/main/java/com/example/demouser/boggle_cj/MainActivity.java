package com.example.demouser.boggle_cj;


import android.content.res.AssetManager;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public BoogleDictionary dictionary;
    private String typedWord = "";
    String result = "";
    public ArrayList<String> validList = new ArrayList<String>();
    public String correct = "";
    public String wrong = "";
    public String extra = "";
    private String boggleBoardText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.button00)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button01)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button02)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button03)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button10)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button11)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button12)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button13)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button20)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button21)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button22)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button23)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button30)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button31)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button32)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button33)).setBackgroundResource(R.drawable.charbutton_boarder);

        //load the words.txt file
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("words.txt");
            dictionary = new BoogleDictionary(inputStream);
            //use the text file as dictionary
        } catch (IOException e) {
            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
            toast.show();
        }

        validList = dictionary.getValidList();

        ((Button)findViewById(R.id.finishButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        ((Button)findViewById(R.id.enterButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                enter();
            }
        });

        ((Button)findViewById(R.id.clearButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                clear();
            }
        });

        char[][] board = dictionary.getBoard();

        //set the button with board characters
        ((Button)findViewById(R.id.button00)).setText(String.valueOf(board[0][0]));
        ((Button)findViewById(R.id.button01)).setText(String.valueOf(board[0][1]));
        ((Button)findViewById(R.id.button02)).setText(String.valueOf(board[0][2]));
        ((Button)findViewById(R.id.button03)).setText(String.valueOf(board[0][3]));
        ((Button)findViewById(R.id.button10)).setText(String.valueOf(board[1][0]));
        ((Button)findViewById(R.id.button11)).setText(String.valueOf(board[1][1]));
        ((Button)findViewById(R.id.button12)).setText(String.valueOf(board[1][2]));
        ((Button)findViewById(R.id.button13)).setText(String.valueOf(board[1][3]));
        ((Button)findViewById(R.id.button20)).setText(String.valueOf(board[2][0]));
        ((Button)findViewById(R.id.button21)).setText(String.valueOf(board[2][1]));
        ((Button)findViewById(R.id.button22)).setText(String.valueOf(board[2][2]));
        ((Button)findViewById(R.id.button23)).setText(String.valueOf(board[2][3]));
        ((Button)findViewById(R.id.button30)).setText(String.valueOf(board[3][0]));
        ((Button)findViewById(R.id.button30)).setText(String.valueOf(board[3][0]));
        ((Button)findViewById(R.id.button31)).setText(String.valueOf(board[3][1]));
        ((Button)findViewById(R.id.button32)).setText(String.valueOf(board[3][2]));
        ((Button)findViewById(R.id.button33)).setText(String.valueOf(board[3][3]));


        // on click listener for all the buttons in the grid
        ((Button)findViewById(R.id.button00)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button00)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button00)).setBackgroundResource(R.drawable.char_button_clicked);

            }
        });

        ((Button)findViewById(R.id.button01)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button01)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button01)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button02)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button02)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button02)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button03)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button03)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button03)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button10)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button10)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button10)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button11)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button11)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button11)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button12)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button12)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button12)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button13)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button13)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button13)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button20)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button20)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button20)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button21)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button21)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button21)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });


        ((Button)findViewById(R.id.button22)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button22)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button22)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button23)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button23)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button23)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button30)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button30)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button30)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button31)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button31)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button31)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button32)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button32)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button32)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        ((Button)findViewById(R.id.button33)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // add the on button to typedWord String
                typedWord += ((Button)findViewById(R.id.button33)).getText().toString();
                // update text view
                ((TextView)findViewById(R.id.typingWord)).setText(typedWord);
                // set the button to a clicked color
                ((Button)findViewById(R.id.button33)).setBackgroundResource(R.drawable.char_button_clicked);


            }
        });

        boggleBoardText = dictionary.getBoardText();

    }

    public static String USER_CORRECT = "com.example.demouser.USER_CORRECT";
    public static String USER_WRONG = "com.example.demouser.USER_WRONG";
    public static String EXTRA_WORDS = "com.example.demouser.EXTRA_WORDS";
    public static String BOARD_TEXT = "com.example.demouser.BOARD_TEXT";

    // method to go to final Activity
    public void finish()
    {
        showResult();
        clear();
        Intent finalActivity = new Intent(this, FinalActivity.class);
        finalActivity.putExtra(USER_CORRECT, correct);
        finalActivity.putExtra(USER_WRONG, wrong);
        finalActivity.putExtra(EXTRA_WORDS, extra);
        finalActivity.putExtra(EXTRA_WORDS, boggleBoardText);


        startActivity(finalActivity);


    }

    public void clear()
    {
       // clear the text
       typedWord = "";
        // all button goes back to normal background color
        ((Button)findViewById(R.id.button00)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button01)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button02)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button03)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button10)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button11)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button12)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button13)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button20)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button21)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button22)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button23)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button30)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button31)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button32)).setBackgroundResource(R.drawable.charbutton_boarder);
        ((Button)findViewById(R.id.button33)).setBackgroundResource(R.drawable.charbutton_boarder);

        ((TextView)findViewById(R.id.typingWord)).setText(typedWord);


    }

    public void enter()
    {
        dictionary.putWord(typedWord); //wordList.add(word);
        result += typedWord+", ";
        ((TextView)findViewById(R.id.userTyped)).setText(result);
        clear();

    }

    public BoogleDictionary getDictionary(){

        return dictionary;
    }

    public void showResult() {

        dictionary.iterate();
        correct = dictionary.getCorrect();
        wrong = dictionary.getWrong();

        extra = dictionary.getExtra();
    }

    public String showCorrect(){

        return correct;
    }

    public String showWrong(){

        return wrong;
    }


}
