package Main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	
	final int originalTileSize = 16; //16X16 tiles
	final int scale = 3;
	
	final int titleSize = originalTileSize*scale; //48X48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int ScreenWidth = titleSize*maxScreenCol;	//768 pixels
	final int ScreenHeight = titleSize*maxScreenRow;	//576 pixels
	
	Thread gameThread;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
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
	public void paintCOmponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(100,100,tileSize,tileSize);
		g2.dispose();
	}
}
