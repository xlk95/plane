package com.qf.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyGameFrame extends JFrame {
	
	Image planeImg = GameUtil.getImage("Images/plane.png");
	Image bg = GameUtil.getImage("Images/bg.jpg");

	Plane plane = new Plane(250.0d,250.0d,planeImg);
	Shell shell = new Shell();
	// 定义一个内部类来重画窗口,内部类可以使用外部内的属性，他是一个个线程
	
	class PaintThread extends Thread {
		@Override
		public void run() {
			while(true) {
				//System.out.println("窗口重画一次！");
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * 添加键盘监听内部类
	 */
	class KeyMonitor extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}
		@Override
		public void keyReleased(KeyEvent e) {
			plane.MinusDirection(e);
		}
	}
	
	public void lauchFrame() {
		this.setTitle("飞机大战");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		this.setLocation(300, 300);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		new PaintThread().start();
		addKeyListener(new KeyMonitor());
	}
	
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		g.drawImage(bg, 0, 0, null);
//		g.drawImage(plane, planeX, planeY, null);
//		planeX++;
		plane.drawSelf(g);
		shell.draw(g);
		
	}
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.lauchFrame();
	}
}
