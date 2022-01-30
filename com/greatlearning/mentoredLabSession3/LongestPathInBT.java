package com.greatlearning.mentoredLabSession3;

import java.util.ArrayList;

public class LongestPathInBT {
	
	static class Node {
		Node leftNode;
		Node rightNode;
		int data;
	}

	public static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}
	//Driver Code
	public static void main(String[] args) {
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);

		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);

		root.rightNode.leftNode = newNode(110);
		root.rightNode.rightNode = newNode(140);

		root.leftNode.leftNode.leftNode = newNode(5);

		ArrayList<Integer> longestPath = findLongestPath(root);
		int size = longestPath.size();
		System.out.print("Longest Path: ");
		System.out.print(longestPath.get(size-1));
		for(int i=size-2;i>=0;i--) {
			System.out.print(" -> "+longestPath.get(i));
		}
	}

	public static ArrayList<Integer> findLongestPath(Node root) {
		   //If root is null then there is no binary tree so return empty.
		if (root == null)
			return new ArrayList<Integer>();		

		ArrayList<Integer> leftNodeList = findLongestPath(root.leftNode);
		ArrayList<Integer> rightNodeList = findLongestPath(root.rightNode);
       
		    // Compares the size of two ArrayList and insert the current node accordingly 
		if (rightNodeList.size() < leftNodeList.size())
			leftNodeList.add(root.data);
		else
			rightNodeList.add(root.data);
            // Returns the appropriate ArrayList
		return (leftNodeList.size() > rightNodeList.size() ? leftNodeList : rightNodeList);
	}

}
