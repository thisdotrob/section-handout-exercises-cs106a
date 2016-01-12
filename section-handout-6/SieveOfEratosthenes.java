import java.util.*;

import acm.program.ConsoleProgram;


public class SieveOfEratosthenes extends ConsoleProgram {
	
	private static int UPPER_LIMIT = 1000;
	private int divisorIndex = 0;
	
	public void run() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= UPPER_LIMIT; i++){
			list.add(i);
		}
		while ( divisorIndex + 1 != list.size() ){
			for (int i = divisorIndex + 1; i < list.size(); i++){
				if (list.get(i) % list.get(divisorIndex) == 0) {
					list.remove(i);
				}	
			}
			divisorIndex++;
		}
		for (int num: list) {
			println(num);
		}
	}
}
