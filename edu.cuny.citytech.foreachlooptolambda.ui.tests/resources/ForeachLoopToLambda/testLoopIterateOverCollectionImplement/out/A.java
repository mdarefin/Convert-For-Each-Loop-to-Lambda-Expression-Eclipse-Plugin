package collectionTestCase;

abstract class C implements java.util.Collection {
    //...
}
class A {
    void m() {
        C c = null;
        for (Object obj : c)
            ;
    }
}