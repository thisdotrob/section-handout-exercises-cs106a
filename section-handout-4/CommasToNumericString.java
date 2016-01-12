
import acm.program.*;

public class CommasToNumericString extends ConsoleProgram {
	public void run() {
		while (true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
		}
	}
	private String addCommasToNumericString (String string) {
		String subString = string;
		for (int i = 1; subString.length() > 3; i++) {	
			string = addComma(i,string);
			subString = string.substring(0,string.length() - (i * 3) - i);	
		}
		return string;
	}
	private String addComma(int i, String string) {
		int splitIndex = string.length() - ( i * 3 ) - ( i - 1 );
		String result = string.substring(0, splitIndex) + "," + string.substring(splitIndex);
		return result;
	}
} 
