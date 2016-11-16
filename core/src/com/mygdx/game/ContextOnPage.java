package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ContextOnPage extends ScreenAdapter {
	
	private SpriteBatch batch;
	private BitmapFont font;
	private PointScore pointScore;
	private Time time;
	private Music music;
	
	public ContextOnPage(BeatGame beatGame, PointScore pointScore, Time time, Music music) {
		batch = beatGame.batch;
		this.pointScore = pointScore;
		this.time = time;
		this.music = music;
		font = new BitmapFont();
	}
	
	@Override
	public void render(float delta) {
		renderWhenGameStarted();
	}
	
	public void renderWhenGameStarted() {
		if (music.getFinishGameShowScore() == false) {
			font.draw(batch, "" + pointScore.getPointScore(), 65, 495);
			if (music.getSoyouStatus() == true) {
				font.draw(batch, "So you", 180, 545);
			} else if (music.getDonotloveyouStatus() == true) {
				font.draw(batch, "Do not love you", 150, 545);
			} else if (music.getDevilStatus() == true) {
				font.draw(batch, "Devil", 180, 545);
			}
			if (time.getSecondSong() < 10) {
				font.draw(batch, time.getMinuteSong() + " : 0" + time.getSecondSong(), 310, 495);
			} else {
				font.draw(batch, time.getMinuteSong() + " : " + time.getSecondSong(), 310, 495);
			}
		}
	}
	
	public void renderWhenGameNotStartYet() {
		font.draw(batch, "SO YOU", 172, 340);
		font.draw(batch, "DO NOT LOVE YOU", 132, 253);
		font.draw(batch, "DEVIL", 182, 166);
	}
}
