/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    public void run() {
		println("Welcome to Hangman!");
		String wordToGuess = wordSet.getWord(rgen.nextInt(0, wordSet.getWordCount() - 1));
		String dashedWord = toDashWord(wordToGuess);
		
		while(numGuesses != 0 || dashedWord.equals(wordToGuess))
			{
			println("The word now looks like this: " + dashedWord);
			println("You have " + numGuesses + " guesses left.");
			while(true)
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
				char ch = guessedChar.charAt(0);
				if (Character.isLowerCase(ch))
				{
					ch = Character.toUpperCase(ch);
				}
				dashedWord = checkGuessedChar(ch, wordToGuess, dashedWord);
			}
			if (dashedWord.equals(wordToGuess))
			{
				println("You guessed the word: " + wordToGuess);
				println("You win.");
			}
			else if (numGuesses == 0)
			{
				println("You're completely hung.");
				println("The word was: " + wordToGuess);
				println("You lose.");
			}
	}
    
    private String toDashWord(String word)
    {
    	String result = "";
    	for (int i = 0; i < word.length(); i++)
    	{
    		result += "-";
    	}
    	return result;
    }
    
    private String checkGuessedChar(char ch, String wordToGuess, String dashedWord)
    {
    	String result = "";
    	for (int i = 0; i < wordToGuess.length(); i++)
    	{
    		if (wordToGuess.charAt(i) == ch)
    		{
    			result = dashedWord.substring(0, i) + ch + dashedWord.substring(i + 1);
    		}
    	}
    	if (result.equals("") || result.equals(dashedWord))
    	{
    		result = dashedWord;
    		println("There are no " + ch + "'s in the word.");
    		numGuesses--;
    	}
    	else
    	{
    		println("That guess is correct");
    	}
    	return result;
    }

    private String guessedChar = "";
    private int numGuesses = 8;
    private HangmanLexicon wordSet = new HangmanLexicon();
    private RandomGenerator rgen = new RandomGenerator();
}
