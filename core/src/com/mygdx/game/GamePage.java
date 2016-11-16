package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamePage extends ScreenAdapter {
	
	private SpriteBatch batch;
	private ContextOnPage contextOnPage;
	private Time time;
	private Button button;
	private EasyMode easyMode;
	private HardMode hardMode;
	private Gage gage;
	private PointScore pointScore;
	private Music music;
	private Texture backGround;
	
	public GamePage(BeatGame beatGame, GameScreen gameScreen, Music music, FirstPage firstPage) {
		batch = beatGame.batch;
		this.music = music;
		contextOnPage = gameScreen.getContextOnPage();
		time = gameScreen.getTime();
		button = gameScreen.getButton();
		easyMode = gameScreen.getEastMode();
		hardMode = gameScreen.getHardMode();
		gage = gameScreen.getGage();
		pointScore = gameScreen.getPointScore();
		backGround = new Texture("backGround.png");
		
	}
	
	@Override
	public void render(float delta) {
		supportUpdate(delta);
		if (music.getSoyouStatus() == true) {
			soyouStart(delta);
		}
		if (music.getDonotloveyouStatus() == true) {
			donotloveyouStart(delta);
		}
		if (music.getDevilStatus() == true) {
			devilStart(delta);
		}
	}
	
	public void backGround() {
    	batch.draw(backGround, 0, 0);
    }
	
	public void supportUpdate(float delta){
		backGround();
		contextOnPage.render(delta);
		time.update(delta);
		button.render(delta);
		gage.update();
		pointScore.render(delta);
	}
	
	public void devilStart(float delta) {
		easyMode.render(delta);
		hardMode.render(delta);
	}
	
	public void donotloveyouStart(float delta) {
		hardMode.render(delta);
	}
	
	public void soyouStart(float delta) {
		easyMode.render(delta);
	}

}
