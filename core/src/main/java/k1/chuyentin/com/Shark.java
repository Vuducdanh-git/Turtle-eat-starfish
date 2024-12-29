package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Shark extends Actor {
    TextureRegion shark;
    Shark(float x, float y , Stage apps) {
        shark = new TextureRegion(new Texture("sharky.png"));
        setSize(shark.getRegionWidth(),shark.getRegionHeight());
        setPosition(x ,y);
        setOrigin(getWidth()/2,getHeight()/2);
        apps.addActor(this);
    }


    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(shark,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),getScaleX(),getScaleY(),getRotation());
    }
}
