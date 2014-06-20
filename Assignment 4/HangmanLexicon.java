/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import java.io.*;
import java.util.*;

public class HangmanLexicon {

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return strList.size();
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		return strList.get(index);
	};
	
	public void run()
	{
		BufferedReader rd;
		try {
			rd = new BufferedReader(new FileReader("HangmanLexicon.txt"));
		} catch (FileNotFoundException e) {
			throw new ErrorException(e);
		}
		while (true)
		{
			String line;
			try {
				line = rd.readLine();
			} catch (IOException e) {
				throw new ErrorException(e);
			}
			if (line == null)
			{
				break;
			}
			strList.add(line);
		}
	}
	
	private ArrayList<String> strList = new ArrayList<String>();
}
