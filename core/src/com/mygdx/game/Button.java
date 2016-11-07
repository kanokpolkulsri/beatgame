package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Button extends ScreenAdapter{
	private Texture changeColor1_button;
	private Texture changeColor2_button;
	private Texture changeColor3_button;
	private Texture changeColor4_button;
	private Texture changeColor5_button;
	private Texture pressedColor_button;
	SpriteBatch batch;
	BeatGame beatGame;
	
	public Button(BeatGame beatGame){
		this.beatGame = beatGame;
		batch = beatGame.batch;
		changeColor1_button = new Texture("b1.png");
		changeColor2_button = new Texture("b5.png");
		changeColor3_button = new Texture("b10.png");
		changeColor4_button = new Texture("b15.png");
		changeColor5_button = new Texture("b20.png");
		pressedColor_button = new Texture("buttonclick.png");
	}
	
	@Override
	public void render(float delta) {
		pressButton();
    }
	
	public void pressButton(){
		if(Gdx.input.isKeyJustPressed(Input.Keys.Z) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_1)){
			batch.draw(pressedColor_button, 14, 32);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.X) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_2)){
			batch.draw(pressedColor_button, 142, 32);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.C) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_3)){
			batch.draw(pressedColor_button, 272, 32);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.A) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_4)){
			batch.draw(pressedColor_button, 14, 150);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.S) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_5)){
			batch.draw(pressedColor_button, 142, 150);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.D) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_6)){
			batch.draw(pressedColor_button, 272, 150);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.Q) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_7)){
			batch.draw(pressedColor_button, 14, 270);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.W) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8)){
			batch.draw(pressedColor_button, 142, 270);
		}
		if(Gdx.input.isKeyJustPressed(Input.Keys.E) | Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_9)){
			batch.draw(pressedColor_button, 272, 270);
		}
	}
}
