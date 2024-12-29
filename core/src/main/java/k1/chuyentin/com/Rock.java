package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Rock extends Actor {
    TextureRegion rock;
    Polygon polygon;

    Rock(float x,float y, Stage apps){
        rock = new TextureRegion(new Texture("rock.png"));
        setSize(rock.getRegionWidth(), rock.getRegionHeight());
        setPosition(x,y);
        setOrigin(getWidth()/2,getHeight()/2);
        apps.addActor(this);
        float [] tdcd ={
            34,63,
            19,59,
            5,37,
            3,18,
            18,8,
            45,9,
            60,30,
            51,56,
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
