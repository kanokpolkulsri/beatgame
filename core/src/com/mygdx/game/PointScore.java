package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PointScore extends ScreenAdapter {
	
	SpriteBatch batch;
	BeatGame beatGame;
	EasyMode easyMode;
	HardMode hardMode;
	Button button;
	Gage gage;
	Time time;
	GameScreen gameScreen;
	
	public int score=0, pointGage=25, maxPointGage=27, undoingGage=1, doingGage=2;
	private boolean useGage = false;
	private int numberWhichIsAnswered [] = new int [1];
	
	public PointScore(BeatGame beatGame, EasyMode easyMode, HardMode hardMode, Button button, GameScreen gameScreen, Time time){
		this.beatGame = beatGame;
		this.easyMode = easyMode;
		this.hardMode = hardMode;
		this.button = button;
		this.gameScreen = gameScreen;
		this.time = time;
		batch = beatGame.batch;
		numberWhichIsAnswered[0] = 0;
	}
	
	@Override
	public void render(float delta){
		gage = gameScreen.getGage();
		updateScoreAndPointGage();
		resetPointGage();
		usingGage();
	}
	
	public void resetPointGage(){
		if(time.getTime() == gage.getTimeBeginGage()+500){
			pointGage = 0;
		}
	}
	
	public void usingGage(){
		useGage = gage.getUsingGage();
	}
	
	public void updateScoreAndPointGage(){
		if((easyMode.getNumberWhichIsRandomed() == button.pressButton()  || hardMode.getNumberWhichIsRandomed() == button.pressButton())&& button.pressButton() != numberWhichIsAnswered[0]){
			if(useGage == false){
				score += 1;
			} else if (useGage == true){
				score += 2;
			}
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
