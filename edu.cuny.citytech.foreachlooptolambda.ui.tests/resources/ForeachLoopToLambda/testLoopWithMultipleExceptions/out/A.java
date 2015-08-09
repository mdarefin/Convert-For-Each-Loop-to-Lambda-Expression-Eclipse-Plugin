package p;

import java.util.Arrays;
import java.util.List;

public class A {

	void m() {
		List<Integer> ls = Arrays.asList();

		for (Integer integer : ls) {
			try {

			} catch (IllegalArgumentException iae) {

			} catch (NullPointerException npe) {

			}
		}

	}
}
