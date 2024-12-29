package k1.chuyentin.com;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Turtle extends Actor {
    Animation<TextureRegion> animation;
    float time;
    Polygon polygon;
    Turtle(Texture texture,Stage apps){
        setOrigin(getWidth()/2,getHeight()/2);
        int cot = 6;
        int hang = 1;
        setSize(texture.getWidth()/cot, texture.getHeight()/hang);
        float speed = 0.1f;
        TextureRegion[][] tam = TextureRegion.split(texture, texture.getWidth()/cot, texture.getHeight()/hang);// đưa tất cả vào danh một danh sách ảnh, vì 6 cột 1 hàng nên sẽ có 6 phần tử: 6 x 1
        TextureRegion[] frames = new TextureRegion[cot*hang];
        int index = 0;
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < cot; j++) {
                frames[index++] = tam[i][j];
            }
        }
        animation = new com.badlogic.gdx.graphics.g2d.Animation<TextureRegion>(speed, frames);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        time = 0;
        setOrigin(getWidth()/2,getHeight()/2);
        apps.addActor(this);
        float[] dagiac = {
            44,11,
            74,31,
            74,41,
            99,43,
            99,55,
            74,52,
            64,89,
            61,70,
            15,67,
            2,69,
            3,61,
            12,58,
            13,39,
            4,37,
            4,28,
            20,30,
            59,28
        };
        polygon = new Polygon(dagiac);
        polygon.setOrigin(getWidth()/2,getHeight()/2);
        polygon.setPosition(getX(),getY());

    }
    public void act(float delta){
        super.act(delta);
        polygon.setPosition(getX(),getY());
        polygon.setRotation(getRotation());
        time += delta;

    }
    public void draw(Batch batch, float parentAlpha) {
        TextureRegion currentFrame = animation.getKeyFrame(time);
        batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), 1, 1, getRotation());

    }

    public Polygon getPolygon() {
        return polygon;
    }
}
