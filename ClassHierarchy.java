import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ClassHierarchy extends GraphicsProgram {
	
	// width of the class box
	private static final int WIDTH_BOX = 200;
	// height of the class box
	private static final int HEIGHT_BOX = 40;
	// interval between boxes
	private static final int OFFSET_BETWEEN = 50;
	// interval between center and the top box
	private static final int OFFSET_TOP = 70;
	public void run()
	{
		GRect rectleft = new GRect ((getWidth() / 2) - OFFSET_BETWEEN - WIDTH_BOX - (WIDTH_BOX / 2), getHeight() / 2 - (HEIGHT_BOX / 2), WIDTH_BOX, HEIGHT_BOX);
		add(rectleft);
		
		GRect rectcenter = new GRect ((getWidth() / 2) - (WIDTH_BOX / 2), getHeight() / 2 - (HEIGHT_BOX / 2), WIDTH_BOX, HEIGHT_BOX);
		add(rectcenter);
		
		GRect rectright = new GRect (getWidth() / 2 + OFFSET_BETWEEN + (WIDTH_BOX / 2), getHeight() / 2 - (HEIGHT_BOX / 2), WIDTH_BOX, HEIGHT_BOX);
		add(rectright);
		
		GRect recttop = new GRect ((getWidth() / 2) - (WIDTH_BOX / 2), getHeight()/2 - OFFSET_TOP - HEIGHT_BOX, WIDTH_BOX, HEIGHT_BOX);
		add(recttop);
		
		GLine lineleft = new GLine ((getWidth() / 2) - OFFSET_BETWEEN - WIDTH_BOX, getHeight() / 2 - (HEIGHT_BOX / 2), getWidth() / 2, getHeight() / 2 - OFFSET_TOP);
		add(lineleft);
		
		GLine linecenter = new GLine (getWidth() / 2, getHeight() / 2 - HEIGHT_BOX / 2, getWidth() / 2, getHeight() / 2 - OFFSET_TOP);
		add(linecenter);
		
		GLine lineright = new GLine (getWidth() / 2 + OFFSET_BETWEEN + WIDTH_BOX, getHeight() / 2 - HEIGHT_BOX / 2, getWidth() / 2, getHeight() / 2 - OFFSET_TOP);
		add(lineright);
		
		GLabel labelleft = new GLabel ("GraphicsProgram");
		labelleft.setLocation ((getWidth() / 2) - OFFSET_BETWEEN - WIDTH_BOX - labelleft.getWidth() / 2, getHeight() / 2 + labelleft.getAscent() / 2);
		add(labelleft);
		
		GLabel labelcenter= new GLabel ("ConsoleProgram");
		labelcenter.setLocation ((getWidth() / 2) - labelcenter.getWidth() / 2, getHeight() / 2 + labelcenter.getAscent() / 2);
		add(labelcenter);
		
		GLabel labelright = new GLabel ("DialogProgram");
		labelright.setLocation ((getWidth() / 2) + OFFSET_BETWEEN + WIDTH_BOX - labelright.getWidth() / 2, getHeight() / 2 + labelright.getAscent() / 2);
		add(labelright);
		
		GLabel labeltop = new GLabel ("Program");
		// i don't get the y coordinate of the labeltop, probably something wrong with it
		labeltop.setLocation(getWidth() / 2 - labeltop.getWidth() / 2, (getHeight() / 2) - (HEIGHT_BOX / 2) - OFFSET_TOP + labelright.getAscent() / 2);
		add(labeltop);
	}
}
