/*
 * This file is my solution to the draw a face problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawingAFace extends GraphicsProgram {
	
	private static final double HEAD_HEIGHT = 400;
	private static final double HEAD_WIDTH = .6 * HEAD_HEIGHT;
	private static final double EYE_RADIUS = .1 * HEAD_WIDTH;
	private static final double MOUTH_WIDTH = 0.75 * HEAD_WIDTH;
	private static final double MOUTH_HEIGHT = 0.3 * MOUTH_WIDTH;

	
	public void run(){
		drawHead();
		drawEyes();
		drawMouth();
	}
	
	private void drawHead() {
		double x = ( getWidth() - HEAD_WIDTH ) / 2 ;
		double y = ( getHeight() - HEAD_HEIGHT) / 2 ;
		GRect head = new GRect(x, y, HEAD_WIDTH, HEAD_HEIGHT);
		head.setColor(Color.BLACK);
		head.setFilled(true);
		head.setFillColor(Color.GRAY);
		add(head);
	}
	
	private void drawEyes() {
		double y = ( getHeight() / 2 ) - ( 0.25 * HEAD_HEIGHT ) - EYE_RADIUS ;
		double x1 = ( getWidth() / 2 ) - ( 0.25 * HEAD_WIDTH ) - EYE_RADIUS ;
		double x2 = ( getWidth() / 2 ) + ( 0.25 * HEAD_WIDTH ) - EYE_RADIUS ;
		drawEye(x1,y);
		drawEye(x2,y);
	}
	
	private void drawEye(double x, double y) {
		GOval eye = new GOval(x, y, 2*EYE_RADIUS, 2*EYE_RADIUS);
		eye.setColor(Color.YELLOW);
		eye.setFilled(true);
		eye.setFillColor(Color.YELLOW);
		add(eye);
	}
	
	private void drawMouth() {
		double x = ( getWidth() - MOUTH_WIDTH ) / 2;
		double y = ( getHeight() / 2 ) + ( 0.25 * HEAD_HEIGHT ) - ( 0.5 * MOUTH_HEIGHT );
		GRect mouth = new GRect(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
		mouth.setColor(Color.WHITE);
		add(mouth);
	}
	
}