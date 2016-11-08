package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EasyMode extends ScreenAdapter{
	SpriteBatch batch;
	BeatGame beatGame;
	DazzButton dazzButton;
	Time time;
	private Random randomGenerator;
	private int timeEasyMode=0;
	private int timeEasyModeMaxInRound=0;
	private int x=0, y=0, numberWhichIsRandomed=1, maxPeriod=70, beatEasyMode=7, oneRoundDazz=10;
	
	public EasyMode(BeatGame beatGame, Time time, DazzButton dazzButton){
		this.beatGame = beatGame;
		this.time = time;
		this.dazzButton = dazzButton;
		batch = beatGame.batch;
		randomGenerator = new Random();
		timeEasyMode = time.getTime();
		timeEasyModeMaxInRound = time.getTimeHardModeMaxInRound();
	}
	
	@Override
	public void render(float delta){
		timeEasyMode = getTimeHere();
		timeEasyModeMaxInRound = getTimeEasyModeMaxInRoundHere();
		x = dazzButton.positionXFromRandomNumber(numberWhichIsRandomed);
		y = dazzButton.positionYFromRandomNumber(numberWhichIsRandomed);
		dazzButton.screenShowColor(x, y, timeEasyMode, timeEasyModeMaxInRound, beatEasyMode);
		if(timeEasyMode == maxPeriod){
			numberWhichIsRandomed = randomNumber();
			maxPeriod += beatEasyMode*oneRoundDazz;
		}
    }
	
	public int randomNumber(){
		return randomGenerator.nextInt(8)+1;
	}
	
	public int getTimeHere(){
		return time.getTime();
	}
	
	public int getTimeEasyModeMaxInRoundHere(){
		return time.getTimeEasyModeMaxInRound();
	}
	
	
}
