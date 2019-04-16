/*
	Harinder Gakhal
	4/12/19
	CSE 223
	Programming Assignment 1
	This main class tests the Fraction class provided by Nicholas Macias
*/

class Main{
	  public static void main(String[] args)
	  {
	    Fraction a=new Fraction(1,2);
	    Fraction b=new Fraction(2);
	    Fraction c=new Fraction(2,3);
	    System.out.println("1/2: " + a);
	    System.out.println("2: " + b);
	    System.out.println("2/3: " + c);
	    System.out.println("Mul: 1/3 "+a.mul(c));
	    System.out.println("Mul: 1/3 "+c.mul(a));
	    System.out.println("Reduce: 1 "+b.mul(a));
	    System.out.println("Reduce: 1 "+a.mul(b));
	    System.out.println("Div: 3/4 "+a.div(c));
	    System.out.println("Div: 4/3 "+c.div(a));
	    System.out.println("Add: 7/6 "+a.add(c));
	    System.out.println("Add: 7/6 "+c.add(a));
	    System.out.println("Sub: -1/6 "+a.sub(c));
	    System.out.println("Sub: 1/6 "+c.sub(a));
	    System.out.println("x-x=0: "+c.sub(c));

	    Fraction z=new Fraction(0,1);
	    System.out.println("0: "+z);
	    System.out.println("0: "+z.mul(a));
	    System.out.println("0: "+a.mul(z));

	    System.out.println("toDouble:.6667 "+c.toDouble());

	    System.out.println("-2/3 " + new Fraction(2,-3));
	    System.out.println("-2/3 " + new Fraction(-2,3));
	    System.out.println("2/3 " + new Fraction(-2,-3));

	    Fraction q=new Fraction(-3,-12);
	    q=q.add(q.add(q.add(q)));
	    System.out.println("1=" + q);
	    q=new Fraction(-3,-12);
	    q=q.add(q.add(q.add(q.add(q))));
	    System.out.println("5/4=" + q);

	    Fraction n1=new Fraction(1,0);
	    Fraction n2=new Fraction(0,0);
	    Fraction n3=new Fraction(-20,0);
	    Fraction n4=new Fraction(24,0);
	    System.out.println("4 NaNs: " + n1 + " " + n2 + " " + n3 + " " + n4);
	    System.out.println("4 NaN toDouble: " + n1.toDouble() + " " + n2.toDouble() + " " + n3.toDouble() + " " + n4.toDouble());
	    System.out.println("4 NaNs: " + a.add(n1) + " " + a.mul(n2) + " " + n3.sub(n3) + " " + new Fraction(0,1).mul(n4));
	  }
	}