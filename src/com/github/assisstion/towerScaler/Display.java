package com.github.assisstion.towerScaler;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Display{
	void render(GameContainer gc, Graphics g) throws Exception;
	void init(GameContainer gc) throws Exception;
	void update(GameContainer gc, int delta) throws Exception;
}
