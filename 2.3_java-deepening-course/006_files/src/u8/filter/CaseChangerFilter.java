package u8.filter;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CaseChangerFilter extends FilterWriter {
	public CaseChangerFilter (Writer writer) {
		super (writer);
	}

	@Override
	public void write (int arg0) throws IOException {
		if (Character.isLetter(arg0)) 
			if (Character.isLowerCase(arg0)) 
				super.write(Character.toUpperCase(arg0));
			else super.write(Character.toLowerCase(arg0));
		else super.write (arg0);
	}

	@Override
	public void write (char[] cbuf,  int offset, int count) throws IOException {
		for (char c : cbuf) write(c);
	}

	@Override
	public void write (String str, int offset, int count) throws IOException {
		char[] text = str.toCharArray();
		write(text);
	}

}
