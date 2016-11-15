package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamePage extends ScreenAdapter {
	
	private SpriteBatch batch;
	private BeatGame beatGame;
	private GameScreen gameScreen;
	private ContextOnPage contextOnPage;
	private Time time;
	private Button button;
	private EasyMode easyMode;
	private HardMode hardMode;
	private Gage gage;
	private PointScore pointScore;
	private Music music;
	private FirstPage firstPage;
	private Texture backGround;
	
	public GamePage(BeatGame beatGame, GameScreen gameScreen, Music music, FirstPage firstPage) {
		batch = beatGame.batch;
		this.beatGame = beatGame;
		this.gameScreen = gameScreen;
		this.music = music;
		this.firstPage = firstPage;
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
	
	public void devilStart(float delta) {
		backGround();
		contextOnPage.render(delta);
		time.update(delta);
		button.render(delta);
		easyMode.render(delta);
		hardMode.render(delta);
		gage.update();
		pointScore.render(delta);
	}
	
	public void donotloveyouStart(float delta) {
		backGround();
		contextOnPage.render(delta);
		time.update(delta);
		button.render(delta);
		hardMode.render(delta);
		gage.update();
		pointScore.render(delta);
	}
	
	public void soyouStart(float delta) {
		backGround();
		contextOnPage.render(delta);
		time.update(delta);
		button.render(delta);
		easyMode.render(delta);
		gage.update();
		pointScore.render(delta);
	}

}
