package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private BeatGame beatGame;
	private Texture backGround;
	SpriteBatch batch;
	
	Button button;
	EasyMode easyMode;
	HardMode hardMode;
	Time time;
	DazzButton dazzButton;
	PointScore pointScore;
	Gage gage;
	Music music;
	ContextOnPage contextOnPage;
	
    public GameScreen(BeatGame beatGame){
        this.beatGame = beatGame;
        batch = beatGame.batch;
        backGround = new Texture("backGround.png");
        time = new Time(beatGame);
        button = new Button(beatGame);
        dazzButton = new DazzButton(beatGame);
        easyMode = new EasyMode(beatGame, time, dazzButton);
        hardMode = new HardMode(beatGame, time, dazzButton);
        pointScore = new PointScore(beatGame, easyMode, hardMode, button, this, time);
        gage = new Gage(beatGame, pointScore, time);
        music = new Music(beatGame, button);
        contextOnPage = new ContextOnPage(beatGame, pointScore, time);
    }
    
    @Override
    public void render(float delta){

    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backGround();
        batch.begin();
        contextOnPage.render(delta);
        time.update(delta);
        button.render(delta);
        //easyMode.render(delta);
        hardMode.render(delta);
        gage.update();
        pointScore.render(delta);
        music.update();
        batch.end();
        
    }
    
    public void backGround(){
    	batch.begin();
    	batch.draw(backGround, 0, 0);
    	batch.end();
    }
    
    public Gage getGage() {
    	return gage;
    }
}
