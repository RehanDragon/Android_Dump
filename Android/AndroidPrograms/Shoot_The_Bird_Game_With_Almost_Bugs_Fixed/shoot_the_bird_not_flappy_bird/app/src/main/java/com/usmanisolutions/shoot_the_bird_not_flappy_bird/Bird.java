package com.usmanisolutions.shoot_the_bird_not_flappy_bird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Bird {
    public int speed=/*20*/90; // this is bird speed
    public boolean wasShot=true;
    int x=0,y,width,height,birdCounter=1;
    Bitmap bird1,bird2,bird3,bird4;

    Bird(Resources res)
    {
        // these are 4 animated pics of one bird which will make the bird looking flying
        bird1 = BitmapFactory.decodeResource(res , R.drawable.bird1);
        bird2 = BitmapFactory.decodeResource(res ,R.drawable.bird2);
        bird3 = BitmapFactory.decodeResource(res ,R.drawable.bird3);
        bird4 = BitmapFactory.decodeResource(res ,R.drawable.bird4);


        width = bird1.getWidth();
        height = bird1.getHeight();



/*these values will change the width and height of  birds coming random*/
        width /= 30; // 6 for big birds and 60 for small birds  ,,   increasing the value will decrease the size , decreasing tha value will increase the size

        height /=30;  // 6 for big birds and 60 for small birds  ,,   increasing the value will decrease the size , decreasing tha value will increase the size


        width = (int ) (width* GameView.screenRatioX);
        height = (int ) (height* GameView.screenRatioY);


        bird1 = Bitmap.createScaledBitmap(bird1,width,height,false);
        bird2 = Bitmap.createScaledBitmap(bird2,width,height,false);
        bird3 = Bitmap.createScaledBitmap(bird3,width,height,false);
        bird4 = Bitmap.createScaledBitmap(bird4,width,height,false);



        y= -height;





    }

    Bitmap getBird()
    {

        if (birdCounter==1)
    {
        birdCounter++;
        return bird1;
    }
        if (birdCounter==2)
        {
            birdCounter++;
            return bird2;
        }

        if (birdCounter==3)
        {
            birdCounter++;
            return bird3;
        }

        birdCounter =1;

        return bird4;
    }


    Rect getCollisionShape() // this function will create rectangle around the bird
    {
        return  new Rect(x,y ,x+ width , y+height);
    }

}
