package p;

import java.util.Arrays;
import java.util.Collection;

public class A {

	int m() {
		Collection<Integer> i = Arrays.asList(2, 3, 4);
		for (Integer integer : i) {
			return integer;
		}
		return 2;
	}
}
