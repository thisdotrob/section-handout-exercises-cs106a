
import acm.program.*;

public class AltCaps extends ConsoleProgram {
	
	public void run() {
		String str = readLine("enter a string: ");
		println( altCaps(str) );
	}

	private String altCaps(String str) {
		String result = "";
		int counter = 0; 
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isLetter(ch)) {
				counter++;
				if (counter % 2 == 0) {
					result += Character.toUpperCase(ch);					
				}
				else {
					result += Character.toLowerCase(ch);
				}
			}
			else {
				result += ch;
			}
		}
		
		
		return result;
	}
}
