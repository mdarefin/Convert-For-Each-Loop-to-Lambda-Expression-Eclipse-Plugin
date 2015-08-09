package p;

import java.util.Arrays;
import java.util.List;

public class A {

	void m() {
		List<Integer> ls = Arrays.asList();
		for (Integer integer : ls) {
			try {

				int a = 5 / integer;
				System.out.println(Integer.toString(a));

			} catch (IllegalArgumentException iae) {

			} catch (NullPointerException npe) {

			}
		}

	}

}
