import stanford.karel.SuperKarel;

public class defendDemocracyKarel extends SuperKarel
{
	public void run()
		{
			while (frontIsClear())
			{
				move();
				check();
				move();
			}	
		}
// checks the ballot for existence of beepers	
	private void check()
	{
		if (beepersPresent())
		{
			turnLeft();
			move();
			if (beepersPresent())
			{
				turnAround();
				move();
				move();
				if (beepersPresent())
				{
					turnAround();
					move();
					turnRight();
				}
				// if no beeper at south, cleans up north and center
				else
				{
					turnAround();
					move();
					while (beepersPresent())
					{
						pickBeeper();
					}	
					move();
					while (beepersPresent())
					{
						pickBeeper();
					}
					turnAround();
					move();
					turnLeft();
				}	
			}
			// if no beepers at north, cleans the center and south
			else
			{
				turnAround();
				move();
				while (beepersPresent())
				{
					pickBeeper();
				}
				move();
				while (beepersPresent())
				{
					pickBeeper();
				}
				turnAround();
				move();
				turnRight();
			}
		}
// if there's no center beeper, checks north and south and cleans up them
		else
		{
			turnLeft();
			move();
			while (beepersPresent())
			{
				pickBeeper();
			}
			turnAround();
			move();
			move();
			while (beepersPresent())
			{
				pickBeeper();
			}
			turnAround();
			move();
			turnRight();
		}	
	}
}
