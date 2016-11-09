package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PointScore extends ScreenAdapter {
	
	SpriteBatch batch;
	BeatGame beatGame;
	EasyMode easyMode;
	HardMode hardMode;
	Button button;
	
	public int score=0, pointGage=0, maxPointGage=27, undoingGage=1, doingGage=2;
	private int numberWhichIsAnswered [] = new int [1];
	
	public PointScore(BeatGame beatGame, EasyMode easyMode, HardMode hardMode, Button button){
		this.beatGame = beatGame;
		this.easyMode = easyMode;
		this.hardMode = hardMode;
		this.button = button;
		batch = beatGame.batch;
		numberWhichIsAnswered[0] = 0;
	}
	
	@Override
	public void render(float delta){
		updateScoreAndPointGage();
	}
	
	public void updateScoreAndPointGage(){
		if((easyMode.getNumberWhichIsRandomed() == button.pressButton()  || hardMode.getNumberWhichIsRandomed() == button.pressButton())&& button.pressButton() != numberWhichIsAnswered[0]){
			score += 1;
			if(pointGage < maxPointGage){
				pointGage += 1;
			} else if (pointGage == maxPointGage) {
				pointGage = maxPointGage;
			}
			System.out.println(score);
			numberWhichIsAnswered[0] = button.pressButton();
		}else if((easyMode.getNumberWhichIsRandomed() != button.pressButton() || hardMode.getNumberWhichIsRandomed() != button.pressButton())&& button.pressButton() != 0 && score > 0){
			score -= 1;
			pointGage = 0;
			System.out.println(score);
		}
	}
	
	public int getPointScore(){
		return score;
	}
	
	public int getPointGage(){
		return pointGage;
	}
	
	
}
