package vn.binhtv.datastructure.tree;

/**
 * Binary search tree is a node-based binary tree data structure which has the following properties
 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 * There must be no duplicate nodes.
 * @author binhtran
 *
 */
public class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int data) {
		Node newNode = new Node(data);
		Node root = this.root;
		if(root == null) {
			this.root = newNode;
		}
		
		while(root != null) {
			if(data > root.getData()) {
				if(root.getRight() != null) {
					root = root.getRight();
				} else {
					root.setRight(newNode);
					break;
				}
			}
			
			if(data < root.getData()) {
				if(root.getLeft() != null) {
					root = root.getLeft();
				} else {
					root.setLeft(newNode);
					break;
				}
			}
		}
	}

	public Node search(int data) {
		Node node = this.root;
		Node found = null;
		while(node != null) {
			if(data == node.getData()) {
				found = node;
				break;
			}
			
			if(data > node.getData()) {
				node = node.getRight();
			}
			
			if(data < node.getData()) {
				node = node.getLeft();
			}
		}
		
		return found;
	}
	
	public void traverseLNR() {
		this.traverseLNR(this.root);
		System.out.println();
	}
	
	public void traverseLRN() {
		this.traverseLRN(this.root);
		System.out.println();
	}
	
	public void traverseNLR() {
		this.traverseNLR(this.root);
		System.out.println();
	}
	
	private void traverseLNR(Node node) {
		if(node == null) {
			return;
		}
		traverseLNR(node.getLeft());
		System.out.print(node.getData() + " ");
		traverseLNR(node.getRight());
	}
	
	private void traverseLRN(Node node) {
		if(node == null) {
			return;
		}
		traverseLRN(node.getLeft());
		traverseLRN(node.getRight());
		System.out.print(node.getData() + " ");
	}
	
	private void traverseNLR(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		traverseNLR(node.getLeft());
		traverseNLR(node.getRight());
	}

	class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
		@Override
		public String toString() {
			return "@Node " + this.data;
		}
	}
}
