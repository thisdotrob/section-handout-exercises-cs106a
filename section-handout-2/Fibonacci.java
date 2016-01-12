/*
 * This file is my solution to the Fibonacci problem.
 */

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	
	private static final int MAX_TERM_VALUE = 10000;
	
	public void run() {
		
		println("This program lists the Fibonacci sequence.");
		
		int fib1 = 0;
		int fib2 = 1;
		println(fib1);
		
		while (fib2 < MAX_TERM_VALUE){
			println(fib2);
			int fib3 = fib2;
			fib2 += fib1;
			fib1 = fib3;
		}
	}
}

