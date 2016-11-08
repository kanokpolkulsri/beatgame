package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PointScore {
	
	SpriteBatch batch;
	BeatGame beatGame;
	EasyMode easyMode;
	HardMode hardMode;
	Button button;
	
	public int score=0, pointGage=0;
	private int numberWhichIsAnswered [] = new int [1];
	
	public PointScore(BeatGame beatGame, EasyMode easyMode, HardMode hardMode, Button button){
		this.beatGame = beatGame;
		this.easyMode = easyMode;
		this.hardMode = hardMode;
		this.button = button;
		numberWhichIsAnswered[0] = 0;
	}
	
	public void update(){
		if(easyMode.getNumberWhichIsRandomed() == button.pressButton() && button.pressButton() != numberWhichIsAnswered[0]){
			score++;
			if(pointGage <= 27){
				pointGage++;
			}
			//System.out.println(pointGage);
			numberWhichIsAnswered[0] = button.pressButton();
		}else if(easyMode.getNumberWhichIsRandomed() != button.pressButton() && button.pressButton() != 0 && score > 0){
			score--;
			pointGage = 0;
			//System.out.println(pointGage);
		}
	}
	
	public int getPointGage(){
		return pointGage;
	}
	
	
}
