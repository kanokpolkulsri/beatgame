package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter{
	private BeatGame beatGame;
	//private Texture backGround;
	SpriteBatch batch;
	
	Button button;
	EasyMode easyMode;
	HardMode hardMode;
	Time time;
	DazzButton dazzButton;
	PointScore pointScore;
	Gage gage;
	Music music;
	ContextOnPage contextOnPage;
	FirstPage firstPage;
	GamePage gamePage;
	
    public GameScreen(BeatGame beatGame){
        this.beatGame = beatGame;
        batch = beatGame.batch;
        //backGround = new Texture("backGround.png");
        button = new Button(beatGame);
//        firstPage = new FirstPage(beatGame, button);
//        music = new Music(beatGame, button, firstPage);
        
        time = new Time(beatGame, music);
        dazzButton = new DazzButton(beatGame);
        easyMode = new EasyMode(beatGame, time, dazzButton);
        hardMode = new HardMode(beatGame, time, dazzButton);
        pointScore = new PointScore(beatGame, easyMode, hardMode, button, this, time);
        gage = new Gage(beatGame, pointScore, time);
        contextOnPage = new ContextOnPage(beatGame, pointScore, time);
        firstPage = new FirstPage(beatGame, button);
        music = new Music(beatGame, button, firstPage);
        gamePage = new GamePage(beatGame, this, music, firstPage);
        
    }
    
    @Override
    public void render(float delta){

    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(music.getDevilStatus() == false && music.getDonotloveyouStatus() == false && music.getSoyouStatus() == false){
        	firstPage.render();
        }
        music.update();
        if(music.getDevilStatus() == true || music.getDonotloveyouStatus() == true || music.getSoyouStatus() == true){
        	gamePage.render(delta);
        }
        batch.end();
        
    }
    
    
    public Button getButton(){
    	return button;
    }

    public ContextOnPage getContextOnPage(){
    	return contextOnPage;
    }
    
    public PointScore getPointScore(){
    	return pointScore;
    }
    
    public HardMode getHardMode(){
    	return hardMode;
    }
    
    public EasyMode getEastMode(){
    	return easyMode;
    }
    
    public DazzButton getDazzButton(){
    	return dazzButton;
    }
    
    public Time getTime(){
    	return time;
    }
    public Gage getGage() {
    	return gage;
    }
    
}
