package com.design;

import java.util.LinkedList;
import java.util.Queue;

public class Implement_Stack_Using_Queues {

	public static void main(String[] args) {

		MyStackUsingTwoQueues stackUsingTwoQueues = new MyStackUsingTwoQueues();
		stackUsingTwoQueues.push(1);
		stackUsingTwoQueues.push(2);
		stackUsingTwoQueues.push(3);
		System.out.println(stackUsingTwoQueues.pop());
		stackUsingTwoQueues.push(4);
		System.out.println(stackUsingTwoQueues.top());
		stackUsingTwoQueues.push(5);
		System.out.println(stackUsingTwoQueues.pop());
		System.out.println(stackUsingTwoQueues.pop());

		System.out.println("----------");

		MyStackUsingSingleQueue stackUsingSingleQueue = new MyStackUsingSingleQueue();
		stackUsingSingleQueue.push(1);
		stackUsingSingleQueue.push(2);
		stackUsingSingleQueue.push(3);
		System.out.println(stackUsingSingleQueue.pop());
		stackUsingSingleQueue.push(4);
		System.out.println(stackUsingSingleQueue.top());
		stackUsingSingleQueue.push(5);
		System.out.println(stackUsingSingleQueue.pop());
		System.out.println(stackUsingSingleQueue.pop());
	}

}

// Stack is LIFO - Last In First Out
class MyStackUsingTwoQueues {

	Queue<Integer> queueA;
	Queue<Integer> queueB;

	public MyStackUsingTwoQueues() {
		this.queueA = new LinkedList<Integer>();
		this.queueB = new LinkedList<Integer>();
	}

	public void push(int x) {
		while (!queueA.isEmpty()) {
			queueB.add(queueA.poll());
		}
		queueA.add(x);
		while (!queueB.isEmpty()) {
			queueA.add(queueB.poll());
		}
	}

	public int pop() {
		return queueA.poll();
	}

	public int top() {
		return queueA.peek();
	}

	public boolean empty() {
		return queueA.isEmpty();
	}

}

class MyStackUsingSingleQueue {

	Queue<Integer> queue;

	public MyStackUsingSingleQueue() {
		this.queue = new LinkedList<Integer>();
	}

	public void push(int x) {
		queue.add(x);
		for (int i = 0; i < queue.size() - 1; i++) {
			queue.add(queue.poll());
		}
	}

	public int pop() {
		return queue.poll();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

}
