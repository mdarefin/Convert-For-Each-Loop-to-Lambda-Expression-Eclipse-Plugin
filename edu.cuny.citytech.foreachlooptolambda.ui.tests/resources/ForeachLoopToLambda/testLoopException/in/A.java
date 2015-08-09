package p;

import java.util.Arrays;
import java.util.List;

public class A {

	void m() {
		List<Integer> ls = Arrays.asList(7, 11, 63);

		for (Integer integer : ls) {
			int i = integer / 0;
		}
	}
}
