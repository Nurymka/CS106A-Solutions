import acm.program.*;


public class removeDoubleLetters extends ConsoleProgram {
	public void run()
	{
		String str = readLine("Enter a string: ");
		println(removeDoubledLetters(str));
	}
	
	private String removeDoubledLetters (String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (i + 1 < str.length())
			{
				if (str.charAt(i) == str.charAt(i + 1))
				{
					str = str.substring(0, i) + str.substring(i + 1);
				}
			}
		}
		return str;
	}
}
