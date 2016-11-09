package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Music extends ScreenAdapter{
	SpriteBatch batch;
	BeatGame beatGame;
	Button button;
	com.badlogic.gdx.audio.Music soyouSong;
	
	public Music(BeatGame beatGame, Button button){
		this.beatGame = beatGame;
		this.button = button;
		batch = beatGame.batch;
		soyouSong = Gdx.audio.newMusic(Gdx.files.internal("soyou.mp3"));
		soyouSong.setLooping(true);
	}

	public void update(){
		soyouSong.play();
	}

}
