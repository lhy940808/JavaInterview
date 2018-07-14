package com.list;

public class DoubleList {

	public int value;
	public DoubleList pre;
	public DoubleList next;
	
	public DoubleList(int value) {
		this.value = value;
		pre = null;
		next = null;
	}
}
