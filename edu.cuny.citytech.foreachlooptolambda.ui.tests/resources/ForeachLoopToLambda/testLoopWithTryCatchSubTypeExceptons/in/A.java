package p;

import java.io.IOException;
import java.util.Collection;

import javax.swing.text.ChangedCharSetException;

public class A {

	void m() throws IOException {
		Collection c = null;
		for (Object object : c) {
			try{
				throw new IOException();
			}catch(ChangedCharSetException e){
				
			}
		}
	}
	
}
