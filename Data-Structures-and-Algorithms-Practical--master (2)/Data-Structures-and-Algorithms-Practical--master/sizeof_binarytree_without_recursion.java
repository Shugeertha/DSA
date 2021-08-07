// Java programn to calculate
// Size of a tree without recursion
import java.util.LinkedList;
import java.util.Queue;

class Node
{
	int data;
	Node left, right;

	public Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class Main
{
	Node root;
		
	public int size()
	{
		if (root == null)
			return 0;
		
		// Using level order Traversal.
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		
		int count = 1;
		while (!q.isEmpty())
		{
			Node tmp = q.poll();
	
			// when the queue is empty:
			// the poll() method returns null.
			if (tmp != null)
			{
				if (tmp.left != null)
				{
					// Increment count
					count++;
					
					// Enqueue left child
					q.offer(tmp.left);
				}
				if (tmp.right != null)
				{
					// Increment count
					count++;
					
					// Enqueue left child
					q.offer(tmp.right);
				}
			}
		}
		
		return count;
	}

	public static void main(String args[])
	{
		/* creating a binary tree and entering
		the nodes */
		Main tree = new Main();
		tree.root = new Node(6);
		tree.root.left = new Node(3);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(5);
		tree.root.right = new Node(9);
		tree.root.right.left = new Node(7);
		tree.root.right.right = new Node(11);

		System.out.println("The size of binary tree" +
						" is : " + tree.size());
	}
}

