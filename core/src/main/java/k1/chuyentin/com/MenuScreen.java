package k1.chuyentin.com;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;

public class MenuScreen implements Screen {
    Master game;
    OrthographicCamera camera;
    Background2 background2;
    Texture sc ;

    public MenuScreen(Master game){
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("NewAmsterdam-Regular.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 50;
        fontParameter.color = Color.RED;
        game.font = fontGenerator.generateFont(fontParameter);



        game.buttonStage = new Stage();
        background2 = new Background2(0,0,game.buttonStage);


        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = game.font;
        style.up = new TextureRegionDrawable(new Texture("but.png"));
        style.fontColor = Color.YELLOW;

        TextButton startButton = new TextButton("START", style);
        startButton.setSize(150,100);
        startButton.setPosition(Gdx.graphics.getWidth()/4 - startButton.getWidth()/2, Gdx.graphics.getHeight()/2 - 2*startButton.getHeight());
        startButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new GameScreen(game));
            }
        });


        TextButton startButtons = new TextButton("Quit", style);
        startButtons.setSize(150,100);
        startButtons.setPosition(Gdx.graphics.getWidth()/2 - startButtons.getWidth()/2 + Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/2 - 2*startButtons.getHeight());
        startButtons.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });
        game.buttonStage.addActor(startButton);
        game.buttonStage.addActor(startButtons);
        Gdx.input.setInputProcessor(game.buttonStage);

        sc = new Texture(Gdx.files.internal("sc.png"));

    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(Color.GRAY);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.buttonStage.act(Gdx.graphics.getDeltaTime());
        game.buttonStage.draw();
        game.batch.begin();
        game.batch.draw(sc,100,200);
        game.batch.end();

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
}
