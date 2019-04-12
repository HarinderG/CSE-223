class Fraction{
	private int num, denom;

	// Constructors
	public Fraction (int n, int d)
	{
		num = n;
		denom = d;
		reduce();
	}

	public Fraction (int n)
	{
		num = n;
		denom = 1;
		reduce();
	}

	// Methods
	public Fraction add (Fraction n)
	{
		int resultN = (num * n.getDenom()) + (n.getNum() * denom);
		int resultD = denom * n.getDenom();

		return new Fraction (resultN , resultD);
	}

	public Fraction sub (Fraction n)
	{
		int resultN = (num * n.getDenom()) - (n.getNum() * denom);
		int resultD = denom * n.getDenom();

		return new Fraction (resultN , resultD);
	}

	public Fraction mul (Fraction n)
	{
		int resultN = num * n.getNum();
		int resultD = denom * n.getDenom();

		return new Fraction (resultN, resultD);
	}

	public Fraction div (Fraction n)
	{
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

	public String toString()
	{
		if (denom == 0)
			return "" + Double.NaN;
		else if (denom == 1 || num == 0)
			return "" + num;
		else
			return num + "/" + denom;
	}

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

			if (num > 0 && denom < 0)
			{
				num *= -1;
				denom *= -1;
			}
		}
	}
}