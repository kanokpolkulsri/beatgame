package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ContextOnPage extends ScreenAdapter{
	SpriteBatch batch;
	BeatGame beatGame;
	BitmapFont font;
	PointScore pointScore;
	Time time;
	
	public ContextOnPage(BeatGame beatGame, PointScore pointScore, Time time){
		this.beatGame = beatGame;
		this.pointScore = pointScore;
		this.time = time;
		batch = beatGame.batch;
		font = new BitmapFont();
	}
	
	@Override
	public void render(float delta){
		font.draw(batch, "" + pointScore.getPointScore(), 65, 495);
		font.draw(batch, "Some", 180, 545);
		if(time.getSecondSong() < 10){
			font.draw(batch, time.getMinuteSong() + " : 0" + time.getSecondSong(), 310, 495);
		} else {
			font.draw(batch, time.getMinuteSong() + " : " + time.getSecondSong(), 310, 495);
		}
	}
}
