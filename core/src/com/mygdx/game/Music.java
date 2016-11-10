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
	com.badlogic.gdx.audio.Music soyouSong;
	com.badlogic.gdx.audio.Music donotloveyouSong;
	com.badlogic.gdx.audio.Music devilSong;
	private boolean soyouMode = false;
	private boolean donotloveyouMode = false;
	private boolean devilMode = false;
	
	public Music(BeatGame beatGame, Button button, FirstPage firstPage){
		this.beatGame = beatGame;
		this.button = button;
		this.firstPage = firstPage;
		batch = beatGame.batch;
		soyouSong = Gdx.audio.newMusic(Gdx.files.internal("soyou.mp3"));
		soyouSong.setLooping(true);
		donotloveyouSong = Gdx.audio.newMusic(Gdx.files.internal("donotloveyou.mp3"));
		donotloveyouSong.setLooping(true);
		devilSong = Gdx.audio.newMusic(Gdx.files.internal("devil.mp3"));
		devilSong.setLooping(true);
	}

	public void update(){
		soyouPlay();
		donotloveyouPlay();
		devilPlay();
	}
	
	public boolean getSoyouStatus(){
		return soyouMode;
	}
	
	public boolean getDonotloveyouStatus(){
		return donotloveyouMode;
	}
	
	public boolean getDevilStatus(){
		return devilMode;
	}
	
	public void devilPlay(){
		if(firstPage.getNumberSong() == 3 && devilMode == false){
			if(button.pressDirectionButton() == 13){
				devilMode = true;
			}
		}
		if(devilMode == true){
			devilSong.play();
		}
	}
	
	public void donotloveyouPlay(){
		if(firstPage.getNumberSong() == 2 && donotloveyouMode == false){
			if(button.pressDirectionButton() == 13){
				donotloveyouMode = true;
			}
		}
		if(donotloveyouMode == true){
			donotloveyouSong.play();
		}
	}
	
	public void soyouPlay(){
		if(firstPage.getNumberSong() == 1 && soyouMode == false){
			if(button.pressDirectionButton() == 13){
				soyouMode = true;
			}
		}
		if(soyouMode == true){
			soyouSong.play();
		}
	}

}
