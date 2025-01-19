package k1.chuyentin.com;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
public class GameScreen implements Screen {
    ShapeRenderer shapeRenderer;
    Master game;
    SpriteBatch batch;
    OrthographicCamera camera;
    Shark shark;
    Turtle turtle;
    Starfish starfish;
    Background2 background2;
    Texture tutrue;
    Win win;
    Stage stage;
    Rock rock;
    Rock rock1;
    Rock rock2;
    Rock rock3;
    Starfish starfish1;
    Starfish starfish2;
    Starfish starfish3;
    Texture w;
    Wi wi;
    Wi wi1;
    Wi wi2;
    Wi wi3;
    Wi wi4;
    Starfish starfish4;
    Sign sign;
    Sign sign1;
    Sound ex;
    int point=0;
    int p2= 5;
    Music nen;
    float fast = 0;
    String text;
    BitmapFont font;
    int x = 3;
    float y =0;
    Wine wines;
    public GameScreen(Master game){
        this.game = game;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,700,500);
        stage = new Stage();
        nen = Gdx.audio.newMusic(Gdx.files.internal("oc.ogg"));
        ex = Gdx.audio.newSound(Gdx.files.internal("Wd.ogg"));
        nen.play();
        font = new BitmapFont();
        shapeRenderer = new ShapeRenderer();

        //

        tutrue = new Texture("turtleani.png");
        background2 = new Background2(0,0,stage);
        turtle = new Turtle(tutrue, stage);
        turtle.setPosition(0,0);

