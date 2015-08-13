package p;

import java.io.IOException;
import java.util.Collection;

public class A {

	void m() {
		Collection c = null;
		for (Object object : c) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

}
