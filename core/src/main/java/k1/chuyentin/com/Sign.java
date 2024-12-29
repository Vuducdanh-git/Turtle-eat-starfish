package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Sign extends Actor {
    TextureRegion rock;
    Polygon polygon;

    Sign(float x, float y, Stage apps){
        rock = new TextureRegion(new Texture("sign.png"));
        setSize(rock.getRegionWidth(), rock.getRegionHeight());
        setPosition(x,y);
        setOrigin(getWidth()/2,getHeight()/2);
        apps.addActor(this);
        float [] tdcd ={
            38,1,
            38,6,
            64,7,
            62,49,
            39,49,
            31,55,
            26,50,
            1,47,
            0,0,
            25,6,
            27,1,
        };
        polygon = new Polygon(tdcd);
        polygon.setOrigin(getWidth()/2,getHeight()/2);
        polygon.setPosition(getX(),getY());

    }
    public void act(float delta){
        super.act(delta);
        polygon.setPosition(getX(),getY());
        polygon.setRotation(getRotation());
    }
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(rock,getX(),getY(),getOriginX(),getOriginY(),getWidth(),getHeight(),1,1,getRotation());
    }

    public Polygon getPolygon() {
        return polygon;
    }
}
