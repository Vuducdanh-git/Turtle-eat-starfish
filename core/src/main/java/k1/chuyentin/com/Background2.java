package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Background2 extends Actor {
    Texture waters;
    Background2(float x, float y, Stage apps) {
        waters = new Texture("water-border.jpg");
        setPosition(x ,y);
        apps.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(waters,getX(),getY());
    }
}

