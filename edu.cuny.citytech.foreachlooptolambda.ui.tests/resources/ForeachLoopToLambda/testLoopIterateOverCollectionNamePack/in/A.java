package java.util.collection;

import java.util.Iterator;

class java.util.Collection.foorLoop implements java.lang.Iterable {

	@Override
	public Iterator iterator() {
		return null;
	}
}

class A {
	  void m() {
	    A l = null; //this class implements java.lang.Iterable.
	    //should fail precondition
	    for (Object o : l);
   }
}