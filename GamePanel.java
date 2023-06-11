package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	final int originalTileSize = 16; //16X16 tiles
	final int scale = 3;
	
	final int tileSize = originalTileSize*scale; //48X48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int ScreenWidth = tileSize*maxScreenCol;	//768 pixels
	final int ScreenHeight = tileSize*maxScreenRow;	//576 pixels
	
	//FPS
	
	int FPS = 60;
	
	
	KeyHandler KH = new KeyHandler();
	
	Thread gameThread;
	
	//Player Position 
	int playerX=100;
	int playerY=100;
	int playerSpeed=5;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(KH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	/*@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime()+drawInterval;
		while(gameThread!=null) {
			
			long currentTime=System.nanoTime();
			System.out.println("Current time :"+currentTime);
			
			update();
			
			repaint();
			
			
			try {
				double remainingTime = nextDrawTime-System.nanoTime();
				remainingTime=remainingTime/1000000;
				
				if(remainingTime<0) {
					remainingTime=0;
				}
				
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
				
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	}*/
	
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		
		
		
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			delta +=(currentTime - lastTime)/drawInterval;
			lastTime=currentTime;
			
			if(delta>=1) {
				update();
				repaint();
				delta--;
			}
		}
	}
		
		
	
	public void update(){
		if(KH.upPrssd==true) {
			playerY-=playerSpeed;
		}
		else if(KH.downPrssd==true) {
			playerY+=playerSpeed;
		}
		else if(KH.rightPrssd==true) {
			playerX+=playerSpeed;
		}
		else if(KH.leftPrssd==true) {
			playerX-=playerSpeed;
		}
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(playerX,playerY,tileSize,tileSize);
		g2.dispose();
	}
}
