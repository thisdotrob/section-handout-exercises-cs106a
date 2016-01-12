import java.util.*;

import acm.program.*;

public class CountNames extends ConsoleProgram {
	public void run() {
		
		HashMap<String,Integer>namesMap  = populateNamesMap();
		
		for (String name: namesMap.keySet()) {
			Integer count = namesMap.get(name);
			println(name + ": " + count);
		}
	}

	private HashMap<String, Integer> populateNamesMap() {
		HashMap<String, Integer> namesMap = new HashMap<String, Integer>();
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			if ( namesMap.containsKey(name) ) {
				Integer count = namesMap.get(name);
				namesMap.put(name, ++count);
			} else {
				namesMap.put(name,1);
			}
		}			
		return namesMap;
	}
	
}
