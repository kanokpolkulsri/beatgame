package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Time {
	BeatGame beatGame;
	SpriteBatch batch;
	Music music;
	private boolean timeStartIsUsed = false;
	public int time = 0, timeEasyModeMaxInRound = 0, timeHardModeMaxInRound = 0, minuteSong = 0, secondSong = 5;
	
	public Time(BeatGame beatGame, Music music) {
		batch = beatGame.batch;
		this.beatGame = beatGame;
		this.music = music;
	}
	

	public void update(float delta) {
		prepareTimeStart();
		time += 1;
		updateTimeWhenMaxRound();
		updateTimeSong();
	}
	
	public void prepareTimeStart() {
		if (timeStartIsUsed == false) {
			if (music.getSoyouStatus() == true) {
				minuteSong = 2;
				secondSong = 7;
				timeStartIsUsed = true;
			} else if (music.getDonotloveyouStatus() == true) {
				minuteSong = 2;
				secondSong = 32;
				timeStartIsUsed = true;
			} else if (music.getDevilStatus() == true) {
				minuteSong = 2;
				secondSong = 5;
				timeStartIsUsed = true;
			}
		}
	}
	
	public void updateTimeSong() {
		if (time % 100 == 0) {
			if (minuteSong != 0 || secondSong != 0) {
				secondSong -= 1;
				if (secondSong == 0 && minuteSong > 0) {
					minuteSong -= 1;
					secondSong = 59;
				}
			}
		}
	}
	
	public int getSecondSong() {
		return secondSong;
	}
	
	public int getMinuteSong() {
		return minuteSong;
	}
	
	public void updateTimeWhenMaxRound() {
		if(time == timeEasyModeMaxInRound + 70) {
			timeEasyModeMaxInRound += 70;
		}
		if(time == timeHardModeMaxInRound + 40) {
			timeHardModeMaxInRound += 40;
		}
	}
	
	public int getTime() {
		return time;
	}
	
	public int getTimeEasyModeMaxInRound() {
		return timeEasyModeMaxInRound;
	}
	
	public int getTimeHardModeMaxInRound() {
		return timeHardModeMaxInRound;
	}
}
