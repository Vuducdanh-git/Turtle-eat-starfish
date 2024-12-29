package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Win extends Actor {
    Texture win;
    Win(float x, float y, Stage apps) {
        win = new Texture("you-win.png");
        setPosition(x ,y);
        apps.addActor(this);
    }
    public void draw(Batch batch, float parentAlpha){
        batch.draw(win,getX(),getY());
    }
}
