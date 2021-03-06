package com.github.assisstion.towerScaler.engine;

import java.awt.Font;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;

import com.github.assisstion.TSToolkit.TSFocusTextButton;
import com.github.assisstion.towerScaler.Helper;
import com.github.assisstion.towerScaler.Main;
import com.github.assisstion.towerScaler.menu.HighScoreMenu;
import com.github.assisstion.towerScaler.menu.OptionsMenu;
import com.github.assisstion.towerScaler.menu.StatsMenu;
import com.github.assisstion.towerScaler.multiplayer.MultiplayerMenu;

public class MenuEngine extends AbstractEngine{

	protected MainEngine engine;
	protected TSFocusTextButton startButton;
	protected TSFocusTextButton highScoreButton;
	protected TSFocusTextButton arcadeModeButton;
	protected TrueTypeFont titleFont;
	protected TrueTypeFont subtitleFont;
	protected TSFocusTextButton optionsButton;
	protected TSFocusTextButton statsButton;
	private TSFocusTextButton multiplayerButton;

	public MenuEngine(MainEngine e){
		engine = e;
	}

	protected MenuEngine(){

	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException{
		render(gc, g, 0);
	}

	@Override
	public void render(GameContainer gc, Graphics g, int layer)
			throws SlickException{
		switch(layer){
			case 0:
				render0(gc, g);
				break;
			case 1:
				render1(gc, g);
				break;
		}
	}

	protected void render0(GameContainer gc, Graphics g) throws SlickException{
		g.setBackground(new Color(75, 255, 75));
		g.setFont(titleFont);
		g.setColor(Color.black);
		String title = "Tower Scaler";
		g.drawString(title,
				(Main.getGameFrameWidth() - titleFont.getWidth(title)) / 2,
				100);
		g.setFont(subtitleFont);
		String author = "by assisstion";
		g.drawString(
				author,
				(Main.getGameFrameWidth() - subtitleFont.getWidth(author)) / 2,
				150);
		startButton.render(gc, g);
		highScoreButton.render(gc, g);
		optionsButton.render(gc, g);
		arcadeModeButton.render(gc, g);
		statsButton.render(gc, g);
		multiplayerButton.render(gc, g);
	}

	protected void render1(GameContainer gc, Graphics g){
		/*
		 * UNUSED Do nothing (yet)
		 */
	}

	@Override
	public void init(GameContainer gc){
		titleFont = new TrueTypeFont(new Font("Calibri", Font.PLAIN, 40), true);
		subtitleFont = new TrueTypeFont(new Font("Arial", Font.PLAIN, 20), true);
		startButton = new TSFocusTextButton(gc, this,
				Main.getGameFrameWidth() / 2, 240, " Special Mode ",
				Helper.getDefaultFont(), Color.black, new Color(150, 150, 255),
				Color.black);
		startButton.addListener(new ComponentListener(){
			@Override
			public void componentActivated(AbstractComponent source){
				getParent().ge.setArcadeMode(false);
				getParent().startGame();
			}
		});
		highScoreButton = new TSFocusTextButton(gc, this,
				Main.getGameFrameWidth() / 2, 280, " Highscores ",
				Helper.getDefaultFont(), Color.black, new Color(255, 150, 150),
				Color.black);
		highScoreButton.addListener(new ComponentListener(){
			@Override
			public void componentActivated(AbstractComponent source){
				HighScoreMenu hsm = getParent().getHighScoreMenu();
				hsm.setVisible(true);
				addMenu(hsm);
			}
		});
		optionsButton = new TSFocusTextButton(gc, this,
				Main.getGameFrameWidth() / 2, 320, " Options ",
				Helper.getDefaultFont(), Color.black, new Color(150, 255, 255),
				Color.black);
		optionsButton.addListener(new ComponentListener(){
			@Override
			public void componentActivated(AbstractComponent source){
				OptionsMenu hsm = getParent().getOptionsMenu();
				hsm.setVisible(true);
				addMenu(hsm);
			}
		});
		statsButton = new TSFocusTextButton(gc, this,
				Main.getGameFrameWidth() / 2, 360, " Stats ",
				Helper.getDefaultFont(), Color.black, new Color(150, 150, 150),
				Color.black);
		statsButton.addListener(new ComponentListener(){
			@Override
			public void componentActivated(AbstractComponent source){
				StatsMenu stm = getParent().getStatsMenu();
				stm.setVisible(true);
				addMenu(stm);
			}
		});
		arcadeModeButton = new TSFocusTextButton(gc, this,
				Main.getGameFrameWidth() / 2, 200, " Arcade Mode ",
				Helper.getDefaultFont(), Color.black, new Color(255, 255, 150),
				Color.black);
		arcadeModeButton.addListener(new ComponentListener(){
			@Override
			public void componentActivated(AbstractComponent source){
				getParent().ge.setArcadeMode(true);
				getParent().startGame();
			}
		});
		multiplayerButton = new TSFocusTextButton(gc, this,
				Main.getGameFrameWidth() / 2, 400, " Multiplayer ",
				Helper.getDefaultFont(), Color.black, new Color(255, 255, 255),
				Color.black);
		multiplayerButton.addListener(new ComponentListener(){
			@Override
			public void componentActivated(AbstractComponent source){
				MultiplayerMenu mpm = getParent().getMultiplayerMenu();
				mpm.reset();
				mpm.setVisible(true);
				addMenu(mpm);
			}
		});
	}

	@Override
	public void update(GameContainer gc, int delta){
		// Do nothing
	}

	@Override
	public MainEngine getParent(){
		return engine;
	}

	@Override
	public Set<Integer> renderableLayers(){
		Set<Integer> layers = new HashSet<Integer>();
		Collections.addAll(layers, 0, 1);
		return layers;
	}

	@Override
	public boolean hasInputFocus(){
		return getParent().hasInputFocus();
	}

	@Override
	public void setInputFocus(boolean focus){
		// Do nothing
	}

	@Override
	public boolean isActive(){
		return getParent().getActiveEngines().contains(this);
	}
}
