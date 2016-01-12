
import acm.program.*;

public class RemoveAllOccurrences extends ConsoleProgram {
	
	public void run() {
		println(removeAllOccurrences("This is a test", 't')); //returns "This is a es"
		println(removeAllOccurrences("Summer is here!", 'e')); //returns "Summr is hr"
		println(removeAllOccurrences("---0---", '-')); //returns "0"
	}
	
	public String removeAllOccurrences(String str, char ch) {
		while (str.indexOf(ch) != -1) {
			int index = str.indexOf(ch);
			str = str.substring(0,index) + str.substring(index+1)	;
		}
		return str;
	}
}
