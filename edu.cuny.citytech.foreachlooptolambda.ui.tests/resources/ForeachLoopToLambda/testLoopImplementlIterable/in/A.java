package java.util;

import java.util.Iterator;

public class A<Type> implements Iterable<Type> {

    private Type[] arrayList;
    private int currentSize;

    public A(Type[] newArray) {
        this.arrayList = newArray;
        this.currentSize = arrayList.length;
    }

    @Override
    public Iterator<Type> iterator() {
        Iterator<Type> it = new Iterator<Type>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && arrayList[currentIndex] != null;
            }

            @Override
            public Type next() {
                return arrayList[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
    public static void m() {
	    
	    // creating an array of Strings
	    String[] languages = new String[]{"C", "C++", "Java", "Python", "Scala"};

	    // create your list and hold the values using the same list implementation.
	    A<String> languagesList = new A<String>(languages);

	    System.out.println("");
	    // Since our class SOList is an instance of Iterable, then we can use it on a foreach loop
	    for(String lang : languagesList) {
	        System.out.println(lang);
	    }
	}
}