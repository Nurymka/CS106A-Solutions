import acm.program.*;
import java.io.*;

public class Histogram extends ConsoleProgram {
	public void run()
	{
		for (int i = 0; i < histData.length; i++) // initializes histData
		{
			histData[i] = 0;
		}
		
		try // reads scores into the array
		{
			BufferedReader rd = new BufferedReader(new FileReader("MidtermScores.txt"));
			while (true)
			{
				String line = rd.readLine();
				if (line == null) break;
				line = line.substring(0, line.length() - 1); // to get rid of \n char
				try
				{
					int score = Integer.parseInt(line);
					histData[score / 10]++;
				}
				catch (NumberFormatException ex)
				{
					System.out.println("Got a NumberFormatException");
				}
			}
		}
		catch (IOException ex)
		{
			System.out.println("Got an I/O exception.");
		}
		
		for (int i = 0; i < 11; i++)
		{
			switch (i)
			{
			case 0:
			println("00-09: " + starVer(histData[i]));
			break;
			
			case 10:
			println("100: " + starVer(histData[i]));
			break;
			
			default:
			println(i + "0-" + i + "9: " + starVer(histData[i]));
			}
		}
	}
	
	private String starVer(int numStars) // returns a starred version
	{
		String result = "";
		for (int i = 0; i < numStars; i++)
		{
			result += "*";
		}
		return result;
	}
	
	private int[] histData = new int[11];
}
