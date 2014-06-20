/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.program.*;
import acm.util.*;


public class Hangman extends ConsoleProgram {

	public void init()
	{
	canvas = new HangmanCanvas();
	add(canvas);
	wordSet.run();
	}
	
    public void run() {
		println("Welcome to Hangman!");
		String wordToGuess = wordSet.getWord(rgen.nextInt(0, wordSet.getWordCount() - 1)); // getting a random word from HangmanLexicon
		String dashedWord = toDashWord(wordToGuess); // getting a dashed version of the word
		canvas.reset();
		while(numGuesses != 0) // until the player loses or wins
			{
			println("The word now looks like this: " + dashedWord);
			canvas.displayWord(dashedWord);
			println("You have " + numGuesses + " guesses left.");
			
			while(true) // requests a letter from a player and checks whether it's a letter and only one letter, shows an error if not and requests again.
			{
				guessedChar = readLine("Your guess: ");
				if (guessedChar.length() == 1 && Character.isLetter(guessedChar.charAt(0))) 
				{	
					break;
				}
				else
				{
					println("You should enter one letter.");
				}
			}
			
				char ch = guessedChar.charAt(0); // converts the given string to a char
				if (Character.isLowerCase(ch)) // converts a char into a uppercase if entered as lowercase
				{
					ch = Character.toUpperCase(ch);
				}
				dashedWord = checkGuessedChar(ch, wordToGuess, dashedWord); // updates the dashed word with a letter if guessed correctly, and returns the same dashedWord if not. Also decreases numGuesses if not a letter is an incorrect guess.
				if (dashedWord.equals(wordToGuess))
				{
					canvas.displayWord(dashedWord); // if not added, last guessed letter wouldn't be shown on the canvas
					break;
				}
			}
		
			if (dashedWord.equals(wordToGuess)) // prints if won
			{
				println("You guessed the word: " + wordToGuess);
				println("You win.");
				canvas.youWin();
			}
			else if (numGuesses == 0) // prints if lost
			{
				println("You're completely hung.");
				println("The word was: " + wordToGuess);
				println("You lose.");
			}
	}
    
    private String toDashWord(String word) // gives the dashed version of the word
    {
    	String result = "";
    	for (int i = 0; i < word.length(); i++)
    	{
    		result += "-";
    	}
    	return result;
    }
    
    private String checkGuessedChar(char ch, String wordToGuess, String dashedWord) // updates the dashed word with a letter if guessed correctly, and returns the same dashedWord if not. Also decreases numGuesses if not a letter is an incorrect guess.
    {
    	String result = dashedWord;
    	for (int i = 0; i < wordToGuess.length(); i++) // changes the result if a letter is correctly guessed
    	{
    		if (wordToGuess.charAt(i) == ch)
    		{
    			result = result.substring(0, i) + ch + result.substring(i + 1);
    		}
    	}
    	if (result.equals("") || result.equals(dashedWord)) // if result remained unchanged ("" maybe when guessing the first letter, dashedWord on any other attempt), that means the guess was incorrect
    	{
    		result = dashedWord;
    		println("There are no " + ch + "'s in the word.");
    		canvas.noteIncorrectGuess(ch);
    		numGuesses--;
    	}
    	else
    	{
    		println("That guess is correct."); // if result changed, that means guess is correct
    	}
    	return result;
    }

    private String guessedChar = ""; // string entered by user
    private int numGuesses = 8; // number of guesses
    private HangmanLexicon wordSet = new HangmanLexicon();
    private RandomGenerator rgen = new RandomGenerator();
    private HangmanCanvas canvas;
}
