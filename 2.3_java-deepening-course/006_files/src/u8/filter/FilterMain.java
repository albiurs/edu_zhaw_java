package u8.filter;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class FilterMain {
	public static void main(String[] args){
		
		PrintWriter print = new PrintWriter( // keine IOException
				               new CaseChangerFilter(
				            		new OutputStreamWriter(System.out)));
		print.write('h');
		print.write('E');
		print.write('L');
		print.write('L');
		print.write('O');
		print.println();
		print.write("world ");
		print.write("AND UNIVERSE");
		
		print.close();  // ohne close() kein Output
	}
}
