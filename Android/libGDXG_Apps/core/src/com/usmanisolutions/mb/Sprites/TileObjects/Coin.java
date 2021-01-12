package com.usmanisolutions.mb.Sprites.TileObjects;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

//aisa aistmal kro
//import com.usmanisolutions.mb.
import com.usmanisolutions.mb.MB;
import com.usmanisolutions.mb.Scenes.Hud;
import com.usmanisolutions.mb.Screens.PlayScreen;
import com.usmanisolutions.mb.Sprites.Items.ItemDef;
import com.usmanisolutions.mb.Sprites.Items.Mushroom;
import com.usmanisolutions.mb.Sprites.Mario;

public class Coin extends InteractiveTileObject{
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;

    public Coin(PlayScreen screen, MapObject object){
        super(screen, object);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(MB.COIN_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if(getCell().getTile().getId() == BLANK_COIN)
            MB.manager.get("audio/sounds/bump.wav", Sound.class).play();
        else {
            if(object.getProperties().containsKey("mushroom")) {
                screen.spawnItem(new ItemDef(new Vector2(body.getPosition().x, body.getPosition().y + 16 / MB.PPM),
                        Mushroom.class));
                MB.manager.get("audio/sounds/powerup_spawn.wav", Sound.class).play();
            }
            else
                MB.manager.get("audio/sounds/coin.wav", Sound.class).play();
            getCell().setTile(tileSet.getTile(BLANK_COIN));
            Hud.addScore(100);
        }
    }

}
