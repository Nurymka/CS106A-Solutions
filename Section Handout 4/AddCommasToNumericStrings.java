import acm.program.*;

public class AddCommasToNumericStrings extends ConsoleProgram {
	public void run()
	{
		while (true)
		{
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
		}
	}
	
	private String addCommasToNumericString(String digits)
	{
		String result = "";
		int countthree = 0;
		if (digits.length() <= 3) return digits;
		for (int i = digits.length() - 1; i > -1; i--)
		{
			if (countthree > 0 && countthree % 3 == 0)
			{
				result = ',' + result;
			}
			result = digits.charAt(i) + result;
			countthree++;
		}
		return result;

	}
}
