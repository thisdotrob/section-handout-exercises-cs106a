/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class UnitedNationsKarel extends SuperKarel {
	
	public void run(){
		while (noBeepersPresent()){
			moveToDebris();
			pickBeeper();
			buildHouse();
			if(frontIsClear()){
				move();
			}
		}
	}
	
	private void moveToDebris(){
		while(noBeepersPresent()){
			if(frontIsClear()){
				move();
			}
		}
		
	}
	
	private void buildHouse(){
		turnAround();
		move();
		turnRight();
		putThreeBeepers();
		move();
		turnRight();
		move();
		turnRight();
		putThreeBeepers();
		turnAround();
		move();
		turnRight();
		move();
		turnRight();
		putThreeBeepers();
		turnLeft();		
	}
	
	private void putThreeBeepers(){
		for (int i = 0; i < 2; i++){
			putBeeper();
			move();		
		}
		putBeeper();
	}
	
}
