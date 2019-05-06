/*
	Harinder Gakhal
	5/2/19
	CSE 223
	Programming Assignment 2 - WordList
	WordList is a linked list that holds a list of nodes.
		The nodes hold a word, and type LocationList and the next Node
*/

public class WordList
{	
	// First node in the list
	Node head;

	// Node class
	public class Node
	{
		String word;
		LocationList list;
		Node next;

		// Node constructor
		public Node(String w)
		{
			word = w;
			list = new LocationList();
			next = null;
		}
	}

	// addWord will add the word to the list if it does not exist, otherwise appending the location to the LoctionList of the word
	public void addWord(String word, int location)
	{
		// Build a new node and set word and LocationList
		Node newNode = new Node(word);
		newNode.list.addToEnd(location);

		// See if the word already exists in the list
		Node fNode = find(word);      // I know you can do this without find(). Currently O(2n) = O(n) [Not that bad] ---->  O(n) is possible

		// If the word already exists, append the location
		if (fNode != null)
			fNode.list.addToEnd(location);
		else
		{
			// If linked list is empty, make the head the newNode
			if(head == null)
				head = newNode;
			else
			{	
				// Current and previous for the insertion 
				Node current = head;
				Node previous = head;
				// Traverse linked list 
				while (current != null)
				{
					// See if the word should come before the next word
					if (newNode.word.compareTo(current.word) < 0)
					{
						// Prepend the word if it goes before the head
                        if (current == head && previous == head)
                        {
                            newNode.next = current;
                            head = newNode;
                        }
                        // Insert node between two nodes (Goes before current)
                        else
                        {
                            previous.next = newNode;
    						newNode.next = current;
                        }
						return;
					}
					previous = current;
					current = current.next;
				}
				previous.next = newNode;
			}
		}
	}

	// find will search the linked list for the word
	public Node find(String word)
	{
		Node current = head;

		while (current != null)
		{	
			// If word is found, return the node
			if (word.compareTo(current.word) == 0)
				return current;
			current = current.next;
		}
		return null;
	}

	// Print function to print the WordList and LocationList accordingly
	public void print()
	{
		Node current = head;

		// Traverse list
		while (current != null)
		{	
			// Print word
			System.out.print(current.word);
			// Use print method in LocationList to print list of locations
			current.list.print();
			current = current.next;
		}
		System.out.println();
	}
}