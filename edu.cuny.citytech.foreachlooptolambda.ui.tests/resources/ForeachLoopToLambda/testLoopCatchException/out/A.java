package p;

import java.util.Arrays;
import java.util.List;

public class A {

	void m() {
		List<Integer> ls = Arrays.asList(23, 4, 56, 6);

		for (Integer integer : ls) {
			try {
				int a = integer / 0;
			} catch (Exception e) {

			}
		}
	}

}
