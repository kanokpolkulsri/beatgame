package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HardMode extends ScreenAdapter{
	SpriteBatch batch;
	BeatGame beatGame;
	DazzButton dazzButton;
	Time time;
	private Random randomGenerator;
	private int timeHardMode=0;
	private int timeHardModeMaxInRound=0;
	private int x=0, y=0, numberWhichIsRandomed=1, maxPeriod=40, beatHardMode=4, oneRoundDazz=10;
	
	public HardMode(BeatGame beatGame, Time time, DazzButton dazzButton){
		this.beatGame = beatGame;
		this.time = time;
		this.dazzButton = dazzButton;
		batch = beatGame.batch;
		randomGenerator = new Random();
		timeHardMode = time.getTime();
		timeHardModeMaxInRound = time.getTimeEasyModeMaxInRound();
	}
	
	@Override
	public void render(float delta){
		timeHardMode = getTimeHere();
		timeHardModeMaxInRound = getTimeHardModeMaxInRoundHere();
		x = dazzButton.positionXFromRandomNumber(numberWhichIsRandomed);
		y = dazzButton.positionYFromRandomNumber(numberWhichIsRandomed);
		dazzButton.screenShowColor(x, y, timeHardMode, timeHardModeMaxInRound, beatHardMode);
		if(timeHardMode == maxPeriod){
			numberWhichIsRandomed = randomNumber();
			maxPeriod += beatHardMode*oneRoundDazz;
		}
    }
	
	public int randomNumber(){
		return randomGenerator.nextInt(8)+1;
	}
	
	public int getTimeHere(){
		return time.getTime();
	}
	
	public int getTimeHardModeMaxInRoundHere(){
		return time.getTimeHardModeMaxInRound();
	}
	
	
}
