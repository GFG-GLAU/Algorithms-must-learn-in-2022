

import java.util.*;

import javax.swing.text.Position;

// Heap is a complete binary tree and is implemented using array representation of tree   

class maxheap {
	int arr[];
	int size;
	int last_pos = 0;

	maxheap(int size) {
		this.size = size;
		arr = new int[size];
	}

	boolean idLeaf() {
		return last_pos > size / 2;
	}

	int leftchild(int i) {
		return arr[2 * i];
	}

	int rightchild(int i) {
		return arr[2 * i + 1];
	}

	int parent(int i) {
		return arr[Math.floorDiv(i, 2)];
	}

	void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}

	void insert(int i) {
		last_pos++;
		arr[last_pos] = i;
		i = last_pos;
		while (i > 1) {
			if (arr[i] > arr[i / 2]) {
				swap(i, i / 2);
				i = i / 2;
			} else
				return;
		}
	}

	int pop() {
		int s = arr[1];
		arr[1] = arr[last_pos--];
		int i = 1;
		while (true) {
			int ss = 2 * i;
			if (ss <= last_pos && arr[i] < arr[ss + 1]) {
				swap(i, ss + 1);
				i = ss + 1;
			} else if (ss <= last_pos && arr[i] < arr[ss]) {
				swap(i, ss);
				i = ss;
			} else {
				break;
			}
		}
		return s;
	}

	void print() {
		System.out.println();
		for (int i = 1; i < last_pos; i++) {
			System.out.print(arr[i] + "  ");
		}
	}
}

public class heap_practice {
	public static void main(String args[]) {
		maxheap mh = new maxheap(10);
		mh.insert(5);
		mh.insert(6);
		mh.insert(20);
		mh.insert(9);
		mh.insert(50);

		System.out.print(mh.pop());
		mh.print();

	}

}
