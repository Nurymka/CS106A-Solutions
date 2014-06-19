import stanford.karel.*;

public class borderKarel extends SuperKarel {
	public void run()
	{
		int count = 0;
		turnLeft();
		move();
		turnRight();
		while(frontIsClear())
		{
			if (count == 4)
			{
				break;
			}
			move();
			if (frontIsClear())
			{
				if (noBeepersPresent())
				{
					putBeeper();
				}
			}
			else
			{
				turnAround();
				move();
				turnRight();
				count++;
			}
		}
	}
}
