package com.design;

public class Flatten_2D_Vector {

	public static void main(String[] args) {

		int[][] nums = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };

		Vector2D vector2d = new Vector2D(nums);
		for (int i = 0; i < 8; i++) {
			System.out.println(vector2d.next());
			System.out.println(vector2d.hasNext());
		}
	}

}

class Vector2D {

	int[][] vector;
	int row;
	int col;

	public Vector2D(int[][] vec) {
		this.vector = vec;
		this.row = 0;
		this.col = 0;
	}

	public int next() {
		moveNextValid();
		return vector[row][col++];
	}

	public boolean hasNext() {
		moveNextValid();
		return row < vector.length;
	}

	private void moveNextValid() {
		if (row < vector.length && col >= vector[1].length) {
			row++;
			col = 0;
		}
	}

}
