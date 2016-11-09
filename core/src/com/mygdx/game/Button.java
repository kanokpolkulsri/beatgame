package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button extends ScreenAdapter{
	
	SpriteBatch batch;
	BeatGame beatGame;
	private Texture pressedColor_button;
	
	
	public Button(BeatGame beatGame){
		this.beatGame = beatGame;
		batch = beatGame.batch;
		pressedColor_button = new Texture("buttonWhenPressed.png");
	}
	
	@Override
	public void render(float delta){
		pressButton();
    }
	
	public int pressButton(){
		if(Gdx.input.isKeyJustPressed(Input.Keys.Z) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)){
			batch.draw(pressedColor_button, 14, 32);
			return 1;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.X) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)){
			batch.draw(pressedColor_button, 142, 32);
			return 2;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.C) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_3)){
			batch.draw(pressedColor_button, 272, 32);
			return 3;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.A) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)){
			batch.draw(pressedColor_button, 14, 150);
			return 4;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_5)){
			batch.draw(pressedColor_button, 142, 150);
			return 5;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)){
			batch.draw(pressedColor_button, 272, 150);
			return 6;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.Q) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_7)){
			batch.draw(pressedColor_button, 14, 270);
			return 7;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8)){
			batch.draw(pressedColor_button, 142, 270);
			return 8;
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.E) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_9)){
			batch.draw(pressedColor_button, 272, 270);
			return 9;
		}
		return 0;
	}
}
