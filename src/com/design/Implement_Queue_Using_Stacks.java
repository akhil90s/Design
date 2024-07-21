package com.design;

import java.util.Stack;

public class Implement_Queue_Using_Stacks {

	public static void main(String[] args) {

		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		queue.push(4);
		System.out.println(queue.peek());
		queue.push(5);
		System.out.println(queue.pop());
		System.out.println(queue.pop());

	}

}

class MyQueue {

	Stack<Integer> input;
	Stack<Integer> output;

	public MyQueue() {
		this.input = new Stack<Integer>();
		this.output = new Stack<Integer>();
	}

	public void push(int x) {
		input.add(x);
	}

	public int pop() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.pop();
	}

	public int peek() {
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
}
