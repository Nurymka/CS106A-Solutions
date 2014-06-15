/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		double x1 = getWidth() / 2 - 72;
		double y1 = getHeight() / 2 - 72;
		// outer oval
		GOval ovalOutest = new GOval(x1, y1, 144, 144);
		ovalOutest.setFilled(true);
		ovalOutest.setColor(Color.RED);
		ovalOutest.setFillColor(Color.RED);
		add(ovalOutest);
		
		// white inner oval
		double x2 = getWidth() / 2 - 46.8;
		double y2 = getHeight() / 2 - 46.8;
		GOval ovalOut = new GOval(x2, y2, 93.6, 93.6);
		ovalOut.setFilled(true);
		ovalOut.setColor(Color.white);
		ovalOut.setFillColor(Color.white);
		add(ovalOut);
		
		//inner red oval
		double x3 = getWidth() / 2 - 21.6;
		double y3 = getHeight() / 2 - 21.6;
		GOval ovalInner = new GOval(x3, y3, 43.2, 43.2);
		ovalInner.setFilled(true);
		ovalInner.setColor(Color.red);
		ovalInner.setFillColor(Color.red);
		add(ovalInner);
		
	}
}
