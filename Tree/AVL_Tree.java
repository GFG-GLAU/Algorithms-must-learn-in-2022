import java.util.*;

class Node {
	Node l, r;
	int height;
	int data;

	Node(int d) {
		data = d;
		height = 0;
	}
}

public class avl {

	static void print(Node x) {
		if (x == null)
			return;

		print(x.l);
		System.out.print(x.data + " ");
		print(x.r);

	}

	static int height(Node x) {
		if (x == null) {
			return -1;
		}
		return x.height;
	}

	static int balancefactor(Node x) {
		if (x == null)
			return 0;
		return height(x.l) - height(x.r);
	}

	static Node leftRotate(Node x) {
		Node t1 = x.r;
		Node t2 = t1.l;

		t1.l = x;
		x.r = t2;

		x.height = 1 + Math.max(height(x.l), height(x.r));
		t1.height = 1 + Math.max(height(t1.l), height(t1.r));
		return t1;
	}

	static Node rightRotate(Node x) {
		Node t1 = x.l;
		Node t2 = t1.r;

		t1.r = x;
		x.l = t2;

		x.height = 1 + Math.max(height(x.l), height(x.r));
		t1.height = 1 + Math.max(height(t1.l), height(t1.r));

		return t1;

	}

	static Node insert(Node x, int data) {
		// basic insertion
		if (x == null)
			return new Node(data);
		if (x.data > data)
			x.l = insert(x.l, data);
		else if (x.data < data)
			x.r = insert(x.r, data);
		else
			return x;

		// update heiight in bACK RECURSION

		x.height = 1 + Math.max(height(x.l), height(x.r));

		int balance = balancefactor(x);

		if (balance > 1 && data > x.l.data) {
			x.l = leftRotate(x.l);
			return rightRotate(x);
		}

		if (balance > 1 && data < x.l.data)
			return rightRotate(x);

		if (balance < -1 && data > x.l.data)
			return leftRotate(x);

		if (balance < -1 && data < x.l.data) {
			x.r = rightRotate(x.r);
			return leftRotate(x);
		}

		return x;

	}

	static Node delete(Node x, int data) {
		// simple search
		if (x.data > data) {
			x.l = delete(x.l, data);
		} else if (x.data < data) {
			x.r = delete(x.r, data);
		} else {
			if (x.r == null)
				return x.l;
			else if (x.l == null)
				return x.r;

			x.data = pop_inordersucessor(x).data;
			return x;
		}

		x.height = 1 + Math.max(height(x.l), height(x.r));

		int balance = balancefactor(x);

		if (balance > 1 && data > x.l.data) {
			x.l = leftRotate(x.l);
			return rightRotate(x);
		}

		if (balance > 1 && data < x.l.data)
			return rightRotate(x);

		if (balance < -1 && data > x.l.data)
			return leftRotate(x);

		if (balance < -1 && data < x.l.data) {
			x.r = rightRotate(x.r);
			return leftRotate(x);
		}

		return x;

	}

	static Node pop_inordersucessor(Node x) {
		Node prev = x;
		x = x.r;
		if (x.l == null) {
			prev.r = null;
			return x;
		}
		while (x.l.l != null) {
			x = x.l;
		}
		prev = x.l;
		x.l = null;
		return prev;

	}

	public static void main(String args[]) {

		Node root = new Node(100);
		root = insert(root, 90);
		root = insert(root, 70);
		root = insert(root, 60);
		root = insert(root, 50);
		root = insert(root, 40);
		root = insert(root, 30);
		root = insert(root, 20);
		root = insert(root, 75);
		root = delete(root, 30);
		System.out.println(root.data);
		print(root);

	}

}
