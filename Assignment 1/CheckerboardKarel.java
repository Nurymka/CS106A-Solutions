/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run()
	{
	putBeeper();
	while (facingEast())
	{
		beeper();
		turningLeft();
		if (frontIsClear())
		{
			beeper();
		}
		turningRight();
	}
	}
	private void beeper()
	{
	while (frontIsClear())
	{
		move();
		if (frontIsClear())
		{
			move();
			putBeeper();
		}
	}
	}
	
	private void turningLeft()
	{
		if (facingEast())
		{
			if (frontIsBlocked())
			{
				turnLeft();
			}
			if (noBeepersPresent() && frontIsClear())
			{
				move();
				turnLeft();
				putBeeper();
			}	
			else if (beepersPresent() && frontIsClear())
			{
				move();
				turnLeft();
				if(frontIsClear())
				{
				move();
				putBeeper();
				}
			}
		}
	}

	private void turningRight()
	{
		{
			if (facingWest())
			{
				if (frontIsBlocked())
				{
					turnRight();
				}
				if (noBeepersPresent() && frontIsClear())
				{
					move();
					turnRight();
					putBeeper();
				}	
				else if (beepersPresent() && frontIsClear())
				{
					move();
					turnRight();
					if(frontIsClear())
					{
					move();
					putBeeper();
					}
				}
			}
		}
	}
}
