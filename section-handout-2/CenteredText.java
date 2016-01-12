/*
 * This file is my solution to the centered text problem.
 */

import acm.graphics.*;
import acm.program.*;

public class CenteredText extends GraphicsProgram {
	
	public void run(){
		GLabel label = new GLabel("CS106A rocks my socks!");
		
		double labelX = ( getWidth()-label.getWidth() ) / 2 ;
		double labelY = ( getHeight() + label.getAscent() ) / 2 ;
		
		label.setLocation(labelX,labelY);
		
		add(label);
	}
	
}

