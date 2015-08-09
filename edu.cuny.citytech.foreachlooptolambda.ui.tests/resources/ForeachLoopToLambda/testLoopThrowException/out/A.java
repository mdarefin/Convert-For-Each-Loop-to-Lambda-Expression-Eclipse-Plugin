package p;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class A {

	void m() throws IOException {
		List<Integer> list = Arrays.asList(2, 3, 5, 6, 7);
		for (Integer s : list) {
			throw new IOException("!Exception");
		}
	}

}
