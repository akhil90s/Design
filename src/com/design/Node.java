package com.design;

public class Node {

	Node next;
	Node prev;
	int key;
	int val;

	public Node(int key, int val) {
		super();
		this.key = key;
		this.val = val;
	}

	public Node(Node next, Node prev, int val) {
		super();
		this.next = next;
		this.prev = prev;
		this.val = val;
	}
	
}
