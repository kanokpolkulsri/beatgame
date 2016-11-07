package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private BeatGame beatGame;
	private Texture gage;
	private Texture backGround;
	SpriteBatch batch;
	
    public GameScreen(BeatGame beatGame) {
        this.beatGame = beatGame;
        batch = beatGame.batch;
        gage = new Texture("gage.png");
        backGround = new Texture("backGround.png");
    }
    
    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        backGround();
        batch.begin();
        batch.draw(gage, 100, 100);
        batch.end();
    }
    
    public void backGround(){
    	batch.begin();
    	batch.draw(backGround, 0, 0);
    	batch.end();
    }
}
