package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;

public class Music extends ScreenAdapter{
	
	private Button button;
	private FirstPage firstPage;
	private Time time;
	private GameScreen gameScreen;
	private com.badlogic.gdx.audio.Music soyouSong;
	private com.badlogic.gdx.audio.Music donotloveyouSong;
	private com.badlogic.gdx.audio.Music devilSong;
	private com.badlogic.gdx.audio.Music fatratSong;
	public boolean soyouMode = false, donotloveyouMode = false, devilMode = false;
	private static int numberSoyouSong = 1, numberDonotloveyouSong = 2, numberDevilSong = 3, pressEnter = 13;
	public boolean finishGameShowScore = false;
	
	public Music(BeatGame beatGame, Button button, FirstPage firstPage, GameScreen gameScreen) {
		this.button = button;
		this.firstPage = firstPage;
		this.gameScreen = gameScreen;
		soyouSong = Gdx.audio.newMusic(Gdx.files.internal("soyou.mp3"));
		donotloveyouSong = Gdx.audio.newMusic(Gdx.files.internal("donotloveyou.mp3"));
		devilSong = Gdx.audio.newMusic(Gdx.files.internal("devil.mp3"));
		fatratSong = Gdx.audio.newMusic(Gdx.files.internal("fatratSong.mp3"));
		soyouSong.setLooping(true);
		donotloveyouSong.setLooping(true);
		devilSong.setLooping(true);
		fatratSong.setLooping(true);
	}
	
	public void initTime() {
		time = gameScreen.getTime();
	}

	public void update() {
		fatratSong();
		soyouPlay();
		donotloveyouPlay();
		devilPlay();
	}
	
	public void fatratSong() {
		if (soyouMode == false && devilMode == false && donotloveyouMode == false) {
			fatratSong.play();
		} else if (soyouMode == true || devilMode == true || donotloveyouMode == true) {
			fatratSong.stop();
		}
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
		if (firstPage.getNumberSong() == numberDevilSong && devilMode == false) {
			if (button.pressDirectionButton() == pressEnter){
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
		if (firstPage.getNumberSong() == numberDonotloveyouSong && donotloveyouMode == false) {
			if (button.pressDirectionButton() == pressEnter) {
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
		if (firstPage.getNumberSong() == numberSoyouSong && soyouMode == false) {
			if (button.pressDirectionButton() == pressEnter) {
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
