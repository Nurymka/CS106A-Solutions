import acm.program.*;

public class SecondLargest extends ConsoleProgram {
	private final static int SENTINEL = 0;
	
	public void run()
	{
		println("This program finds the two largest integers in a list. \nEnter values, one per line, using a 0 to signal the end of the list.");
		int largest = 0;
		int secondLargest = 0;
		int input;
		int timesBeforeSen = 0;
		while (true)
		{
			input = readInt(" ? ");
			if (input == SENTINEL && timesBeforeSen < 2)
			{
				println("You should enter at least two values before entering 0.");
			}
			else if (input == SENTINEL && timesBeforeSen >= 2)
			{
				break;
			}
			if (input != SENTINEL)
			{
				timesBeforeSen++;
				if (largest >= input && input > secondLargest)
				{
					secondLargest = input;
				}
				if (input > largest)
				{
					largest = input;
				}
			}
		}
		println ("The largest value is " + largest);
		println ("The second largest value is " + secondLargest);
	}

}
