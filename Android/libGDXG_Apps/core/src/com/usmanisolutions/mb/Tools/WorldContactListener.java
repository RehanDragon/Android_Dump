package com.usmanisolutions.mb.Tools;
//Make Sprites First
//aisa aistmal kro
//import com.usmanisolutions.mb.



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

import com.usmanisolutions.mb.MB;
import com.usmanisolutions.mb.Sprites.Enemies.Enemy;
import com.usmanisolutions.mb.Sprites.Items.Item;
import com.usmanisolutions.mb.Sprites.Mario;
import com.usmanisolutions.mb.Sprites.Other.FireBall;
import com.usmanisolutions.mb.Sprites.TileObjects.InteractiveTileObject;



public class WorldContactListener implements ContactListener{

    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        switch (cDef){
            case MB.MARIO_HEAD_BIT | MB.BRICK_BIT:
            case MB.MARIO_HEAD_BIT | MB.COIN_BIT:
                if(fixA.getFilterData().categoryBits == MB.MARIO_HEAD_BIT)
                    ((InteractiveTileObject) fixB.getUserData()).onHeadHit((com.usmanisolutions.mb.Sprites.Mario) fixA.getUserData());
                else
                    ((InteractiveTileObject) fixA.getUserData()).onHeadHit((com.usmanisolutions.mb.Sprites.Mario) fixB.getUserData());
                break;
            case MB.ENEMY_HEAD_BIT | MB.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == MB.ENEMY_HEAD_BIT)
                    ((com.usmanisolutions.mb.Sprites.Enemies.Enemy)fixA.getUserData()).hitOnHead((com.usmanisolutions.mb.Sprites.Mario) fixB.getUserData());
                else
                    ((com.usmanisolutions.mb.Sprites.Enemies.Enemy)fixB.getUserData()).hitOnHead((com.usmanisolutions.mb.Sprites.Mario) fixA.getUserData());
                break;
            case MB.ENEMY_BIT | MB.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MB.ENEMY_BIT)
                    ((com.usmanisolutions.mb.Sprites.Enemies.Enemy)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((com.usmanisolutions.mb.Sprites.Enemies.Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MB.MARIO_BIT | MB.ENEMY_BIT:
                if(fixA.getFilterData().categoryBits == MB.MARIO_BIT)
                    ((com.usmanisolutions.mb.Sprites.Mario) fixA.getUserData()).hit((com.usmanisolutions.mb.Sprites.Enemies.Enemy)fixB.getUserData());
                else
                    ((com.usmanisolutions.mb.Sprites.Mario) fixB.getUserData()).hit((com.usmanisolutions.mb.Sprites.Enemies.Enemy)fixA.getUserData());
                break;
            case MB.ENEMY_BIT | MB.ENEMY_BIT:
                ((com.usmanisolutions.mb.Sprites.Enemies.Enemy)fixA.getUserData()).hitByEnemy((Enemy)fixB.getUserData());
                ((com.usmanisolutions.mb.Sprites.Enemies.Enemy)fixB.getUserData()).hitByEnemy((Enemy)fixA.getUserData());
                break;
            case MB.ITEM_BIT | MB.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MB.ITEM_BIT)
                    ((com.usmanisolutions.mb.Sprites.Items.Item)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((com.usmanisolutions.mb.Sprites.Items.Item)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case MB.ITEM_BIT | MB.MARIO_BIT:
                if(fixA.getFilterData().categoryBits == MB.ITEM_BIT)
                    ((com.usmanisolutions.mb.Sprites.Items.Item)fixA.getUserData()).use((Mario) fixB.getUserData());
                else
                    ((com.usmanisolutions.mb.Sprites.Items.Item)fixB.getUserData()).use((Mario) fixA.getUserData());
                break;
            case MB.FIREBALL_BIT | MB.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == MB.FIREBALL_BIT)
                    ((com.usmanisolutions.mb.Sprites.Other.FireBall)fixA.getUserData()).setToDestroy();
                else
                    ((/*FireBall*/com.usmanisolutions.mb.Sprites.Other.FireBall) fixB.getUserData()).setToDestroy();

                break;
        }
        /* yehan pa pura package name aye ga ager khale class ko bulao ga na to ausa nazar nai aye ga tbhe pura package ka path dena pra*/
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

}
