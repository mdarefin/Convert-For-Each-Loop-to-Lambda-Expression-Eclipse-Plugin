package p;

import java.util.Arrays;

public class A {

	boolean m() {
		for (Object obj : Arrays.asList(2, 3, 4, 5)) {
			if (obj.equals(2)) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}
}
