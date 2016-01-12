

import java.awt.event.MouseEvent;
import acm.program.*;
import acm.graphics.*;

public class RubberBanding extends GraphicsProgram {

	public void run() {
		addMouseListeners();	
	}
	
	public void mousePressed(MouseEvent e) {
		line.setStartPoint(e.getX(), e.getY());
		line.setEndPoint(e.getX(), e.getY());
		add(line);
	}
	
	public void mouseDragged(MouseEvent e) {
		line.setEndPoint(e.getX(), e.getY());
		
	}

	private GLine line = new GLine(0,0,0,0);
	
}
