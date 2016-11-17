package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class PointScore extends ScreenAdapter {
	
	private EasyMode easyMode;
	private HardMode hardMode;
	private Button button;
	private Gage gage;
	private Time time;
	private GameScreen gameScreen;
	private boolean useGage = false;
	private int numberWhichIsAnswered [] = new int [1];
	public int score = 0, pointGage = 0, maxPointGage = 27, undoingGage = 1, doingGage = 2;
	
	public PointScore(BeatGame beatGame, EasyMode easyMode, HardMode hardMode, Button button, GameScreen gameScreen, Time time) {
		this.easyMode = easyMode;
		this.hardMode = hardMode;
		this.button = button;
		this.gameScreen = gameScreen;
		this.time = time;
		numberWhichIsAnswered[0] = 0;
	}
	
	@Override
	public void render(float delta) {
		gage = gameScreen.getGage();
		updateScoreAndPointGage();
		resetPointGage();
		usingGage();
	}
	
	public void resetPointGage() {
		if (time.getTime() == gage.getTimeBeginGage() + 500) {
			pointGage = 0;
		}
	}
	
	public void usingGage() {
		useGage = gage.getUsingGage();
	}
	
	public void updateScoreAndPointGage() {
		if ((easyMode.getNumberWhichIsRandomed() == button.pressButton()  || hardMode.getNumberWhichIsRandomed() == button.pressButton())&& button.pressButton() != numberWhichIsAnswered[0]) {
			if (useGage == false) {
				score += 1;
			} else if (useGage == true) {
				score += 2;
			}
			if (pointGage < maxPointGage){
				pointGage += 1;
			} else if (pointGage == maxPointGage) {
				pointGage = maxPointGage;
			}
			System.out.println(score);
			numberWhichIsAnswered[0] = button.pressButton();
		} else if (easyMode.getNumberWhichIsRandomed() != button.pressButton() && hardMode.getNumberWhichIsRandomed() != button.pressButton() && button.pressButton() != 0 && score > 0) {
			score -= 1;
			pointGage = 0;
			System.out.println(score);
		}
	}
	
	public int getPointScore() {
		return score;
	}
	
	public int getPointGage() {
		return pointGage;
	}
	
	
}
