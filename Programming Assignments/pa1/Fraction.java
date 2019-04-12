/*
	Harinder Gakhal
	4/12/19
	CSE 223
	Programming Assignment 1
	This class is designed to manage rational numebrs in fraction form.
*/

class Fraction{
	private int num, denom;

	// Constructors
	public Fraction (int n, int d)
	{	
		// Will set the values of num and denom and reduce if necessary
		num = n;
		denom = d;
		reduce();
	}

	public Fraction (int n)
	{
		// If no denominator is given, set it to 1
		num = n;
		denom = 1;
		reduce();
	}

	// Methods
	public Fraction add (Fraction n)
	{
		// Find common denominator (Does not have to be LCD since the fractin will be reduced later)
		int resultN = (num * n.getDenom()) + (n.getNum() * denom);
		int resultD = denom * n.getDenom();

		return new Fraction (resultN , resultD);
	}

	public Fraction sub (Fraction n)
	{
		// Find common denominator then subtract
		int resultN = (num * n.getDenom()) - (n.getNum() * denom);
		int resultD = denom * n.getDenom();

		return new Fraction (resultN , resultD);
	}

	public Fraction mul (Fraction n)
	{
		// Multiply across
		int resultN = num * n.getNum();
		int resultD = denom * n.getDenom();

		return new Fraction (resultN, resultD);
	}

	public Fraction div (Fraction n)
	{
		// Multiply the reciprocal
		int resultN = num * n.getDenom();
		int resultD = denom * n.getNum();

		return new Fraction(resultN, resultD);
	}

	// Getters
	public int getNum()
	{
		return num;
	}

	public int getDenom()
	{
		return denom;
	}

	// Override default toString() to print out in the correct format
	public String toString()
	{
		if (denom == 0)
			return "" + Double.NaN;
		else if (denom == 1 || num == 0)
			return "" + num;
		else
			return num + "/" + denom;
	}

	// Return floating point version of the fraction
	public double toDouble()
	{
		if (denom == 0)
			return Double.NaN;
		else
			return (double) num/denom;
	}

	private void reduce()
	{
		// Skip if divide by 0
		if (denom != 0)
		{
			// Euclidean algorithm
			int a = num;
			int b = denom;
			int c = a%b;

			while(c != 0)
			{
				a = b;
				b = c;
				c = a%b;
			}

			num /= b;
			denom /= b;

			// Flips the negatives. e.g 1/-2 to -1/2
			if (num > 0 && denom < 0)
			{
				num *= -1;
				denom *= -1;
			}
		}
	}
}