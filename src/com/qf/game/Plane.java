package com.qf.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {
	
	boolean up, down, left, right; 
	
	@Override
	public void drawSelf(Graphics g) {
		this.speed = 3;
		g.drawImage(this.img, (int)x, (int)y, null);
		if(up) {
			x -= speed;
		}
		if(down) {
			x += speed;

		}
		if(left) {
			y -= speed;
		}
		if(right) {
			y += speed;

		}
		return;
	}
	public Plane() {
	}
	public Plane(double x, double y, Image img) {
		super(x, y, img);
	}
/*
 * 添加方向	
 */
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			up = true;
			break;

		case KeyEvent.VK_DOWN:
			down = true;
			break;

		case KeyEvent.VK_LEFT:
			left = true;
			break;

		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		default:
			break;
		}
	}
/*
 * 取消方向
 */
	public void MinusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			up = false;
			break;

		case KeyEvent.VK_DOWN:
			down = false;
			break;

		case KeyEvent.VK_LEFT:
			left = false;
			break;

		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		default:
			break;
		}
	}
}
