package p;
import loop.test.java.util.Collection;
class A {
  void m()  {
  Collection [] c = new Collection[10];
    for (Object obj : c) //should fail because C is not a java.util.Collection.
      ;
  }
}

