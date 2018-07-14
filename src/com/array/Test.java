package com.array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		/*for(Integer i : s){
			if(i == 2)
				s.remove(i);
			else
				System.out.println(i);
		}*/
		Iterator<Integer> it = s.iterator();
		while(it.hasNext()){
			Integer next = it.next();
			if(next == 2)
				it.remove();
			else
				System.out.println(next);
		}
	}
}
