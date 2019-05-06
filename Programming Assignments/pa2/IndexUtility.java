/*
	Harinder Gakhal
	5/2/19
	CSE 223
	Programming Assignment 2 - IndexUtility
	IndexUtility takes in and cleans words from stdin - then builds an object using WordList
*/

import java.util.Scanner;

public class IndexUtility
{
	public WordList buildIndex()
	{
		// Build WordList and Scanner objects
		WordList list = new WordList();
		Scanner readIn = new Scanner(System.in);
		int count = 1;

		// Keep reading from stdin until EOF
		while (readIn.hasNext())
		{
			// Put word into string
			String next = readIn.next();
			// Covert to lowercase and remove everything but a-z
			next = next.toLowerCase().replaceAll("[^a-z ]", "");
			// Don't add empty string to list
			if (next.length() != 0)
				list.addWord(next, count++);
		}
		readIn.close();
		return list;
	}
}