        //
        text = "StarFish: " + p2;
        w = new Texture("whirlpool.png");
        wines = new Wine(new Texture("spa.png"));
        win = new Win(10000000,10000000,stage);
        shark = new Shark(0,400,stage);
        sign = new Sign(30,400,stage);
        sign1 = new Sign(70,400,stage);
        starfish = new Starfish(200,200,stage);
        starfish1 = new Starfish(500,200,stage);
        starfish2 = new Starfish(350,300,stage);
        starfish3 = new Starfish(350,100,stage);
        starfish4 = new Starfish(250,100,stage);
        rock = new Rock(200,100,stage);
        rock2 = new Rock(500,100,stage);
        rock1 = new Rock(200,300,stage);
        rock3 = new Rock(500,300,stage);
        wi = new Wi(w);
        wi1 = new Wi(w);
        wi2 = new Wi(w);
        wi3 = new Wi(w);
        wi4 = new Wi(w);
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("NewAmsterdam-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size =50;
        parameter.color = Color.GOLDENROD;
        font = generator.generateFont(parameter);
        generator.dispose();
    }
    @Override
    public void render(float v) {
        shark.moveBy(x,y);
        if (shark.getX() > 600){
            x =-3;
            shark.setScaleX(-1);
            y = MathUtils.random(-2,2);
        }
        if (shark.getX() < 0){
            x =3;
            shark.setScaleX(1);
            y = MathUtils.random(-2,2);
        }
        ScreenUtils.clear(Color.DARK_GRAY);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        stage.act();
        stage.draw();
        batch.begin();
        font.draw(batch,text, 450,400);
        batch.end();
        p2 = 5 - point;
        text = "StarFish:" + p2;
        if(point == 5){
            win.setPosition(120,200);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            turtle.rotateBy(2);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            turtle.rotateBy(-2);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            if (fast < 4){
                fast +=1;
            }
        }
        if(stage.getCamera().position.x <350){
            stage.getCamera().position.x =350;
        }
        if(stage.getCamera().position.x >700){
            stage.getCamera().position.x =700;
        }
        if(stage.getCamera().position.y <250){
            stage.getCamera().position.y =250;
        }
        if(stage.getCamera().position.y >500){
            stage.getCamera().position.y =500;
        }

        fast = (float) (fast*0.90);

        turtle.moveBy(fast * MathUtils.cosDeg(turtle.getRotation()), fast * MathUtils.sinDeg(turtle.getRotation()));


        if ((turtle.getY() > 250 - turtle.getHeight()/2 ) && (turtle.getY() <= Gdx.graphics.getHeight()  -  turtle.getHeight()/2)){
            stage.getCamera().position.y = turtle.getY() + turtle.getHeight()/2;
        }
        if ((turtle.getX() > 350 - turtle.getWidth()/2) && (turtle.getX() <= Gdx.graphics.getWidth()  - turtle.getWidth()/2)){
            stage.getCamera().position.x = turtle.getX() + turtle.getWidth()/2;
        }


        if(Intersector.overlapConvexPolygons(turtle.getPolygon(),starfish.getPolygon())){
            ex.play();
            point +=1;
            if(point == 5){
                wines.setPosition(starfish.getX()- starfish.getWidth()/2,starfish.getY());
                stage.addActor(wines);
                starfish.remove();
                starfish.polygon.setPosition(10000,10000);
            }else {
                wi.setPosition(starfish.getX()- starfish.getWidth()/2,starfish.getY());
                stage.addActor(wi);
                starfish.remove();
                starfish.polygon.setPosition(10000,10000);
            }
        }
        if((Intersector.overlapConvexPolygons(turtle.getPolygon(),rock.getPolygon())) ||(Intersector.overlapConvexPolygons(turtle.getPolygon(),rock1.getPolygon())) ||(Intersector.overlapConvexPolygons(turtle.getPolygon(),rock2.getPolygon())) ||(Intersector.overlapConvexPolygons(turtle.getPolygon(),rock3.getPolygon()))||(Intersector.overlapConvexPolygons(turtle.getPolygon(),sign.getPolygon())) ||(Intersector.overlapConvexPolygons(turtle.getPolygon(),sign1.getPolygon())) ){
            turtle.moveBy((-fast+3) * MathUtils.cosDeg(turtle.getRotation()), -fast * MathUtils.sinDeg(turtle.getRotation()));
        }
        if(Intersector.overlapConvexPolygons(turtle.getPolygon(),starfish4.getPolygon())){
            ex.play();
            point = point +1;
            if(point == 5){
                wines.setPosition(starfish4.getX()- starfish2.getWidth()/2,starfish4.getY());
                stage.addActor(wines);
                starfish4.remove();
                starfish4.polygon.setPosition(10000,10000);
            }else {
                wi1.setPosition(starfish4.getX()- starfish2.getWidth()/2,starfish4.getY());
                stage.addActor(wi1);
                starfish4.remove();
                starfish4.polygon.setPosition(10000,10000);
            }
        }
        if(Intersector.overlapConvexPolygons(turtle.getPolygon(),starfish1.getPolygon())){
            point = point +1;
            if(point == 5){
                wines.setPosition(starfish1.getX()- starfish2.getWidth()/2,starfish1.getY());
                stage.addActor(wines);
                starfish1.remove();
                starfish1.polygon.setPosition(10000,10000);
            }else {
                wi2.setPosition(starfish1.getX()- starfish2.getWidth()/2,starfish1.getY());
                stage.addActor(wi2);
                starfish1.remove();
                starfish1.polygon.setPosition(10000,10000);
            }
        }
        if(Intersector.overlapConvexPolygons(turtle.getPolygon(),starfish2.getPolygon())){
            point = point +1;
            if(point == 5){
                wines.setPosition(starfish2.getX()- starfish2.getWidth()/2,starfish2.getY());
                stage.addActor(wi);
                starfish2.remove();
                starfish2.polygon.setPosition(10000,10000);
            }else {
                wi3.setPosition(starfish2.getX()- starfish2.getWidth()/2,starfish2.getY());
                stage.addActor(wi3);
                starfish2.remove();
                starfish2.polygon.setPosition(10000,10000);
            }
        }
        if(Intersector.overlapConvexPolygons(turtle.getPolygon(),starfish3.getPolygon())){
            point = point +1;
            if(point == 5){
                wines.setPosition(starfish3.getX()- starfish3.getWidth()/2,starfish3.getY());
                stage.addActor(wines);
                starfish3.remove();
                starfish3.polygon.setPosition(10000,10000);
            }else {
                wi4.setPosition(starfish3.getX()- starfish3.getWidth()/2,starfish3.getY());
                stage.addActor(wi4);
                starfish3.remove();
                starfish3.polygon.setPosition(10000,10000);
            }
        }
        if(Gdx.input.isTouched()){
            System.out.println(Gdx.input.getX() + "y"+ (480 - Gdx.input.getY()) );
        }
       // shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
      //  shapeRenderer.setColor(Color.RED);
      //  shapeRenderer.polygon(turtle.polygon.getTransformedVertices());
      //  shapeRenderer.setColor(Color.GREEN);
       // shapeRenderer.polygon(starfish.polygon.getTransformedVertices());
      //  shapeRenderer.end();
    }
    @Override
    public void resize(int i, int i1) {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void hide() {
    }
    @Override
    public void dispose() {
    }
    @Override
    public void show() {
    }
}
