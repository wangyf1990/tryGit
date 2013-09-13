package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ReturnMultipleValues {
	public static Person returnMultipleValues() {
		Person p = new Person();
		p.teleNum = 123;
		p.name = "Jim";
		return p;
		
	}
	
    public static ArrayList<Integer> mutiple() {
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	al.add(5);
    	al.add(6);
    	return al;
    }
	public static void main(String[] args) {
		Person x = returnMultipleValues();
		System.out.println(x.teleNum + x.name);
		
		Collection<Integer> c = mutiple();
		for(Iterator<Integer> i=c.iterator() ; i.hasNext(); ) {
			System.out.println(i.next());
		}
	}

}

class Person {
	public int teleNum;
	public String name;
}
