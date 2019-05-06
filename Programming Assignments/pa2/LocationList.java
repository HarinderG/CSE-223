/*
	Harinder Gakhal
	5/2/19
	CSE 223
	Programming Assignment 2 - LocationList
	This is a linked list of integers used by WordList to store occurrences of a word.
*/

public class LocationList
{
	// Head node; can change since we don't use sentinel node 
	private Node head;

	// Node class
	public class Node
	{
		private int data;
		private Node next;

		// Node constructor
		public Node(int num)
		{
			data = num;
			next = null;
		}
	}

	// addToEnd will append a location to the end of the linked list
	public void addToEnd(int num)
	{
		// Create node to append
		Node newNode = new Node(num);

		// If linked list is empty, make the head the new node
		if(head == null)
			head = newNode;
		else
		{
			// Traverse to the end of the list
			Node current = head;
			while (current.next != null)
			{
				current = current.next;
			}

			// Append to the end
			current.next = newNode;
		}
	}

	// Print function to print out the linked list
	public void print()
	{
		Node current = head;

		// While traversing the linked list, print out each location
		while (current != null)
		{
			System.out.print(" " + current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
}