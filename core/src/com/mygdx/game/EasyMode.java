package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EasyMode extends ScreenAdapter {
	SpriteBatch batch;
	BeatGame beatGame;
	DazzButton dazzButton;
	Time time;
	private Random randomGenerator;
	private int timeEasyMode = 0, timeEasyModeMaxInRound = 0;
	private int x = 0, y = 0, numberWhichIsRandomed = 1, maxPeriod = 70, beatEasyMode = 7, oneRoundDazz = 10;
	private int numberWhichIsRandomedBefore [] = new int [1];
	
	public EasyMode(BeatGame beatGame, Time time, DazzButton dazzButton) {
		batch = beatGame.batch;
		this.beatGame = beatGame;
		this.time = time;
		this.dazzButton = dazzButton;
		randomGenerator = new Random();
		timeEasyMode = time.getTime();
		timeEasyModeMaxInRound = time.getTimeHardModeMaxInRound();
		numberWhichIsRandomedBefore[0] = 1;
	}
	
	@Override
	public void render(float delta) {
		timeEasyMode = getTimeHere();
		timeEasyModeMaxInRound = getTimeEasyModeMaxInRoundHere();
		x = dazzButton.positionXFromRandomNumber(numberWhichIsRandomed);
		y = dazzButton.positionYFromRandomNumber(numberWhichIsRandomed);
		dazzButton.screenShowColor(x, y, timeEasyMode, timeEasyModeMaxInRound, beatEasyMode);
		if (timeEasyMode == maxPeriod) {
			numberWhichIsRandomed = randomNumber();
			numberWhichIsRandomedBefore[0] = numberWhichIsRandomed;
			maxPeriod += beatEasyMode * oneRoundDazz;
		}
    }
	
	public int randomNumber() {
		int a = randomGenerator.nextInt(8) + 1;
		if (a != numberWhichIsRandomedBefore[0]) {
			numberWhichIsRandomedBefore[0] = a;
			return a;
		} else { 
			return randomNumber();
		}
	}
	
	public int getTimeHere() {
		return time.getTime();
	}
	
	public int getTimeEasyModeMaxInRoundHere() {
		return time.getTimeEasyModeMaxInRound();
	}
	
	public int getNumberWhichIsRandomed() {
		return numberWhichIsRandomed;
	}
	
}
