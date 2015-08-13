package p;

import java.io.IOException;
import java.util.Collection;

public class A {

	void m() throws Exception {
		Collection c = null;
		for (Object object : c) {
			n();
		}
	}

	void n() throws Exception, IOException {

	}
}
