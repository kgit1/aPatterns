package c2.InputOutput.DecoratorPattern;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

//create own class decorator for FilterInput stream
//receives bytes from superClass and compares if they responsible for 
//upper Characters and if so - converts them to lower case 
public class LowerCaseInputStream extends FilterInputStream {

	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}

	// get byte - return char converted to lower case
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char) c));
	}

	// get byte array - return chars converted to lower case
	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset + result; i++) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}
		return result;
	}
}
