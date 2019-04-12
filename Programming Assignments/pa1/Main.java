class Main{
	public static void main(String[] args)
	{
		int num =  1;
		int denom = 2;
		Fraction a = new Fraction(-2, -4);
		Fraction b = new Fraction(1, 4);

		Fraction sum = a.div(b);

		double dNum = a.toDouble();

		System.out.println(dNum);
	}
}