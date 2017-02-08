package com.ksyang.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LongestPathInBT {
	
	public static void main(String[] args){
		LongestPathInBT bt = new LongestPathInBT();
		
		BinaryTree bt8 = bt.new BinaryTree(8, null, null);
		BinaryTree bt7 = bt.new BinaryTree(7, null, null);
		BinaryTree bt6 = bt.new BinaryTree(6, bt8, null);
		BinaryTree bt3 = bt.new BinaryTree(3, bt6, bt7);
		BinaryTree bt4 = bt.new BinaryTree(4, null, null);
		BinaryTree bt5 = bt.new BinaryTree(5, null, null);
		BinaryTree bt2 = bt.new BinaryTree(2, bt4, bt5);
		BinaryTree bt1 = bt.new BinaryTree(1, bt2, bt3);
		
		ResultWrapper wrapper = bt.new ResultWrapper();
		bt1.dfsForLongestPath(wrapper, 0, null);
		
		List<BinaryTree> list= new ArrayList<>();
		while(!wrapper.getfStack().isEmpty()){
			list.add(wrapper.getfStack().pop());
		}
		
		//Losgest path
		for(int i=(list.size()-1); i>=0; i--){
			System.out.print(list.get(i).getValue()+" ");
		}
		System.out.println();
		
		List<Stack<BinaryTree>> allPaths = new ArrayList<>();
		bt1.dfsForAllPaths(null, allPaths);
		
		System.out.println("All paths");
		for(Stack<BinaryTree> stack : allPaths){
			StringBuffer sb = new StringBuffer();
			while(!stack.isEmpty()){
				sb.append(stack.pop().getValue()+" ");
			}
			System.out.println(sb.reverse());
			
		}
		
		System.out.println("All levels");
		LinkedList<BinaryTree> listOfSameLevel = new LinkedList<>();
		listOfSameLevel.add(bt1);
		List<List<BinaryTree>> allLevels = new ArrayList<>();
		bt1.bfsForAllLevels(listOfSameLevel, allLevels);
		
		for(List<BinaryTree> level : allLevels){
			for(BinaryTree node : level){
				System.out.print(node.getValue()+" ");
			}
			System.out.println();
		}
		
	}
	
	
	private class BinaryTree{
		
		private int value;
		private BinaryTree left;
		private BinaryTree right;
		
		public void dfsForLongestPath(ResultWrapper wrapper, int cLength, Stack<BinaryTree> cStack){
			
			if(cStack == null) cStack = new Stack<>();
			cLength++;
			cStack.add(this);
			
			if(this.left!=null){
				this.left.dfsForLongestPath(wrapper, cLength, cStack);
			}
			
			if(this.right!=null){
				this.right.dfsForLongestPath(wrapper, cLength, cStack);
			}
			
			if(this.left==null && this.right==null){
				if(cLength>wrapper.getfLength()){
					wrapper.getfStack().clear();
					wrapper.getfStack().addAll(cStack);
					wrapper.setfLength(cLength);
				}
			}
			
			cLength--;
			cStack.pop();
			
		}
		
		public void dfsForAllPaths(Stack<BinaryTree> cStack, List<Stack<BinaryTree>> allPaths){
			
			if(cStack==null) cStack = new Stack<>();
			
			cStack.add(this);
			
			if(this.left!=null){
				this.left.dfsForAllPaths(cStack, allPaths);
			}
			
			if(this.right!=null){
				this.right.dfsForAllPaths(cStack, allPaths);
			}
			
			if(this.left==null && this.right==null){
				Stack<BinaryTree> stack = new Stack<>();
				stack.addAll(cStack);
				allPaths.add(stack);
			}
			
			cStack.pop();
		}
		
		public void bfsForAllLevels(LinkedList<BinaryTree> list, List<List<BinaryTree>> allLevels){
			
			List<BinaryTree> level = new ArrayList<>(list);
			allLevels.add(level);
			
			int size = list.size();
			while(size>0){
				BinaryTree node = list.remove();
				if(node.left!=null) list.add(node.left);
				if(node.right!=null) list.add(node.right);
				
				size--;
			}
			
			if(list.size()!=0){
				this.bfsForAllLevels(list, allLevels);
			}
			
		}
		
		public BinaryTree(int value, BinaryTree left, BinaryTree right) {
			super();
			this.value = value;
			this.left = left;
			this.right = right;
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

	private class ResultWrapper{
		int fLength;
		Stack<BinaryTree> fStack;
		
		public ResultWrapper(){
			this.fLength = 0;
			this.fStack = new Stack<>();
		}

		public int getfLength() {
			return fLength;
		}

		public void setfLength(int fLength) {
			this.fLength = fLength;
		}

		public Stack<BinaryTree> getfStack() {
			return fStack;
		}

		public void setfStack(Stack<BinaryTree> fStack) {
			this.fStack = fStack;
		}
		
		
	}
}


