package com.usmanisolutions.mb.Sprites.TileObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.math.Rectangle;

//aisa aistmal kro
//import com.usmanisolutions.mb.
import com.usmanisolutions.mb.MB;
import com.usmanisolutions.mb.Scenes.Hud;
import com.usmanisolutions.mb.Screens.PlayScreen;
import com.usmanisolutions.mb.Sprites.Mario;


public class Brick extends InteractiveTileObject{
    public Brick(PlayScreen screen, MapObject object){
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MB.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if(mario.isBig()) {
            setCategoryFilter(MB.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MB.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MB.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }
}
