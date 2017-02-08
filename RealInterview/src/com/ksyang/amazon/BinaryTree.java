package com.ksyang.amazon;


/*
 * Given a Binary tree and value X. Find X in the tree and return its parent 

X: 

10 
4 3 
5 7 9 8 

If X = 7, return 4
*/
public class BinaryTree {
	
	int value;
	BinaryTree left;
	BinaryTree right;
	

	public static void main(String[] args){
		
		BinaryTree node10 = new BinaryTree(10, null, null);
		BinaryTree node4 = new BinaryTree(4, null, null);
		BinaryTree node3 = new BinaryTree(3, null, null);
		BinaryTree node5 = new BinaryTree(5, null, null);
		BinaryTree node7 = new BinaryTree(7, null, null);
		BinaryTree node9 = new BinaryTree(9, null, null);
		BinaryTree node8 = new BinaryTree(8, null, null);

		node3.addLeft(node9);
		node3.addRight(node8);
		node4.addLeft(node5);
		node4.addRight(node7);
		node10.addLeft(node4);
		node10.addRight(node3);
		
		BinaryTree parent = node10.findParent(node7);
		System.out.print(parent.value);
		
	}
	
	public BinaryTree(int value, BinaryTree left, BinaryTree right){
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public BinaryTree findParent(BinaryTree child){
		
		if(this.left == null && this.right == null) return null;
		
		BinaryTree leftParent = null;
		BinaryTree rightParent = null;
		
		if(this.left != null){
			if(this.left.value == child.value) return this;
			
			leftParent = this.left.findParent(child);
		}
		if(leftParent != null) return leftParent;
		
		if(this.right != null){
			if(this.right.value == child.value) return this;
			
			rightParent = this.right.findParent(child);
		}
		if(rightParent!=null) return rightParent;
		
		return null;
		
	}
	
	public void addLeft(BinaryTree leftChild){
		this.left = leftChild;
	}
	
	public void addRight(BinaryTree rightChild){
		this.right = rightChild;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTree getLeft() {
		return left;
	}

	public void setLeft(BinaryTree left) {
		this.left = left;
	}

	public BinaryTree getRight() {
		return right;
	}

	public void setRight(BinaryTree right) {
		this.right = right;
	}

}
