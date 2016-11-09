package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Music extends ScreenAdapter{
	SpriteBatch batch;
	BeatGame beatGame;
	Button button;
	com.badlogic.gdx.audio.Music music;
	
	public Music(BeatGame beatGame, Button button){
		this.beatGame = beatGame;
		this.button = button;
		batch = beatGame.batch;
		music = Gdx.audio.newMusic(Gdx.files.internal("soyou.mp3"));
		music.setLooping(true);
	}

	public void update(){
		music.play();
	}

}
