package p;

import java.util.Iterator;

class A implements java.lang.Iterable {

	@Override
	public Iterator iterator() {
		return null;
	}
 
	void m() {
	    A a = null; 
	    for (Object o : a)
	      ;
	  }

}

