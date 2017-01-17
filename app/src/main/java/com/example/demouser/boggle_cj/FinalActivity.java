package com.example.demouser.boggle_cj;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class FinalActivity extends AppCompatActivity {

    private BoogleDictionary dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        //load the words.txt file
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("m_length_dictionary.txt");
            dictionary = new BoogleDictionary(inputStream);
            //use the text file as dictionary
        } catch (IOException e) {
            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
            toast.show();
        }

        showResult();

        ((Button) findViewById(R.id.resetButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void showResult() {

        dictionary.iterate();

        ((TextView)findViewById(R.id.correct)).setText(dictionary.getCorrect());
        ((TextView)findViewById(R.id.wrong)).setText(dictionary.getWrong());
    }

    // reset method, from final activity back to start activity
    private void reset()
    {
        startActivity(new Intent(this, StartActivity.class));

    }

}
