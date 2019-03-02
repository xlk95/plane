package com.qf.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	  double x,y;
	  Image img;
	  int speed;
	  int height, width;
	
	public GameObject() {
		// TODO Auto-generated constructor stub
	}
	public GameObject(double x, double y, Image img) {
		super();
		this.x = x;
		this.y = y;
		this.img = img;
	}
	public GameObject(double x, double y, Image img, int speed, int height, int width) {
		super();
		this.x = x;
		this.y = y;
		this.img = img;
		this.speed = speed;
		this.height = height;
		this.width = width;
	}
	
	public void drawSelf(Graphics g) {
		g.drawImage(this.img, (int)this.x, (int)this.y, null);

	}
	
	public Rectangle getRect() {
		return new Rectangle((int)this.x, (int)this.y, this.width, this.height);
	}

}
