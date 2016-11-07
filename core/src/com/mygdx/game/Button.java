package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button extends ScreenAdapter{
	private Texture b1;
	private Texture b5;
	private Texture b10;
	private Texture b15;
	private Texture b20;
	SpriteBatch batch;
	BeatGame beatGame;
	
	public Button(BeatGame beatGame){
		this.beatGame = beatGame;
		batch = beatGame.batch;
		b1 = new Texture("b1.png");
		b5 = new Texture("b5.png");
		b10 = new Texture("b10.png");
		b15 = new Texture("b15.png");
		b20 = new Texture("b20.png");
	}
	
	@Override
	public void render(float delta) {
		if(Gdx.input.isKeyJustPressed(Input.Keys.Z) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1))
		{
			batch.draw(b1, 14, 32);
		}
    }
}
