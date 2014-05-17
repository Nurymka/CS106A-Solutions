import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {

	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			int diam = rgen.nextInt(10, 100);
			int x = rgen.nextInt(0, (getWidth() - diam));
			int y = rgen.nextInt(0, (getHeight() - diam));
			GOval oval = new GOval(x, y, diam, diam);
			int r = rgen.nextInt(0, 255);
			int g = rgen.nextInt(0, 255);
			int b = rgen.nextInt(0, 255);
			Color color = new Color(r,g,b);
			oval.setFilled(true);
			oval.setColor(color);
			oval.setFillColor(color);
			add(oval);
		}
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
