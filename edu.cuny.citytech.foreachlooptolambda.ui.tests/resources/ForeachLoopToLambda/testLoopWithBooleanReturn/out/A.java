package p;

import java.util.Arrays;
import java.util.Collection;

public class A {
	
	boolean m(){
		Collection<Integer> i = Arrays.asList(2, 3, 4);
		boolean type = false;
		for (Integer integer : i) {
			if(integer == 3)
				return type = true;
		}
		return type ;
	}

}
