package com.usmanisolutions.shoot_the_bird_not_flappy_bird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Flight
{
    int toShoot=0;
    boolean isGoingUp = false;
    int x,y,width,height,wingCounter=0,shootCounter=1;
Bitmap flight1,flight2,shoot1,shoot2,shoot3,shoot4,shoot5,dead;

private GameView gameView;

Flight( GameView gameView ,   int screenY , Resources res)
{

    this.gameView = gameView;


    flight1 = BitmapFactory.decodeResource(res , R.drawable.fly1);
    flight2 = BitmapFactory.decodeResource(res,R.drawable.fly2);

    width = flight1.getWidth();

    height = flight1.getHeight();
/*i changed the width and height over here of my plane */
    width /=14; // this changes the size of plane  // 4 for big birds and 60 for small birds  ,,   increasing the value will decrease the size , decreasing tha value will increase the size

    height /=14; // this changes the size of the plane // 4 for big birds and 60 for small birds  ,,   increasing the value will decrease the size , decreasing tha value will increase the size

    width = (int ) (width* GameView.screenRatioX);
    height = (int ) (height* GameView.screenRatioY);

    flight1 = Bitmap.createScaledBitmap(flight1 , width,height,false);

    flight2 = Bitmap.createScaledBitmap(flight2 , width , height, false);


    shoot1 = BitmapFactory.decodeResource( res ,R.drawable.shoot1 );
    shoot2 = BitmapFactory.decodeResource( res ,R.drawable.shoot2 );
    shoot3 = BitmapFactory.decodeResource( res ,R.drawable.shoot3 );
    shoot4 = BitmapFactory.decodeResource( res ,R.drawable.shoot4 );
    shoot5 = BitmapFactory.decodeResource( res ,R.drawable.shoot5 );


    shoot1 = Bitmap.createScaledBitmap(shoot1,width,height,false);
    shoot2 = Bitmap.createScaledBitmap(shoot2,width,height,false);
    shoot3 = Bitmap.createScaledBitmap(shoot3,width,height,false);
    shoot4 = Bitmap.createScaledBitmap(shoot4,width,height,false);
    shoot5 = Bitmap.createScaledBitmap(shoot5,width,height,false);


    dead = BitmapFactory.decodeResource(res,R.drawable.dead); /*this  is some how we are fetching our resources from resources folder into class*/

    dead = Bitmap.createScaledBitmap(dead,width,height,false);

    y= screenY /2; // flight will be center vertically by this

    x=(int) (64 * GameView.screenRatioX);


}

Bitmap getFlight ()
{


    // we use &&    to  replace nested if
    // we use ||  to replace else if ladder
    if(toShoot !=0 )
    {
     if(shootCounter == 1)
     {
         shootCounter++;
         return  shoot1;
     }

     if(shootCounter ==2)
     {
         shootCounter++;
         return shoot2;
     }



        if(shootCounter ==3)
        {
            shootCounter++;
            return shoot3;
        }

        if(shootCounter ==4)
        {
            shootCounter++;
            return shoot4;
        }


        shootCounter =1;
        toShoot--;
        gameView.newBullet();


        return shoot5; // this is the orignal one

    }




if(wingCounter == 0)
{
    wingCounter++;
    return flight1;
}

wingCounter--;
return flight2;

}


    Rect getCollisionShape()// this function will create rectangle around the plane
    {
        return  new Rect(x,y,x+ width , y+height);
    }

    Bitmap getDead()
    {
        return dead;
    }


}
