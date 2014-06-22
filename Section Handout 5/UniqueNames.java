import acm.program.*;
import java.util.*;

public class UniqueNames extends ConsoleProgram {
	public void run()
	{
		while (true)
		{
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			if (!nameList.contains(name)) nameList.add(name);
		}
		
		println("Unique name list contains:");
		for (int i = 0; i < nameList.size(); i++)
		{
			println(nameList.get(i));
		}
	}
	
	private ArrayList<String> nameList = new ArrayList<String>();
}
