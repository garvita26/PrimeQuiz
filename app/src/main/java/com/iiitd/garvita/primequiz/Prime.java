package com.iiitd.garvita.primequiz;

import java.util.Random;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Prime extends AppCompatActivity {
    private Button mYesButton;
    private Button mNoButton;
    private Button mNextButton;
    private TextView mQuestion;
    private boolean flag ;
    private boolean isPressed=false;
    private static final String TAG = "PrimeActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);
        initialize();

    }
    //method to initialize all buttons and text fields
    private void initialize()
    {
        mYesButton = (Button) findViewById(R.id.button);
        mNoButton = (Button) findViewById(R.id.button2);
        mNextButton = (Button) findViewById(R.id.next_button);
        mQuestion = (TextView) findViewById(R.id.textView);
        generateQuestion();
    }
    //method to generate random number between 1-1000
   private void generateQuestion() {

        int max = 1000;
        int min = 1;
        final int random;

        final Random number = new Random();
        random = number.nextInt(max - min + 1) + min;

        mQuestion.setText(String.format(getString(R.string.ques), random));
        checkPrime(random);

    }
    //method to check if the number is prime or not and generating suitable toast
   private void checkPrime(int random) {
       mNoButton.setEnabled(true);
       mYesButton.setEnabled(true);
       isPressed=false;
        flag=true;
        for (int i = 2; i <= random / 2; i++) {
            if (random % i == 0) {
                flag = false;
                break;
            }
        }
        mYesButton.setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                      mNoButton.setEnabled(false);
                        isPressed=true;
                        if (!flag) {
                            Toast.makeText(Prime.this, R.string.incorrecttoast, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Prime.this, R.string.correcttoast, Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
        mNoButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        mYesButton.setEnabled(false);
                        isPressed=true;
                        if (!flag) {
                            Toast.makeText(Prime.this, R.string.correcttoast, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Prime.this, R.string.incorrecttoast, Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
        mNextButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if(!isPressed)
                        {
                            Toast.makeText(Prime.this, "please answer first!", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            generateQuestion();
                        }

                    }
                }
        );

    }




    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }



    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnResume");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Inside OnStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}


