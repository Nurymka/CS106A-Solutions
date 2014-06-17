/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.util.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
		scaffold = new GLine(SCAFFOLD_X, SCAFFOLD_Y, SCAFFOLD_X, SCAFFOLD_Y - SCAFFOLD_HEIGHT);
		add(scaffold);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		remove(wordBeingGuessed);
		wordBeingGuessed = new GLabel(word, 50, getHeight() - 40);
		wordBeingGuessed.setFont("Helvetica-24");
		add(wordBeingGuessed);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		remove(guessedChars);
		wrongChars += letter;
		guessedChars = new GLabel(wrongChars, 50, getHeight() - 20);
		guessedChars.setFont("Helvetica-20");
		add(guessedChars);
		System.out.println(wrongChars.length());
		switch(wrongChars.length())
		{
		case 1:
			beam = new GLine(SCAFFOLD_X, SCAFFOLD_Y - SCAFFOLD_HEIGHT, SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT);
			rope = new GLine(SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT, SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH);
			head = new GOval(SCAFFOLD_X + BEAM_LENGTH - HEAD_RADIUS, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH, HEAD_RADIUS * 2, HEAD_RADIUS * 2);
			add(beam);
			add(rope);
			add(head);
			break;
		case 2:
			body = new GLine(SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2, SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH);
			add(body);
			break;
		case 3:
			leftUpperArm = new GLine(SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD, SCAFFOLD_X + BEAM_LENGTH - UPPER_ARM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD);
			leftLowerArm = new GLine(SCAFFOLD_X + BEAM_LENGTH - UPPER_ARM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD, SCAFFOLD_X + BEAM_LENGTH - UPPER_ARM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
			add(leftUpperArm);
			add(leftLowerArm);
			break;
		case 4:
			rightUpperArm = new GLine(SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD, SCAFFOLD_X + BEAM_LENGTH + UPPER_ARM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD);
			rightLowerArm = new GLine(SCAFFOLD_X + BEAM_LENGTH + UPPER_ARM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD, SCAFFOLD_X + BEAM_LENGTH + UPPER_ARM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + HEAD_RADIUS * 2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH);
			add(rightUpperArm);
			add(rightLowerArm);
			break;
		case 5:
			leftHip = new GLine(SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH, SCAFFOLD_X + BEAM_LENGTH - HIP_WIDTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH);
			leftLeg = new GLine(SCAFFOLD_X + BEAM_LENGTH - HIP_WIDTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH, SCAFFOLD_X + BEAM_LENGTH - HIP_WIDTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH);
			add(leftHip);
			add(leftLeg);
			break;
		case 6:
			rightHip = new GLine(SCAFFOLD_X + BEAM_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH, SCAFFOLD_X + BEAM_LENGTH + HIP_WIDTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH);
			rightLeg = new GLine(SCAFFOLD_X + BEAM_LENGTH + HIP_WIDTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH, SCAFFOLD_X + BEAM_LENGTH + HIP_WIDTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH);
			add(rightHip);
			add(rightLeg);
			break;
		case 7:
			leftFoot = new GLine(SCAFFOLD_X + BEAM_LENGTH - HIP_WIDTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH, SCAFFOLD_X + BEAM_LENGTH - HIP_WIDTH - FOOT_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH);
			add(leftFoot);
			break;
		case 8:
			rightFoot = new GLine(SCAFFOLD_X + BEAM_LENGTH + HIP_WIDTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH, SCAFFOLD_X + BEAM_LENGTH + HIP_WIDTH + FOOT_LENGTH, SCAFFOLD_Y - SCAFFOLD_HEIGHT + ROPE_LENGTH + BODY_LENGTH + LEG_LENGTH);
			youLose.setFont("Helvetica-36");
			youLose.setLocation(getWidth() / 2 - youLose.getWidth() / 2, (getHeight() - youLose.getAscent()) / 2);
			youLose.setColor(Color.RED);
			add(rightFoot);
			add(youLose);
			break;
		}
		
	}
	
	public void youWin()
	{
		removeAll();
		youWin.setFont("Helvetica-36");
		youWin.setLocation(getWidth() / 2 - youWin.getWidth() / 2, (getHeight() - youWin.getAscent()) / 2);
		while (true)
		{
		youWin.setColor(rgen.nextColor());
		this.setBackground(rgen.nextColor());
		add(youWin);
		}
	}
	
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;
	private static final int SCAFFOLD_X = 70;
	private static final int SCAFFOLD_Y = 390;
	
	private GLine scaffold;
	private GLine beam;
	private GLine rope;
	private GOval head;
	private GLine body;
	private GLine rightUpperArm;
	private GLine rightLowerArm;
	private GLine leftUpperArm;
	private GLine leftLowerArm;
	private GLine rightHip;
	private GLine leftHip;
	private GLine rightLeg;
	private GLine leftLeg;
	private GLine rightFoot;
	private GLine leftFoot;
	private GLabel wordBeingGuessed = new GLabel("");
	private GLabel guessedChars = new GLabel("");
	private GLabel youWin = new GLabel("YOU WIN!");
	private GLabel youLose = new GLabel("You lose.");
	private String wrongChars = "";
	private RandomGenerator rgen = new RandomGenerator();
}
