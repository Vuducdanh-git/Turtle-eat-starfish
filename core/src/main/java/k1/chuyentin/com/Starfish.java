package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Starfish extends Actor {
    TextureRegion sf;
    Polygon polygon;
    float huong = 0;
    Starfish(float x,float y, Stage apps){
        sf = new TextureRegion(new Texture("starfish.png"));
        setSize(sf.getRegionWidth(), sf.getRegionHeight());
        setPosition(x ,y);
        setOrigin(getWidth()/2,getHeight()/2);
        apps.addActor(this);
        float [] tdcd ={
            30,52,
            1,28,
            11,1,
            48,2,
            58,26,
        };
        polygon = new Polygon(tdcd);
        polygon.setOrigin(getWidth()/2,getHeight()/2);
        polygon.setPosition(getX(),getY());
    }
    public void act(float delta){
        super.act(delta);
        polygon.setPosition(getX(),getY());
        polygon.setRotation(getRotation());
        huong = huong -2;
        setRotation(huong);
    }
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(sf,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),1,1,getRotation());
    }

    public Polygon getPolygon() {
        return polygon;
    }
}
