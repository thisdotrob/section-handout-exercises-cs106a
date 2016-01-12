import java.io.*;

import acm.program.*;


public class Histogram extends ConsoleProgram {
	
	public void run() {
		try {
			
			BufferedReader rd = new BufferedReader(new FileReader("MidtermScores.txt"));				
			
			String zeroTo9 = "";
			String tenTo19 = "";
			String twentyTo29 = "";
			String thirtyTo39 = "";
			String fourtyTo49 = "";
			String fiftyTo59 = "";
			String sixtyTo69 = "";
			String seventyTo79 = "";
			String eightyTo89 = "";
			String ninetyTo99 = "";
			String hundred = "";
			
			while (true) {
				
				String string = rd.readLine();
				
				if (string == null) 
					break;
				
				if (string.length() == 1) 
					zeroTo9 += "*";
				
				if (string.length() == 2) {
					char ch = string.charAt(0);
					switch (ch) {
						case '1': tenTo19 += "*"; break;
						case '2': twentyTo29 += "*"; break;
						case '3': thirtyTo39 += "*"; break;
						case '4': fourtyTo49 += "*"; break;
						case '5': fiftyTo59 += "*"; break;
						case '6': sixtyTo69 += "*"; break;
						case '7': seventyTo79 += "*"; break;
						case '8': eightyTo89 += "*"; break;
						case '9': ninetyTo99 += "*"; break;
					}
					
				}
				
				if (string.length() == 3) 
					hundred += "*";
				
			}
			
			println("00-09: " + zeroTo9);
			println("10-19: " + tenTo19);
			println("20-29: " + twentyTo29);
			println("30-39: " + thirtyTo39);
			println("40-49: " + fourtyTo49);
			println("50-59: " + fiftyTo59);
			println("60-69: " + sixtyTo69);
			println("70-79: " + seventyTo79);
			println("80-89: " + eightyTo89);
			println("90-99: " + ninetyTo99);
			println("  100: " + hundred);
			
		} catch (IOException ex) {
			
			println("Can't find that file");
		
		}
		
		
	}
			
}