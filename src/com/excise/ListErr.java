package com.excise;

import java.util.ArrayList;
import java.util.List;

public class ListErr {

	public static void main(String[] args) {
		List strList = new ArrayList();
		strList.add("hahaha");
		strList.add("huge");
		strList.add(7);
		strList.forEach(str->System.out.println(((String)str).length()));
;	}
}
