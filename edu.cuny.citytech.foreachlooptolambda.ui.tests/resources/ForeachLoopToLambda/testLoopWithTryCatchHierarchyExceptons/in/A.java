package p;

import java.io.IOException;
import java.util.Collection;

public class A {

	void m() {
		Collection c = null;
		for (Object object : c) {
			try{
				throw new IOException();
			}catch(Exception e){
				
			}
		}
	}
	
}
