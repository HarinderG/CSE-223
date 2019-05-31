/*
  Harinder Gakhal
  5/30/19
  CSE 223
  Programming Assignment 4 - Tree
  Tree class used by the main class.
  Includes node class to hold the string data, node type (question or answer) and left/right nodes
  Build method will take a file (in the correct format) and build a tree
*/

import java.util.Scanner;
import java.io.File;

class Tree
{
  private Node root, pointerNode; // root node, and pointerNode to keep track where the player is
  private String printOut; // Final string that gets sent to toString()

  // If file is given, use it it to build the tree
  public Tree(File f)
  {
    build(f);
  }
  public Tree(){} // Do nothing otherwise

  // Node class
  class Node
  { 
    String data; // Holds the question or answer
    char type; // Node type: q = question, a = answer
    Node left,right; // Children nodes

    public Node(String s, char t)
    {
      data = s;
      type = t;
      left = right = null;
    }
  }

  // Use file f to build tree
  public void build (File f)
  {
    Scanner sc;
    String line;
    char type = 'x';

    // If file is not found, let user know
    try
    {
      sc = new Scanner(f);
    }
    catch (Exception e)
    {
      System.out.println("Couldn't open file: " + e);
      return;
    }

    // Line by line, send the string and node type to buildHelper
    while(sc.hasNextLine())
    {
      line = sc.nextLine();

      if (line.equals("Q:"))
        type = 'q';
      else if (line.equals("A:"))
        type = 'a';
      else
      {
        if(root == null) // If
          root = new Node(line, type);
        else
          buildHelper(root, new Node(line, type));
      }
    }
  }

  // Recursively traverse and add the node to the tree (NLR pattern)
  private boolean buildHelper(Node current, Node newNode)
  {
    // If there is something in the left node, traverse down to the left
    if(current.type == 'q' && current.left != null && buildHelper(current.left, newNode) == true)
      return true;
    // If there is nothing on the left, insert node
    else if(current.type == 'q' && current.left == null)
    {
      current.left = newNode;
      return true;
    }

    // If there is something in the right node, traverse down to the right
    if(current.type == 'q' && current.right != null && buildHelper(current.right, newNode) == true)
      return true;
    // If there is nothing on the right, insert node
    else if(current.type == 'q' && current.right == null)
    {
      current.right = newNode;
      return true;
    }

    // If node is an answer, go back up a node
    if (current.type == 'a')
      return false;

    return false;
  }

  // Update tree to include new question and answer
  public void insert(String question, String answer)
  {
    pointerNode.left = new Node(answer, 'a');
    pointerNode.right = new Node(pointerNode.data, 'a');
    pointerNode.data = question;
    pointerNode.type = 'q';
  }

  // Updates pointer to the next node (if yes go left otherwise go right)
  public Node next(String s)
  {
    // f (first time) inits the pointer to root
    if(s.equals("f"))
      pointerNode = root;
    else
    {
      if(s.equals("y"))
        pointerNode = pointerNode.left;
      else if (s.equals("n"))
        pointerNode = pointerNode.right;
    }
    return pointerNode;
  }

  // Getter method of pointerNode
  public Node getPointerNode()
  {
    return pointerNode;
  }

  // Prints tree in preorder format with Q: or A:
  private void print(Node current)
  {
    if (current == null)
      return;
    if(current.type == 'q')
      printOut += "Q:\r\n";
    else
      printOut += "A:\r\n";
    printOut += current.data + "\r\n";
    print(current.left);
    print(current.right);
  }

  // Calls print() function to print tree in preorder format
  public String toString()
  {
    printOut = ""; // Reset printOut
    print(root);
    return printOut;
  }
}