package com.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public static void main(String[] args) {

		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1)); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2)); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1)); // return -1 (not found)
		System.out.println(lRUCache.get(3)); // return 3
		System.out.println(lRUCache.get(4)); // return 4

	}

	Node head;
	Node tail;
	int capacity;
	Map<Integer, Node> map;

	public LRUCache(int capacity) {
		this.head = new Node(-1, -1);
		this.tail = new Node(-1, -1);
		this.capacity = capacity;
		this.map = new HashMap<Integer, Node>();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			removeNode(node);
			insertAtHead(node);
			return node.val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			removeNode(node);
		} else if (map.size() == capacity) {
			removeNode(tail.prev);
		}
		Node node = new Node(key, value);
		insertAtHead(node);
	}

	private void insertAtHead(Node node) {
		map.put(node.key, node);
		Node next = head.next;
		node.next = next;
		next.prev = node;
		node.prev = head;
		head.next = node;
	}

	private void removeNode(Node node) {
		map.remove(node.key);
		Node prev = node.prev;
		Node next = node.next;
		next.prev = prev;
		prev.next = next;
	}

}
