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
	
	KeyHandler KH = new KeyHandler();
	
	
	Thread gameThread;
	
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
	
	@Override
	public void run() {
		while(gameThread!=null) {
			update();
			
			repaint();
		}
	}
	public void update(){
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(100,100,tileSize,tileSize);
		g2.dispose();
	}
}
