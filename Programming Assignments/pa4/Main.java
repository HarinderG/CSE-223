/*
	Harinder Gakhal
	5/30/19
	CSE 223
	Programming Assignment 4 - Main
	This is the main class for pa4.
	Pa4 is a '20Questions game'.
	It will use default.txt as the starting database, unless otherwise specified.
	If the game does not find what the user is thinking of, it will ask the
	player what they were thinking of, and then update the database.
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class Main
{
	public static void main (String[] args)
	{
		// Create a new scanner object using the default or custom file
		String fileName = "default.txt";
		File f;
		if(args.length == 1)
			fileName = args[0];
		try
		{
			f = new File(fileName);
		}
		catch (Exception e)
		{
		    System.out.println("Couldn't open file: " + e);
		    return;
		}

		Tree tree = new Tree(f); // Will build the decision tree using the file
		Scanner sc = new Scanner(System.in); // Scanner to read in keyboard inputs
		String readIn, newQuestion, newAns; // Keyboard input string, and new question/answers
		boolean isDone = false; // Flag to close game

		System.out.println("Welcome! Please think of something, and I will try to guess.");
		tree.next("f"); // Will initialize pointer int tree
		while(!isDone)
		{
			if(tree.getPointerNode().type == 'a')
			{
				System.out.println("I think I've got it... ");
				System.out.println("Are you thinking of [" + tree.getPointerNode().data + "] ?");
			}
			else
				System.out.println(tree.getPointerNode().data);

			readIn = sc.nextLine();
			while(!isValid(readIn)) // Check to see if keyboard input is y or n
			{
				System.out.println("Please type y or n.");
				readIn = sc.nextLine();
			}

			// If correct answer is found, end game
			if(readIn.equals("y") && tree.getPointerNode().type == 'a')
			{
				System.out.println("That was too easy!");
				isDone = true;
			}
			// Otherwise add it to the tree
			else if (readIn.equals("n") && tree.getPointerNode().type == 'a')
			{
				System.out.println("Darn! What were you thinking of?");
				newAns = sc.nextLine();
				System.out.println("What is a question that you can answer yes to?");
				newQuestion = sc.nextLine();
				tree.insert(newQuestion, newAns);
				System.out.println("Thanks for playing!");
				isDone = true;
			}

			// Increments the pointer in tree
			tree.next(readIn);
		}

		// Create print writer object
		PrintWriter pw;
		try
		{
			pw = new PrintWriter(fileName);
		}
		catch (Exception e)
		{
		    System.out.println("Couldn't open file: " + e);
		    return;
		}

		// Use toString function in tree class to write out to file
		pw.print(tree);
		pw.print("\b ");

		// Close scanner and printWrtier files
		sc.close();
		pw.close();
	}

	// Method to check if keyboard input string is y or n 
	public static boolean isValid(String s)
	{
		if (!s.toLowerCase().equals("y") && !s.toLowerCase().equals("n"))
			return false;
		else
			return true;
	}
}