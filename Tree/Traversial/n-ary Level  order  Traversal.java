import java.util.*;
public class Main {
static class Node {

	public int val;
	public Vector<Node> children;
	public Node(int key)
	{
	val = key;
	children = new Vector<Node>();
	}
}
static Node newNode(int key)
{
	Node temp = new Node(key);
	return temp;
}


static List<List<Integer> > levelOrder(Node root)
{
	List<List<Integer> > ans = new ArrayList<>();
	if (root == null)
	System.out.println(
	"N-Ary tree does not any nodes");

	
	Queue<Node> main_queue = new LinkedList<>();

	main_queue.offer(root);


	while (!main_queue.isEmpty()) {

	List<Integer> temp = new ArrayList<>();
	int size = main_queue.size();
	
	for (int i = 0; i < size; i++) {
		Node node = main_queue.poll();
		temp.add(node.val);

		for (Node child : node.children) {
		main_queue.offer(child);
		}
	}

	ans.add(temp);
	}

	return ans;
}


public static void printList(List<List<Integer> > temp)
{
	for (List<Integer> it : temp) {
	for (Integer et : it)
		System.out.print(et + " ");
	System.out.println();
	}
}
public static void main(String[] args)
{
	Node root = newNode(1);
	(root.children).add(newNode(3));
	(root.children).add(newNode(2));
	(root.children).add(newNode(4));
	(root.children.get(0).children).add(newNode(5));
	(root.children.get(0).children).add(newNode(6));
	List<List<Integer> > ans = levelOrder(root);
	printList(ans);
}
}


