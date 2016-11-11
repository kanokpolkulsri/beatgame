package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FirstPage {
	
	SpriteBatch batch;
	Button button;
	Texture firstPage;
	Texture frameFirstPage;
	private int positionFrameX = 125, positionFrameY = 300;
	public int numberSong = 0;
	
	public FirstPage(BeatGame beatGame, Button button) {
		batch = beatGame.batch;
		this.button = button;
		firstPage = new Texture("firstPage2.png");
		frameFirstPage = new Texture("frameFirstPage.png");
	}
	
	public void render() {
		batch.draw(firstPage, 0, 0);
		buttonSong();
		selectSong();
	}
	
	public void selectSong() {
		if (positionFrameY == 300) {
			numberSong = 1;
		} else if (positionFrameY == 213) {
			numberSong = 2;
		} else if (positionFrameY == 126) {
			numberSong = 3;
		} else {
			numberSong = 0;
		}
	}
	
	public int getNumberSong() {
		return numberSong;
	}
	
	public void buttonSong() {
		batch.draw(frameFirstPage, positionFrameX, positionFrameY);
		if (button.pressDirectionButton() == 11) {
			if (positionFrameY < 300) {
				positionFrameY += 87;
			}
		} else if (button.pressDirectionButton() == 12) {
			if(positionFrameY > 126) {
				positionFrameY -= 87;
			}
		} 
	}
}
