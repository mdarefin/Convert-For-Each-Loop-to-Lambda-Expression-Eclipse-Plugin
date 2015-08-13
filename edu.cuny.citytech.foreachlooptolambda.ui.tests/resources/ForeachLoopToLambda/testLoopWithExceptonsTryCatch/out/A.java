package p;

import java.io.IOException;
import java.util.Collection;

public class A {

	void m() {
		Collection c = null;
		for (Object object : c) {
			try {
				n();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void n() throws Exception, IOException {

	}

}
