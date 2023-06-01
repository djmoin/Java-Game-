package Main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean upPrssd,downPrssd,rightPrssd,leftPrssd;

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	
		int code = e.getKeyCode();
		
		if(code==KeyEvent.VK_W) {
			upPrssd=true;
		}
		if(code==KeyEvent.VK_S) {
			downPrssd=true;
		}
		if(code==KeyEvent.VK_D) {
			rightPrssd=true;
		}
		if(code==KeyEvent.VK_A) {
			leftPrssd=true;
		}
		
	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	int code = e.getKeyCode();
		
		if(code==KeyEvent.VK_W) {
			upPrssd=false;
		}
		if(code==KeyEvent.VK_S) {
			downPrssd=false;
		}
		if(code==KeyEvent.VK_D) {
			rightPrssd=false;
		}
		if(code==KeyEvent.VK_A) {
			leftPrssd=false;		
		}
	}	
}
