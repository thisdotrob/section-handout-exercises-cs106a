import java.io.*;
import acm.program.*;
import acm.util.*;


public class WordCount extends ConsoleProgram {
	
	public void run() {
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new FileReader("lear.txt"));
		} catch (IOException ex) {
			println("Can't open that file.");
		}
		countLinesWordsChars(rd);
	}
	

	private void countLinesWordsChars(BufferedReader rd) {
		int lineCount = 0;
		int wordCount = 0;
		int charCount = 0;
		String line;
		while(true) {
			try {
				line = rd.readLine();
			} catch (IOException ex) {
				throw new ErrorException(ex);
			}
			if (line == null) {
				break;
			}
			else {
				lineCount++;
				wordCount += countWords(line);
				charCount += line.length();
				println(line.length());
			}
		}
		println("Lines = " + lineCount);
		println("Words = " + wordCount);
		println("Chars = " + charCount);
	}
	

	private int countWords(String line) {
		int wordCount = 0;
		line = "*" + line;
		for(int i = line.length() - 1; i > 0; i--) {
			char ch1 = line.charAt(i);
			char ch2 = line.charAt(i-1);
			if( Character.isLetterOrDigit(ch1)
					&&
				!Character.isLetterOrDigit(ch2) ) {
				wordCount++;
			}
		}
		return wordCount;
	}
	

}
