
import acm.graphics.*;
import acm.program.*;
import acm.util.RandomGenerator;

import java.awt.*;


public class RandomCircles extends GraphicsProgram {
	
	public void run() {
		
		for (int i = 0; i < 10; i++) {
			Color color = rgen.nextColor();
			int radius = rgen.nextInt( 5, 50 );
			int diameter = 2 * radius;
			int x = rgen.nextInt ( 0, getWidth() - diameter );
			int y = rgen.nextInt ( 0, getHeight() - diameter );
			GOval circle = new GOval(x,y,diameter,diameter);
			circle.setFilled(true);
			circle.setFillColor(color);
			circle.setColor(color);
			add(circle);
		}
		
	}
	
	/* Private instance variable for the random-number generator */
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	

}
