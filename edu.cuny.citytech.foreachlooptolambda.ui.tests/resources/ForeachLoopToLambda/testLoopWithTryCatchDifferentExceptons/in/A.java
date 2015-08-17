package p;

import java.io.IOException;
import java.util.Collection;

public class A {

	void m() throws Exception{
		Collection c = null;
		for (Object object : c) {
			try{
				throw new Exception();
			}catch(IOException e){
				
			}
		}
	}
	
}
