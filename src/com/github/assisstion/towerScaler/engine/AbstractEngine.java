package com.github.assisstion.towerScaler.engine;

import java.util.Map;
import java.util.Set;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

import com.github.assisstion.towerScaler.TSToolkit.TSMenu;

//This abstract class relies on the parent instance to do all the work
public abstract class AbstractEngine implements Engine, KeyListener{

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException{
		render(gc, g, 0);
	}

	@Override
	public void setEngineProperties(Map<String, String> properties){
		getParent().setEngineProperties(properties);
	}

	@Override
	public void setEngineProperty(String key, String value){
		getParent().setEngineProperty(key, value);
	}

	@Override
	public Map<String, String> getEngineProperties(){
		return getParent().getEngineProperties();
	}

	@Override
	public String getEngineProperty(String key){
		return getParent().getEngineProperty(key);
	}

	@Override
	public void addMenu(TSMenu menu){
		getParent().addMenu(menu);
	}

	@Override
	public void removeMenu(TSMenu menu){
		getParent().removeMenu(menu);
	}

	@Override
	public Set<TSMenu> getMenus(){
		return getParent().getMenus();
	}

	@Override
	public void setMenus(Set<TSMenu> menus){
		getParent().setMenus(menus);
	}

	@Override
	public void inputEnded(){

	}

	@Override
	public void inputStarted(){

	}

	@Override
	public boolean isAcceptingInput(){
		return false;
	}

	@Override
	public void setInput(Input input){

	}

	@Override
	public void keyPressed(int key, char c){

	}

	@Override
	public void keyReleased(int key, char c){

	}

	@Override
	public boolean isActive(){
		return getParent().isActive();
	}

	@Override
	public boolean toBeRendered(){
		return isActive();
	}

	@Override
	public boolean isInitialized(){
		return true;
	}
}
