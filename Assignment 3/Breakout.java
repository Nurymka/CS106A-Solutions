/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

	/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 500;
	public static final int APPLICATION_HEIGHT = 750;

	/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 75;
	private static final double PADDLE_HEIGHT = 12.5;

	/** Offset of the paddle up from the bottom (distance from bottom of the paddle to the bottom of the window) */
	private static final double PADDLE_Y_OFFSET = 37.5;

	/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

	/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

	/** Separation between bricks */
	private static final int BRICK_SEP = 5;

	/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

	/** Height of a brick */
	private static final int BRICK_HEIGHT = 10;

	/** Radius of the ball in pixels */
	private static final double BALL_RADIUS = 12.5;

	/** Offset of the top brick row from the top */
	private static final double BRICK_Y_OFFSET = 87.5;

	/** Number of turns */
	private static final int NTURNS = 3;

	/** Sets up the Breakout program. */
	public void init() {
		setUpBricks(); 
		createPaddle();
		createBall();
		setLabels();
		lives = NTURNS;
		setVelocity(); // sets initial moving speed of the ball
		addMouseListeners();
	}
	/* Method: run() */
	/** Runs the Breakout program. */
	public void run() {
		addMouseListeners();
		while (lives != 0)
		{
			ball.move(vx, vy);
			checkForCollisions();
			scoreLabel.setLabel("Score: " + score + "");
			livesLabel.setLabel("Lives: " + lives + "");
			checkIfDied();
			pause(7);
			if (score == NBRICK_ROWS * NBRICKS_PER_ROW) // when score is equal to the number of all of the bricks, stop executing the code
			{
				break;
			}
		}
		if (lives == 0) // losing case
		{
			removeAll();
			gameOver();
			scoreLabel.setFont("Helvetica-36");
			scoreLabel.setLocation((WIDTH - scoreLabel.getWidth()) / 2, (HEIGHT - scoreLabel.getAscent()) / 2 + 50);
			add(scoreLabel);
		}
		if (lives != 0) // winning case
		{
		removeAll();
		gameOver();
		gameOver.setLabel("YOU WON! GO AND HAVE A DRINK!");
		gameOver.setFont("Helvetica-20");
		gameOver.setLocation((WIDTH - gameOver.getWidth()) / 2, (HEIGHT - gameOver.getAscent()) / 2); // locating on the center
		add(gameOver);
		winClip.play();
		}
	}
	
	public void mouseMoved(MouseEvent e)
	{
		if ((WIDTH - e.getX()) > PADDLE_WIDTH) // checks, whether the paddle didn't go off the screen
		{
		paddle.setLocation(e.getX(), HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET); // moves the paddle
		}
	}

	private void setUpBricks()
	{
		for (int i = 0; i < NBRICK_ROWS; i++) // a row per step
		{
			for (int j = 0; j < NBRICKS_PER_ROW; j++) // a brick in one row per step
			{
				double x = ((WIDTH/2 - (NBRICKS_PER_ROW / 2) * BRICK_WIDTH - (NBRICKS_PER_ROW/2) * BRICK_SEP) + (BRICK_SEP / 2)) + (j * (BRICK_WIDTH + BRICK_SEP)); // an initial coordinate of the first brick + distance between bricks * number of bricks
				double y = BRICK_Y_OFFSET + (i * (BRICK_HEIGHT + BRICK_SEP));
				GRect rect = new GRect (x, y, BRICK_WIDTH, BRICK_HEIGHT);
				rect.setFilled(true);
				
				if (i <= 1) // setting colors of bricks
				{
					rect.setColor(Color.RED);
					rect.setFillColor(Color.RED);
				}
				else if (i <= 3)
				{
					rect.setColor(Color.ORANGE);
					rect.setFillColor(Color.ORANGE);
				}
				else if (i <= 5)
				{
					rect.setColor(Color.YELLOW);
					rect.setFillColor(Color.YELLOW);
				}
				else if (i <= 7)
				{
					rect.setColor(Color.GREEN);
					rect.setFillColor(Color.GREEN);
				}
				else if (i <= 9)
				{
					rect.setColor(Color.CYAN);
					rect.setFillColor(Color.CYAN);
				}
				
				add(rect);
			}	
		}
	}
	private void createPaddle()
	{
		paddle = new GRect((WIDTH - PADDLE_WIDTH)/2, HEIGHT - PADDLE_HEIGHT - PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		add(paddle);
	}
	private void createBall()
	{
		ball = new GOval (WIDTH/2 - BALL_RADIUS, HEIGHT/2 - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFilled(true);
		ball.sendToBack();
		add(ball);
	}
	private void checkForCollisions()
	{
		if (WIDTH - ball.getX() < BALL_RADIUS * 2 || ball.getX() < 0) // checks the collisions of walls on the right and left
		{
			vx = -vx;
			bounceClip.play();
			
		}
		else if (ball.getY() < 0) // checks the collisions on the upper wall only
		{
			vy = -vy;
			bounceClip.play();
		}
		
		
		// checks the collisions of the ball with other objects from four corners
		if (getElementAt(ball.getX(), ball.getY()) != null)  // upper left corner
		{
			collider = getElementAt(ball.getX(), ball.getY());
		}
		else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY()) != null) // upper right corner
		{
			collider = getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY());
		}
		else if (getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2) != null) // lower left corner
		{
			collider = getElementAt(ball.getX(), ball.getY() + BALL_RADIUS * 2);
		}
		else if (getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2) != null) // lower right corner
		{
			collider = getElementAt(ball.getX() + BALL_RADIUS * 2, ball.getY() + BALL_RADIUS * 2);
		}
		
		if (collider == paddle) 
		{
			if(ball.getY() < HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT - BALL_RADIUS*2 + 4) // used the trick from NatashaTheRobot to avoid the ball gluing into the paddle, but still happens
			{
				vy = -vy;
				bounceClip.play();
			}
			collider = null; // cleans up the collider object so that if won't be true everytime
		}

		if (collider != paddle && collider != null && collider != scoreLabel && collider != livesLabel) // anything other than labels, paddle and null has to be a brick
		{
			vy = -vy;
			bounceClip.play();
			score++; // +1 score for a brick
			remove(collider);
			collider = null; // cleans up the collider object so that if won't be true everytime
		}
		
		
	}
	private void setLabels()
	{
		scoreLabel = new GLabel("", 50, 50);
		scoreLabel.setFont("TimesNewRoman-20");
		add(scoreLabel);
		
		livesLabel = new GLabel("", WIDTH - 100, 50);
		livesLabel.setFont("TimesNewRoman-20");
		add(livesLabel);
			
	}
	private void setVelocity()
	{
		vy = 3; 
		vx = rgen.nextDouble(1.0, 3.0); // random number between 2.0-3.0, so that the initial starting x velocity won't be the same everytime 
		if(rgen.nextBoolean(0.5)) // positive velocity only 50% of the time
		{
			vx = -vx;
		}
	}
	private void checkIfDied()

	{
		if (ball.getY() > HEIGHT) // if y coordinate of ball went off the screen
		{
			lives--;
			createBall();
			setVelocity();
		}
	}
	private void gameOver()
	{
		gameOver = new GLabel("GAME OVER!");
		gameOver.setFont("Helvetica-36");
		gameOver.setLocation((WIDTH - gameOver.getWidth()) / 2, (HEIGHT - gameOver.getAscent()) / 2);
		add(gameOver);
	}
	
	
	private GRect paddle;
	private GOval ball;
	private static double vx, vy;
	private static int score;
	private static int lives;
	private GObject collider;
	private GLabel scoreLabel;
	private GLabel livesLabel;
	private GLabel gameOver;
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");
	private AudioClip winClip = MediaTools.loadAudioClip("danza_india_km.au");
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
