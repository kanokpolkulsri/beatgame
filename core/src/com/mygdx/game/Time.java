package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Time {
	public int time = 0;
	public int timeEasyModeMaxInRound=0;
	public int timeHardModeMaxInRound=0;
	public int minuteSong = 2;
	public int secondSong = 5;
	private BeatGame beatGame;
	SpriteBatch batch;
	
	public Time(BeatGame beatGame){
		this.beatGame = beatGame;
		batch = beatGame.batch;
	}
	

	public void update(float delta){
		time++;
		updateTimeWhenMaxRound();
		updateTimeSong();
	}
	
	public void updateTimeSong(){
		if(time%100 == 0){
			if(minuteSong != 0 && secondSong != 0){
				secondSong--;
				if(secondSong == 0 && minuteSong > 0){
					minuteSong--;
					secondSong = 59;
				}
			}
		}
	}
	
	public int getSecondSong(){
		return secondSong;
	}
	
	public int getMinuteSong(){
		return minuteSong;
	}
	
	public void updateTimeWhenMaxRound(){
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
