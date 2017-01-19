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
import java.util.HashMap;

public class FinalActivity extends AppCompatActivity {

    private String correct;
    private String wrong;
    private MainActivity mActivity= new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent intent = getIntent();
        correct = intent.getStringExtra(MainActivity.USER_CORRECT);
        wrong = intent.getStringExtra(MainActivity.USER_WRONG);

        System.out.println("correct"+ correct);
        System.out.println("wrong" + wrong);

        //load the words.txt file
//        AssetManager assetManager = getAssets();
//        try {
//            InputStream inputStream = assetManager.open("words.txt");
//            dictionary = new BoogleDictionary(inputStream);
//            //use the text file as dictionary
//        } catch (IOException e) {
//            Toast toast = Toast.makeText(this, "Could not load dictionary", Toast.LENGTH_LONG);
//            toast.show();
//        }

        showResult();

        ((Button) findViewById(R.id.resetButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    private void showResult() {

        //((TextView)findViewById(R.id.correct)).setText(dictionary.getValidList().toString());
        ((TextView)findViewById(R.id.correct)).setText(mActivity.showCorrect());
        ((TextView)findViewById(R.id.wrong)).setText(mActivity.showWrong());
    }

    // reset method, from final activity back to start activity
    private void reset()
    {
        startActivity(new Intent(this, StartActivity.class));

    }

}
