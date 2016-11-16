package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	private BeatGame beatGame;
	private SpriteBatch batch;
	private Button button;
	private EasyMode easyMode;
	private HardMode hardMode;
	private Time time;
	private DazzButton dazzButton;
	private PointScore pointScore;
	private Gage gage;
	private Music music;
	private ContextOnPage contextOnPage;
	private FirstPage firstPage;
	private GamePage gamePage;
	private BitmapFont font;
	private Texture showScore;
	
    public GameScreen(BeatGame beatGame) {
    	batch = beatGame.batch;
        this.beatGame = beatGame;
        button = new Button(beatGame);
        firstPage = new FirstPage(beatGame, button);
        music = new Music(beatGame, button, firstPage, this);
        time = new Time(beatGame, music);
        dazzButton = new DazzButton(beatGame);
        easyMode = new EasyMode(beatGame, time, dazzButton);
        hardMode = new HardMode(beatGame, time, dazzButton);
        pointScore = new PointScore(beatGame, easyMode, hardMode, button, this, time);
        gage = new Gage(beatGame, pointScore, time);
        contextOnPage = new ContextOnPage(beatGame, pointScore, time, music);
        gamePage = new GamePage(beatGame, this, music, firstPage);
		font = new BitmapFont();
		showScore = new Texture("showScore.png");
		initTime();
        
    }
    
    public void initTime() {
    	music.initTime();
    }
    
    @Override
    public void render(float delta) {
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        homePageAndScorePage();
        music.update();
        onGamePage(delta);
        batch.end();
        
    }
    
    public void onGamePage(float delta){
    	if (stillOnGamePage()) {
        	gamePage.render(delta);
        }
    }
    
    public void homePageAndScorePage(){
    	if (music.getFinishGameShowScore()) {
        	showScoreWhenFinishGame();
        } else if (stillOnFirstPage()) {
        	firstPage.render();
        	contextOnPage.renderWhenGameNotStartYet();
        }
    }
    
    public boolean stillOnGamePage(){
    	if (music.getDevilStatus() == true || music.getDonotloveyouStatus() == true || music.getSoyouStatus() == true) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public boolean stillOnFirstPage(){
    	if (music.getDevilStatus() == false && music.getDonotloveyouStatus() == false && music.getSoyouStatus() == false) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    public void showScoreWhenFinishGame() {
    	batch.draw(showScore, 0, 0);
		font.draw(batch, " " + pointScore.getPointScore(), 195, 335);
    }
    
    public Button getButton() {
    	return button;
    }

    public ContextOnPage getContextOnPage() {
    	return contextOnPage;
    }
    
    public PointScore getPointScore() {
    	return pointScore;
    }
    
    public HardMode getHardMode() {
    	return hardMode;
    }
    
    public EasyMode getEastMode() {
    	return easyMode;
    }
    
    public DazzButton getDazzButton() {
    	return dazzButton;
    }
    
    public Time getTime() {
    	return time;
    }
    
    public Gage getGage() {
    	return gage;
    }
    
    public Music getMusic() {
    	return music;
    }
    
}
