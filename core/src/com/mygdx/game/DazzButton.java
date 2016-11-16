package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class DazzButton extends ScreenAdapter {
	
	private SpriteBatch batch;
	private Texture changeColor1_button;
	private Texture changeColor2_button;
	private Texture changeColor3_button;
	private Texture changeColor4_button;
	private Texture changeColor5_button;
	private int x = 0, y = 0;
	
	public DazzButton(BeatGame beatGame) {
		batch = beatGame.batch;
		changeColor1_button = new Texture("changeColor1_button.png");
		changeColor2_button = new Texture("changeColor2_button.png");
		changeColor3_button = new Texture("changeColor3_button.png");
		changeColor4_button = new Texture("changeColor4_button.png");
		changeColor5_button = new Texture("changeColor5_button.png");
		
	}

	public void screenShowColor(int x, int y, int timeEasyMode, int timeEasyModeMaxInRound, int period) {
		if (timeEasyMode<timeEasyModeMaxInRound+period) {
			batch.draw(changeColor5_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 2) {
			batch.draw(changeColor4_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 3) {
			batch.draw(changeColor4_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 4) {
			batch.draw(changeColor3_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 5) {
			batch.draw(changeColor3_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 6) {
			batch.draw(changeColor2_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 7) {
			batch.draw(changeColor2_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 8) {
			batch.draw(changeColor1_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 9) {
			batch.draw(changeColor1_button, x, y);
		} else if (timeEasyMode < timeEasyModeMaxInRound + period * 10) {
			batch.draw(changeColor1_button, x, y);
		}
	}

	public int positionXFromRandomNumber(int number) {
		if (number == 1) {
			x=14;
		} else if (number == 2) {
			x=142;
		} else if (number == 3) {
			x=272;
		} else if (number == 4) {
			x=14;
		} else if (number == 5) {
			x=142;
		} else if (number == 6) {
			x=272;
		} else if (number == 7) {
			x=14;
		} else if (number == 8) {
			x=142;
		} else if (number == 9) {
			x=272;
		}
		return x;
	}
	
	public int positionYFromRandomNumber(int number) {
		if (number == 1) {
			y=32;
		} else if (number == 2) {
			y=32;
		} else if (number == 3) {
			y=32;
		} else if (number == 4) {
			y=150;
		} else if (number == 5 ){
			y=150;
		} else if (number == 6) {
			y=150;
		} else if (number == 7) {
			y=270;
		} else if (number == 8) {
			y=270;
		} else if (number == 9) {
			y=270;
		}
		return y;
	}
}
