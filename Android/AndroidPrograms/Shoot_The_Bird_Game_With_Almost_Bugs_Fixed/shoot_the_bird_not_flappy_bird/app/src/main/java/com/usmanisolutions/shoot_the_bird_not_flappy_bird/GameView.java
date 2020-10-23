package com.usmanisolutions.shoot_the_bird_not_flappy_bird;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable{

    public static Button hit;

    private Thread thread;
    private boolean isPlaying,isGameOver = false;
    private int screenX  , screenY , score =0 ;
    public static float screenRatioX , screenRatioY;
    private Paint paint;
    private Bird[] birds;

    private SharedPreferences prefs;


    private Random random;

    private SoundPool soundPool;
    private List<Bullet> bullets;
    private int sound;
    private Flight flight;
    private GameActivity activity;
    private Background background1,background2;
                     /*Context context */
    public GameView(GameActivity activity , int screenX , int screenY) {
        super(activity);





        this.activity = activity;
/*game is the name of our shared preferences */
        prefs = activity.getSharedPreferences("game",Context.MODE_PRIVATE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();

            soundPool = new SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .build();
        }

        else
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);

        sound = soundPool.load(activity , R.raw.shoot,1);


        this.screenX = screenX;
        this.screenY = screenY;
        screenRatioX =1920f/ screenX;
        screenRatioY =1080f/ screenY;



    background1 = new Background(screenX,screenY,getResources() );
    background2 = new Background(screenX,screenY,getResources() );


    flight = new Flight(this,screenY,getResources()); // here this is not in vid

    bullets = new ArrayList<>();


    background2.x = screenX;

    paint = new Paint();

    paint.setTextSize(128);
    paint.setColor(Color.WHITE);

    birds = new Bird[4];


    for(int i =0 ; i<4 ;i++)
    {
        Bird bird = new Bird(getResources()  );

        birds[i] = bird;
    }


    random = new Random();


    }

    @Override
    public void run() {

        while(isPlaying)
        {
            update();
            draw();
            sleep();
        }
    }


    public void resume()
    {
        isPlaying=true;
        thread = new Thread(this);
        thread.start();
    }




    public void pause()
    {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void update()
    {
// update is responsible for movind the screen


        // i am guessing the problem  exist over here because their is problem in background
        background1.x -= 10 * screenRatioX ; // by this speed is controlled

        background2.x -= 10 * screenRatioX ; // by this speed is controlled


        if(background1.x + background1.background.getWidth()  < 0  )

        {


            background1.x = screenX;
        }

        if(background2.x + background2.background.getWidth()  < 0  )

        {


            background2.x = screenX;
        }


        if (flight.isGoingUp)
            flight.y -=30* screenRatioY; // if flight is going up then reduce the flight value of y axis
        else
            flight.y += 30*screenRatioY;


        if(flight.y <0)
            flight.y = 0;


        if(flight.y >= screenY - flight.height ) // here in video it is screenX not screenY
            flight.y = screenY - flight.height;


        List<Bullet> trash = new ArrayList<>();


        for(Bullet bullet : bullets)
        {
            if(bullet.x > screenX)
                trash.add(bullet);

                bullet.x +=50*screenRatioX;

            for (Bird bird : birds)
            {

                if(Rect.intersects(bird.getCollisionShape() ,

                        bullet.getCollisionShape() ))
                {

                    score++;
                    bird.x = -500;
                    bullet.x = screenX + 500;
                    bird.wasShot = true;
                }


            }



        }


        for(Bullet bullet : trash)
        { bullets.remove(bullet);}


        for (Bird bird :birds)
        {
            bird.x -= bird.speed;

            if(bird.x + bird.width <0)
            {
//over here int bound is missing
               /* int bound = (int) (30*screenRatioX);
                bird.speed = */

                /*this condition will be true if the bird was not shot*/



    // i maked this all as a comment because i dont want my game to be over when bird is not shot . this condition was causing problem
             //   if(!bird.wasShot)
            //    {
             //       isGameOver = true  /*false*/;
             //       return;
             //   }


                /* here float was found we are casting it into integer(int) */

                int bound = (int) (/*30*/5 * screenRatioX);  // this says bound try changing this ,, i think it is related to speed

                bird.speed = random.nextInt(bound);

                if(bird.speed <10 * screenRatioX ) // configuring speed of bird
                    bird.speed = (int) (/*10*/5 * screenRatioX); // configuring speed of bird



                bird.x=screenX;
                bird.y=random.nextInt(screenY - bird.height);
                /*here it is being confusing that the bird.x should come outside or inside the nested if right above this comment */

                bird.wasShot=false;
            }


            if (Rect.intersects(  bird.getCollisionShape()/*first rectangle of bird*/ , flight.getCollisionShape()/*second rectangle of of flight that is plane*/  )) /*try to test run the code ,, might be something wrong here*/
            {

                isGameOver = true /*false*/;
                return;
            }


        }




    }

    private void draw()
    {

        if(   getHolder().getSurface().isValid()    )
        {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background,background1.x,background1.y,paint);
            canvas.drawBitmap(background2.background,background2.x,background2.y,paint);

            for(Bird bird : birds)
                canvas.drawBitmap(bird.getBird(),bird.x,bird.y,paint);

            canvas.drawText(score + " ",screenX /2f ,164,paint);

            if(isGameOver)
            {
                isPlaying = false;
                canvas.drawBitmap(flight.getDead() , flight.x , flight.y,paint);
                getHolder().unlockCanvasAndPost(canvas);

                saveIfHighScore();

                waitBeforeExiting();

                return ; /*this means return from this method */
            }

/*
            for(Bird bird : birds)
                canvas.drawBitmap(bird.getBird(),bird.x,bird.y,paint);
*/





            canvas.drawBitmap(flight.getFlight() ,flight.x,flight.y , paint );

            for(Bullet bullet: bullets)
            {
                canvas.drawBitmap(bullet.bullet, bullet.x,bullet.y,paint);

            }
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void waitBeforeExiting() {

        try {
            Thread.sleep(3000);
            activity.startActivity(new Intent(activity ,MainActivity.class));
            activity.finish();



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void saveIfHighScore() {


        if (prefs.getInt("highscore",0)  < score)
        {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("highscore",score);
            editor.apply();
        }

    }

    private void sleep()
    {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }






//i think i need to debug this in order to debug my next case
    @Override
    public boolean onTouchEvent(MotionEvent event) {

       switch(event.getAction()  )
       {
//NOW I THINK THE CODE IS BETTER  ;D

/*you can not apply a condition over here you can only apply the condition inside a case */
           case MotionEvent.ACTION_DOWN:
              // mena ya aupar aislia kia ha ku main condition ager tru ho tbhe ya execute nai hona chyia ha

              //flight.toShoot
               if(event.getX() <  screenX / 6/*2*/ /*this is the orignal one*/)
               {

                  // flight.isGoingUp=false;
                   flight.isGoingUp=true; // this is the orignal one
                  // flight.toShoot++;  // this is the code that makes blueets to shoot

                   //flight.toShoot++;// i added this this is not its place
               }
               flight.toShoot++;
               break;

               case MotionEvent.ACTION_UP:
                   flight.toShoot++;
                  // flight.isGoingUp=true;
                  flight.isGoingUp=false; // this is orignal one
                   if (event.getX() > screenX /6/*2*/ /*this is the orignal one*/ )
                   {
                     //  flight.toShoot++; // i think this is the code for bullet shooting and this is its orignal position
                   }
               break;


// this alll bottom code is made up by me



       }



        return true;
    }



    public void newBullet() {

        if (!prefs.getBoolean("isMute", false))
            soundPool.play(sound,1,1,0,0,1);

        Bullet bullet = new Bullet(getResources() );

        bullet.x = flight.x + flight.width;

        bullet.y = flight.y + (flight.height /2);

        bullets.add(bullet);

    }
}
