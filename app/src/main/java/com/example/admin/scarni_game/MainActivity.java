package com.example.admin.scarni_game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    int userScore = 0;
    int userTurn = 0;
    int computerScore = 0;
    int computerTurn = 0;

    TextView youscoreTxt, computerscoreTxt;
    Button Roll, Hold, Reset;
    ImageView imageview;

    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youscoreTxt = (TextView) findViewById(R.id.txt2);
        computerscoreTxt = (TextView) findViewById(R.id.txt4);

        Roll = (Button) findViewById(R.id.bt1);
        Hold = (Button) findViewById(R.id.bt2);
        Reset = (Button) findViewById(R.id.bt3);

        imageview = (ImageView) findViewById(R.id.imageview);

        Random rnd = new Random();
        int x = rnd.nextInt(2);
        if(x==0) {
            Toast toast=Toast.makeText(getApplicationContext(),"Its ur turn",Toast.LENGTH_SHORT);
            toast.show();
            userTries();
        }
        else{
            Toast toast=Toast.makeText(getApplicationContext(),"First try is of Computer...dont press anything.....",Toast.LENGTH_SHORT);
            toast.show();
            computerTries();
        }
    }


    public void userTries(){
        Roll.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random rnd = new Random();
                int x = rnd.nextInt(6)+1;
                diceThrow(x);
                if (x == 1) {
                    userTurn=0;
                    youscoreTxt.setText(""+userScore);
                    computerTries();
                }

                else{
                    userTurn=userTurn+x;
                    Toast toast=Toast.makeText(getApplicationContext(),""+userTurn,Toast.LENGTH_SHORT);
                    toast.show();

                }
                // Toast toast=Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT);
                // toast.show();
            }
        });
        Hold.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userScore=userScore+userTurn;
                userTurn=0;
                //Toast toast=Toast.makeText(getApplicationContext(),"socre is:"+userScore,Toast.LENGTH_SHORT);
                // toast.show();
                youscoreTxt.setText(""+userScore);
                computerTries();

            }
        });
        Reset.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                userTurn=0;
                userScore=0;
                computerTurn=0;
                computerScore=0;
                youscoreTxt.setText(""+userScore);
                computerscoreTxt.setText("" + computerScore);
                Toast toast=Toast.makeText(getApplicationContext(),"Game has been reset.....",Toast.LENGTH_SHORT);
                toast.show();

            }
        });

    }



    public void computerTries() {

        Random rnd = new Random();
        int x = rnd.nextInt(6) + 1;
        Toast toaste=Toast.makeText(getApplicationContext(),""+x,Toast.LENGTH_SHORT);
        toaste.show();
        diceThrow(x);
        if (x == 1) {
            computerTurn = 0;
            computerscoreTxt.setText("" + computerScore);
            Toast toast=Toast.makeText(getApplicationContext(),"Its ur turn",Toast.LENGTH_SHORT);
            toast.show();
            userTries();
        }

         else{
                computerTurn = computerTurn + x;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    computerTries();
                }
            },4000);


            }

        if (computerTurn > 20) {
            computerScore = computerScore + computerTurn;
            computerTurn = 0;
            computerscoreTxt.setText("" + computerScore);
            Toast toast=Toast.makeText(getApplicationContext(),"Its ur turn",Toast.LENGTH_SHORT);
            toast.show();
            userTries();

        }


        }

    public void diceThrow(int x){

        switch(x){
            case 1:
                imageview.setImageResource(R.drawable.dice1);break;

            case 2:
                imageview.setImageResource(R.drawable.dice2);break;

            case 3:
                imageview.setImageResource(R.drawable.dice3);break;

            case 4:
                imageview.setImageResource(R.drawable.dice4);break;

            case 5:
                imageview.setImageResource(R.drawable.dice5);break;

            case 6:
                imageview.setImageResource(R.drawable.dice6);break;
        }
    }
}