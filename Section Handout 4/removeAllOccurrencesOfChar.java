import acm.program.*;

public class removeAllOccurrencesOfChar extends ConsoleProgram {
	
	public void run()
	{
		while(true)
		{
		String str = readLine("Enter a string: ");
		char ch;
		while (true)
		{
		String charforreplacing = readLine("Enter a character: ");
		
		if (charforreplacing.length() == 1)
		{
			ch = charforreplacing.charAt(0);
			break;
		}
		else
		{
			println("\"a character\" means one character!");
		}
		}
		println(removeAllOccurrences(str, ch));
		}
	}
	
	public String removeAllOccurrences(String str, char ch)
	{
		String result = "";
		for (int i = 0; i < str.length(); i++)
		{
			if (str.charAt(i) != ch)
			{
				result += str.charAt(i);
			}
		}
		return result;
	}

}
