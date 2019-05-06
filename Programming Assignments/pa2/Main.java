/*
	Harinder Gakhal
	5/2/19
	CSE 223
	Programming Assignment 2 - Main
	This is the main class to set up and print a WordList from stdin
*/

public class Main
{
	public static void main(String[] args)
	{
		IndexUtility myIU = new IndexUtility();
		WordList myList = myIU.buildIndex();
		myList.print();
	}
}