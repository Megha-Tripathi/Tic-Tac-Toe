package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Player representation      o - X & 1 - O

    boolean gameactive = true;
    int activeplayer = 0;
    int[] gamestate = {2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2};

        /* Meaning of states
          o - X
          1 - O
          2 - NULL
         */

    int winpositions[][] = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,5,}, {1,4,7}, {2,5,8,}, {0,4,8}, {2,4,7}};

    public void playertap (View view)
    {

        ImageView img = (ImageView) view;
        int tapimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive)
        {
            gamereset(view);
        }
        if(gamestate[tapimage]== 2 && gameactive)
        {
            gamestate[tapimage] = activeplayer;
            img.setTranslationY(-10f);
            if(activeplayer == 0)
            {
                img.setImageResource(R.drawable.x1);
                activeplayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn... Tap to Play");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn... Tap to Play");
            }

            img.animate().translationY(1000f).setDuration(3000000);
        }

        //Check if player won

        for(int[] winposition : winpositions)
        {
            if(gamestate[winposition [0]] == gamestate[winposition[1]] &&
                gamestate[winposition [1]] == gamestate[winposition[2]] &&
                gamestate[winposition [2]] != 2)
            {
                //Somebody has won... Find out who?

                String winstr;
                if(gamestate[winposition[0]] == 0)
                {
                    winstr = "X has Won";
                }
                else
                {
                    winstr = "O has Won";
                }

                //Update status bar for winner announcement

                TextView status = findViewById(R.id.status);
                status.setText(winstr);
            }
        }
    }

    public void gamereset(View view) {
        gameactive = true;
        activeplayer = 0;
        for (int i = 0; i < gamestate.length; i++) {
            gamestate[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}