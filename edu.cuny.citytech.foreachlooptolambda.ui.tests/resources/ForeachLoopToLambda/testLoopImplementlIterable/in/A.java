package p;

import java.util.Iterator;

class C implements java.lang.Iterable {

	@Override
	public Iterator iterator() {
		return null;
	}
  //...
}

class A {
	  void m() {
	    C c = null; //this class implements java.lang.Iterable.
	    //should fail precondition
	    for (Object o : c);
   }
}