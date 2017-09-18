package com.fortinet.solutions;


public class ReverseList {

	// Your resolution 
		// Traverse through list and change links in list reverse way keeping 
		// next node in temp variable to use it next itiration
	// Time complexity: O(n) 
	// Space complexity: O(1)  
	public Node reverse(Node head){
		Node node = head;
		Node prevNode =	new Node();
		Node nextNode = new Node();
		
		while (node != null){
			nextNode = node.next;
			node.next = prevNode;
			prevNode = node;
			node = nextNode;
		}
		
		return prevNode;
	}
	// JUnit test cases 
}
