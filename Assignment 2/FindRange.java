/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int SENTINEL = 0;
	
	public void run() {
		println("This program finds the largest and smallest numbers.");
		int i = readInt ("? ");
		if (i == SENTINEL)
		{
			println("You didn't enter any values");
		}
		else
		{
			int small = i;
			int large = i;
			while (i != SENTINEL)
			{
			i = readInt ("? ");
				if (i != SENTINEL)
				{
					if (i < small)
					{
						small = i;
					}
					if (i > large)
					{
						large = i;
					}
				}
			}
			if (i == SENTINEL)
			{
				println("smallest: " + small);
				println("largest: " + large);
			}
		}
}
}

