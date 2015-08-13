package p;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class A{
  public static void listForEach(){
    List<Integer> ls = Arrays.asList();
    for(Integer i : ls){
 
    }
  }
  static void checkArray(){}
  
  public static void m() throws IOException{
		Collection <Integer> list = Arrays.asList(2,3,5,6,7);
		for (Integer s : list) {
			
			checkArray();
			listForEach();
			throwException();
		}
	}
  public static void throwException() throws IOException{
		List<Integer> list = Arrays.asList(2,3,5,6,7);
		for (Integer s : list) {
			System.out.println(s);
		}
	}
}