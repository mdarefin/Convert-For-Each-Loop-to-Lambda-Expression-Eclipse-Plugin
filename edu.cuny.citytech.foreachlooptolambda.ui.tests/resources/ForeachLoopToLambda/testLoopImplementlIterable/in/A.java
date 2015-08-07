package p;

class C implements java.lang.Iterable {
  //...
}

class A {
  void m() {
    C c = null; //this class implements java.lang.Iterable.
    //should fail precondition
    for (Object o : c)
      ;
  }
}