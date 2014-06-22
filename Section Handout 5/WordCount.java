import acm.program.*;
import acm.util.*;
import java.io.*;

public class WordCount extends ConsoleProgram {
	public void run()
	{
		int numLines = 0;
		int numWords = 0;
		int numChars = 0;
		while (rd == null)
		{
			try 
			{
				rd = new BufferedReader(new FileReader(readLine("File: ")));
			}
			catch(IOException ex)
			{
				println("No such file.");
			}
		}
		while (true)
		{
			String line;
			try 
			{
				line = rd.readLine();
			} 
			catch(IOException ex)
			{
				throw new ErrorException(ex);
			}
			if (line == null) break;
			numLines++;
			numChars += line.length();
			numWords += countWords(line);
		}
		try
		{
		rd.close();
		}
		catch (IOException ex)
		{
			throw new ErrorException(ex);
		}
		println("Lines: " + numLines);
		println("Words: " + numWords);
		println("Characters: " + numChars);
	}
	
	private int countWords(String line) // looked up the solution of counting words, couldn't come up with one myself
	{
		int words = 0;
		boolean inWord = false;
		for (int i = 0; i < line.length(); i++)
		{
			if (Character.isLetterOrDigit(line.charAt(i)))
			{
				inWord = true;
			}
			else
			{
				if (inWord) words++;
				inWord = false;
			}
		}
		return words;
	}
	
	private BufferedReader rd = null;
}
