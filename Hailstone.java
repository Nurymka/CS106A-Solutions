/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int i = readInt("Enter a number: ");
		int count = 0;
		while (i != 1)
		{
			if (i % 2 == 0)
			{
				println(i + " is even, so I take half: " + (i = i/2));
				count++;
			}
			else if (i % 2 == 1)
			{
				println(i + " is odd, so I take 3n + 1: " + (i = 3*i+1));
				count++;
			}
		}
		println ("The process took " + count + " to reach 1");
	}
}

