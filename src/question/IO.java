/********************************************************
 *
 *  Project :  Project 3 - Linked List
 *  File    :  Fox_Project3
 *  Name    :  Christa Fox
 *  Date    :  February 12, 2014(February 12, 2014)
 *
 *  Description :
 *
 *    1)	This project creates a generic singly linked list.  
 *    		It is tested with both strings and integers--both
 *    		work, but for the purpose of the assignment I chose 
 *    		to create a custom class of books that may be found,
 *    		added, removed, or displayed via a user response in
 *    		the console.
 *
 *    2)	The data structure is a singly linked list.
 *
 *    3)	It is implemented generically.
 *
 *    4)	The implemented end-user methods include the
 *    		following: add book, delete book, find book, 
 *    		and display books.  The actual type is left 
 *    		off in the prompt to increase it's purpose
 *    		(code reuse).
 *
 *  Changes :  None at this time.
 *
 ********************************************************/

package question;

import java.util.*;

public class IO {
	static int choice;
	static int userChoice;
	private static String string;
	
	/****************************************************
	 * Method     : menu
	 *
	 * Purpose    : Creates Menu.
	 *
	 * Parameters : There are three: a question(string/ words),
	 * 				the smallest acceptable number, and 
	 * 				largest acceptable number.
	 *
	 * Returns    : This method returns a number.
	 *
	 ****************************************************/	
	public static int menu(String prompt, int min, int max) {
		return promptForInt("\n" + prompt, min, max);
	}
	/****************************************************
	 * Method     : fetchIntInput
	 *
	 * Purpose    : Gets user input; asks questions.
	 *
	 * Parameters : There are three: a question(string/ words),
	 * 				the smallest acceptable number, and 
	 * 				largest acceptable number.
	 *
	 * Returns    : This method returns a number.
	 *
	 ****************************************************/	
	public static int fetchIntInput(String prompt, int min, int max) {
		Scanner input = null;
		choice = min - 1;
		try {
			System.out.println(prompt);
			System.out.print("Make your choice, but it should be between " + min
					+ " and " + max + ".\n");
			input = new Scanner(System.in);
			choice = input.nextInt();
			//input.close();
		} catch (IllegalStateException e) {
		} catch (InputMismatchException e) {
		}
		return choice;
	}

	/****************************************************
	 * Method     : promptForInt
	 *
	 * Purpose    : Gets user input; asks questions.
	 *
	 * Parameters : There are three: a question(string/ words),
	 * 				the smallest acceptable number, and 
	 * 				largest acceptable number.
	 *
	 * Returns    : This method returns a number.
	 *
	 ****************************************************/	
	public static int promptForInt(String prompt, int min, int max) {
		int userChoice = min - 1;
		while (userChoice < min || userChoice > max) {
			userChoice = IO.fetchIntInput(prompt, min, max);
			if (userChoice < min || userChoice > max) {
				System.out.println("You did not follow instructions.");
			}
		}
		return userChoice;
	}
	
	/****************************************************
	 * Method     : promptForString
	 *
	 * Purpose    : Gets user input; asks questions.
	 *
	 * Parameters : Question.
	 *
	 * Returns    : This method returns words or a string.
	 *
	 ****************************************************/	
	public static String promptForString(String prompt) {
		Scanner in = new Scanner(System.in);
		int size = 0;
		do {
			System.out.print(prompt + " ");
			setString(in.nextLine());
			size = getString().length();
			if (size <= 0) {
				System.out.println("You must enter at least one character");
			}
		} while (size <= 0);
		//in.close();
		return getString();
	}

	public static String getString() {
		return string;
	}

	public static void setString(String string) {
		IO.string = string;
	}

	public static int getChoice() {
		return choice;
	}
	
	
}

