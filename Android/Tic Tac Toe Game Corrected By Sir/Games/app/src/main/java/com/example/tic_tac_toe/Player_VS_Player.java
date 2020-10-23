package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Player_VS_Player extends AppCompatActivity {
boolean gameActive= true; // i am taking boolean here because i want to refresh after any player has won the game
/* 0-X
   1-O


   012
   345
   678




 */

int active_Player = 0;

// 9 cells main hum apne values store kerwain ga

    /*state meanings

    0 -> X

    1 -> O

    2 -> null (Khale Jegha)

    */

    int [] gameState ={2,2,2,2,2,2,2,2,2};

    // Now Making Winning Positions by 2D array

    int [][] winPositions={ {0,1,2} , {3,4,5} , {6,7,8} ,
                            {0,3,6} , {1,4,7} , {2,5,8} ,
                            {0,4,8} , {2,4,6}          };



/* jo bhe tap kera ga humare image view pa wo yeha pa  view variable main   a gye ga */
    public void playerTap(View view)
    {
        ImageView img = (ImageView) view;
        // tag jo hum na dia tha ausa get krain ga aur aus  value ko string main convert kr dain ga.
        // tap / click kerna pa mujha tag id mila ge jaisa hum na 0 1 2 3 4 5 6 7 8  hum na tag id de ha apne image view ko

        int tappedImage = Integer.parseInt(img.getTag().toString());

        // ager mare game state khale ha to he to main aus main kuch bharoun ga

        // 2 -> null ko show kr reha ha
        if(!gameActive){
            gameReset(view);
        }

        if(gameState [tappedImage] == 2 ) // ager game  null show kr reha ha to ya code run kro
        {
            // ager tapped image khale ha to wehan pa ap active player k variable ko rekh dain

            gameState[tappedImage] = active_Player;
      // Translation   image ko translate kr deta ha

            img.setTranslationY(-1000f); // image pecha chle gye ge

            // ager shru main active player 0 ka braber ha to ausa 1 kerdo , ager  1 nai ha to ausa 0 kerdo

            // ager kise  na X chla ha aus ka pas 0 chle gye ga , aur ager kise na O chla ha aus k pas 1 chle gye ga
            if(active_Player == 0)
            {
         // ager zero ha to image resource X wale image bra ber kr do
                img.setImageResource(R.drawable.x);
                active_Player = 1;
                TextView status = (TextView) findViewById(R.id.status);
                status.setText("Player 2 Turn");
            }
            else
                {
                    img.setImageResource(R.drawable.o);
                    active_Player =0;
                    TextView status = (TextView) findViewById(R.id.status);
                    status.setText("Player 1 Turn");
                }

            img.animate().translationYBy(1000f).setDuration(100); // image age a gye ge
        }
      // Check is their any player who has got the victory

        // applying enhanced for loop on our array and checking winning positions
        for(int[] winPosition:winPositions){
            /*
            012  <-- win position 0
            345  <-- win position 1
            678  <-- win position 2

            * */
          if(gameState[ winPosition[0] ] == gameState[ winPosition[1] ]  &&
             gameState[winPosition[1]] == gameState[winPosition[2]] &&
                  // aur koi aik khale jagha blank bhe na ho
                  gameState[winPosition[0]] !=2          )
          {
                // ager win position zero(0) ka braber ha to X jeet gya
              String winnerStr;
              // jaisa he koi jeta mujha game active ko false kerdaina ha
              gameActive = false;
              if(gameState[winPosition[0] ] == 0){

                  winnerStr= "Player 1 has Won";
              }
              else{
                  winnerStr= "Player 2 has Won";
              }
                  // Updating the status bar for winning announcer
              TextView status = (TextView) findViewById(R.id.status);
              status.setText(winnerStr);



          }

        }




    }



    public void gameReset(View view)
    {
        gameActive=true;
        active_Player=0;
        for(int i = 0 ; i<gameState.length;i++){
            gameState[i] = 2; // game state ka sara elements ko null kr reha hu
        }
        //Image view pa hu main abhe
        ( (ImageView)findViewById(R.id.imageView_0) ).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView_1) ).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView_2) ).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView_3) ).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView_4) ).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView_5) ).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView_6) ).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView_7) ).setImageResource(0);
        ( (ImageView)findViewById(R.id.imageView_8) ).setImageResource(0);

        TextView status = (TextView) findViewById(R.id.status);
        status.setText("Player 1 Turn");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player__vs__player);




    }
}
