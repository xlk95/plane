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
	// ����һ���ڲ������ػ�����,�ڲ������ʹ���ⲿ�ڵ����ԣ�����һ�����߳�
	
	class PaintThread extends Thread {
		@Override
		public void run() {
			while(true) {
				//System.out.println("�����ػ�һ�Σ�");
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
	 * ��Ӽ��̼����ڲ���
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
		this.setTitle("�ɻ���ս");
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
