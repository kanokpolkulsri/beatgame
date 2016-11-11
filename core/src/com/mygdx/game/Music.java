package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Music extends ScreenAdapter{
	
	SpriteBatch batch;
	BeatGame beatGame;
	Button button;
	FirstPage firstPage;
	Time time;
	GameScreen gameScreen;
	com.badlogic.gdx.audio.Music soyouSong;
	com.badlogic.gdx.audio.Music donotloveyouSong;
	com.badlogic.gdx.audio.Music devilSong;
	private boolean soyouMode = false, donotloveyouMode = false, devilMode = false;
	public boolean finishGameShowScore = false;
	
	public Music(BeatGame beatGame, Button button, FirstPage firstPage, GameScreen gameScreen) {
		batch = beatGame.batch;
		this.beatGame = beatGame;
		this.button = button;
		this.firstPage = firstPage;
		this.gameScreen = gameScreen;
		soyouSong = Gdx.audio.newMusic(Gdx.files.internal("soyou.mp3"));
		donotloveyouSong = Gdx.audio.newMusic(Gdx.files.internal("donotloveyou.mp3"));
		devilSong = Gdx.audio.newMusic(Gdx.files.internal("devil.mp3"));
		soyouSong.setLooping(true);
		donotloveyouSong.setLooping(true);
		devilSong.setLooping(true);
	}
	
	public void initTime() {
		time = gameScreen.getTime();
	}

	public void update() {
		soyouPlay();
		donotloveyouPlay();
		devilPlay();
	}
	
	public boolean getFinishGameShowScore() {
		return finishGameShowScore;
	}
	
	public boolean getSoyouStatus() {
		return soyouMode;
	}
	
	public boolean getDonotloveyouStatus() {
		return donotloveyouMode;
	}
	
	public boolean getDevilStatus() {
		return devilMode;
	}
	
	public void devilPlay() {
		if (firstPage.getNumberSong() == 3 && devilMode == false) {
			if (button.pressDirectionButton() == 13){
				devilMode = true;
			}
		}
		if (devilMode == true) {
			devilSong.play();
		}
		if (time.getSecondSong() == 0 && time.getMinuteSong() == 0) {
			devilMode = false;
			devilSong.stop();
			finishGameShowScore = true;
		}
	}
	
	public void donotloveyouPlay() {
		if (firstPage.getNumberSong() == 2 && donotloveyouMode == false) {
			if (button.pressDirectionButton() == 13) {
				donotloveyouMode = true;
			}
		}
		if (donotloveyouMode == true) {
			donotloveyouSong.play();
		}
		if (time.getSecondSong() == 0 && time.getMinuteSong() == 0) {
			donotloveyouMode = false;
			donotloveyouSong.stop();
			finishGameShowScore = true;
		}
	}
	
	public void soyouPlay() {
		if (firstPage.getNumberSong() == 1 && soyouMode == false) {
			if (button.pressDirectionButton() == 13) {
				soyouMode = true;
			}
		}
		if (soyouMode == true) {
			soyouSong.play();
		}
		if (time.getSecondSong() == 0 && time.getMinuteSong() == 0) {
			soyouMode = false;
			soyouSong.stop();
			finishGameShowScore = true;
		}
	}

}
