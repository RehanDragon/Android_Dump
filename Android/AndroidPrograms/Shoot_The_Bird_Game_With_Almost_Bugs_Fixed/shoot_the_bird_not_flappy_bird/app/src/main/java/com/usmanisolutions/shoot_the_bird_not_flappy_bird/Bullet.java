package com.usmanisolutions.shoot_the_bird_not_flappy_bird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.usmanisolutions.stb.GameView.screenRatioX;
import static com.usmanisolutions.stb.GameView.screenRatioY;

public class Bullet {


    int x,y,width,height;

    Bitmap bullet;

    Bullet (Resources res)
    {

        bullet = BitmapFactory.decodeResource(res, R.drawable.bullet);
         width = bullet.getWidth();
         height = bullet.getHeight();



        width /=9;  // 4 ,,   increasing the value will decrease the size , decreasing tha value will increase the size

        height/=9;   // 4   ,,   increasing the value will decrease the size , decreasing tha value will increase the size

        width = (int ) (width*screenRatioX);
        height = (int ) (height*screenRatioY);

        bullet = Bitmap.createScaledBitmap(bullet,width,height,false);
    }
// we need to fix thi getCollisionShape()

    Rect getCollisionShape()// this makes the rectangle around the bullet
    {
        return  new Rect(x,y,x+ width , y+height);
    }
}
