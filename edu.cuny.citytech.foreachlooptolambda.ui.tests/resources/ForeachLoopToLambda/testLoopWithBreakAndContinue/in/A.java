package p;

import java.util.Arrays;
import java.util.Collection;

public class A {

	void m() {
		Collection<Integer> list = Arrays.asList(2, 3, 5, 6, 7);

		for (Integer integer : list) {
			if (integer == 5) {
				continue;
			} else {
				break;
			}
		}
	}
}
