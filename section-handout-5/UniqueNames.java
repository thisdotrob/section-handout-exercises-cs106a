import java.util.*;

import acm.program.*;

public class UniqueNames extends ConsoleProgram {
	
	public void run() {
		
		ArrayList<String> nameList = new ArrayList<String>();
	
		while(true){
			String name = readLine("Enter name: ");
			if(name.equals("")){
				break;
			}
			else {
				nameList.add(name);
			}
		}
		printUniqueNames(nameList);
	}

	private void printUniqueNames(ArrayList<String> nameList) {
			Collections.sort(nameList);
			String string1 = nameList.get(0);
			println(string1);
			for(int i = 1; i < nameList.size(); i++) {
				String string2 = nameList.get(i);
				if (!string2.equals(string1)){
					println(string2);
					string1 = string2;
				}
			}
		
	}

}
