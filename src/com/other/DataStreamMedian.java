package com.other;

import java.util.PriorityQueue;

public class DataStreamMedian {
	PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>();
	PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
	
	public void insert(Integer num) {
		//总和为偶数
		if (((maxQ.size() + minQ.size()) & 1) == 0) {
			maxQ.offer(num);
			minQ.offer(maxQ.remove());
		}else {
			minQ.offer(num);
			maxQ.offer(minQ.remove());
		}
	}
	
	public Double getMedian() {
		if (maxQ.size() == 0 && minQ.size() == 0) {
			return new Double(0.0);
		}
		
		if (((minQ.size() + maxQ.size()) & 1) == 0) {
			return (double)((minQ.peek() + maxQ.peek()) / 2);
		}else {
			return (double)(minQ.peek());
		}
	}
} 
