package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ScreenAdapter;

public class HardMode extends ScreenAdapter {

	private DazzButton dazzButton;
	private Time time;
	private Random randomGenerator;
	private int timeHardMode = 0, timeHardModeMaxInRound = 0;
	private int x = 0, y = 0, numberWhichIsRandomed = 1, maxPeriod = 40, beatHardMode = 4, oneRoundDazz = 10;
	private int numberWhichIsRandomedBefore [] = new int [1];
	
	public HardMode(BeatGame beatGame, Time time, DazzButton dazzButton) {
		this.time = time;
		this.dazzButton = dazzButton;
		randomGenerator = new Random();
		timeHardMode = time.getTime();
		timeHardModeMaxInRound = time.getTimeEasyModeMaxInRound();
		numberWhichIsRandomedBefore[0] = 1;
	}
	
	@Override
	public void render(float delta) {
		timeHardMode = getTimeHere();
		timeHardModeMaxInRound = getTimeHardModeMaxInRoundHere();
		x = dazzButton.positionXFromRandomNumber(numberWhichIsRandomed);
		y = dazzButton.positionYFromRandomNumber(numberWhichIsRandomed);
		dazzButton.screenShowColor(x, y, timeHardMode, timeHardModeMaxInRound, beatHardMode);
		if (timeHardMode == maxPeriod) {
			numberWhichIsRandomed = randomNumber();
			numberWhichIsRandomedBefore[0] = numberWhichIsRandomed;
			maxPeriod += beatHardMode*oneRoundDazz;
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
	
	public int getTimeHardModeMaxInRoundHere() {
		return time.getTimeHardModeMaxInRound();
	}
	
	public int getNumberWhichIsRandomed() {
		return numberWhichIsRandomed;
	}
	
	
}
