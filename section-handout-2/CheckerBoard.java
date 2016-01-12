/*
 * File: CheckerBoard.java
 * Name: 
 * Section Leader: 
 * ----------------------
 * This file is the checkerboard problem in handout 12.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class CheckerBoard extends GraphicsProgram {
	
	
	
	private static final int NROWS = 20;
	private static final int NCOLUMNS = 100;
	private static final java.awt.Color SQCOLOR = Color.blue;
	
	
	
	public void run() {
		
				
		final double sqSize = getHeight()/NROWS;
		
		for (int i = 0; i < NCOLUMNS; i++){
			for (int j = 0; j < NROWS; j++){
				GRect square = new GRect(i*sqSize,j*sqSize,sqSize,sqSize);
				
				if(j % 2 == 0) {
					if(i % 2 == 0){
						square.setFilled(true);
						square.setFillColor(SQCOLOR);
					}
				}
				else {
					if(i % 2 != 0){
						square.setFilled(true);
						square.setFillColor(SQCOLOR);
					}
				}
				add(square);
			}
		}
		
		
	}
	
	
	
}

