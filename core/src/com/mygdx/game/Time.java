package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Time {
	public int time = 0;
	public int timeEasyModeMaxInRound=0;
	public int timeHardModeMaxInRound=0;
	private BeatGame beatGame;
	SpriteBatch batch;
	
	public Time(BeatGame beatGame){
		this.beatGame = beatGame;
		batch = beatGame.batch;
	}
	

	public void update(float delta){
		time++;
		if(time == timeEasyModeMaxInRound+70){
			timeEasyModeMaxInRound+=70;
		}
		if(time == timeHardModeMaxInRound+40){
			timeHardModeMaxInRound+=40;
		}
	}
	
	public int getTime(){
		return time;
	}
	
	public int getTimeEasyModeMaxInRound(){
		return timeEasyModeMaxInRound;
	}
	
	public int getTimeHardModeMaxInRound(){
		return timeHardModeMaxInRound;
	}
}
