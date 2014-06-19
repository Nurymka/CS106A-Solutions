import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;
import java.math.*;

public class SimpleFrogger extends GraphicsProgram {

	public static final int SQSIZE = 75; 
	public static final int NCOLS = 7; 
	public static final int NROWS = 3; 
	public static final int APPLICATION_WIDTH = SQSIZE * NCOLS;
	public static final int APPLICATION_HEIGHT = SQSIZE * NROWS;
	
	public void run()
	{
		add(frog);
		for (int i = 0; i < NROWS; i++)
		{
			GLine line = new GLine(0, i * SQSIZE, APPLICATION_WIDTH, i * SQSIZE);
			add(line);
		}
		for (int i = 0; i < NCOLS; i++)
		{
			GLine line = new GLine(i * SQSIZE, 0, i * SQSIZE, APPLICATION_HEIGHT);
			add(line);
		}
		addMouseListeners();
	}
	
	public void mouseClicked(MouseEvent e)
	{
		double frogCenterX = frog.getX() + 0.5 * SQSIZE;
		double frogCenterY = frog.getY() + 0.5 * SQSIZE;
		if (Math.abs(e.getX() - frogCenterX) - Math.abs(e.getY() - frogCenterY) > 0) // checks whether X of mouseClicked is farther away than Y of mouseClicked
		{
			if (Math.abs(e.getX() - frogCenterX) > 0.5 * SQSIZE) // checks whether X is on the same square as frog
				{
					if (e.getX() > frogCenterX) // checks whether X is on the right side
					{
						if (frogCenterX + SQSIZE < APPLICATION_WIDTH) // doesn't let the frog move out of bounds
						{
							frog.move(SQSIZE, 0);
						}
					}
					else if (e.getX() < frogCenterX) // checks whether X is on the left side
					{
						if (frogCenterX - SQSIZE >= 0)
						{
							frog.move(-SQSIZE, 0);
						}
					}
				}
		}
		
		else
		{
			if (Math.abs(e.getY() - frogCenterY) > 0.5 * SQSIZE)
			{
				if (e.getY() > frogCenterY)
				{
					if (frogCenterY + SQSIZE <= APPLICATION_HEIGHT) 
					{
						frog.move(0, SQSIZE);
					}
				}
				else if (e.getY() < frogCenterY)
				{
					if (frogCenterY - SQSIZE >= 0)
					{
						frog.move(0, -SQSIZE);
					}
				}
			}
		}
	}
	
	private GImage frog = new GImage("frog.jpg", 3 * SQSIZE, 2 * SQSIZE);
}
