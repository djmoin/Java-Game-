package Main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	final int originalTileSize = 16; //16X16 tiles
	final int scale = 3;
	
	final int titleSize = originalTileSize*scale; //48X48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int ScreenWidth = titleSize*maxScreenCol;	//768 pixels
	final int ScreenHeight = titleSize*maxScreenRow;	//576 pixels
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
	}
}
