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

package app;

public class Book 
{
	/**
	 * Fields to store book information
	 */
	private String title;
	private String author;

	/****************************************************
	 * Method     : Book Constructor
	 *
	 * Purpose    : Instantiates a book.
	 *
	 * Parameters : A title and author of type String.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public Book(String t, String a)
	{
		setTitle(t);
		setAuthor(a);
	}

	/****************************************************
	 * Method     : getTitle
	 *
	 * Purpose    : To expose the private field of title.
	 *
	 * Parameters : None
	 *
	 * Returns    : A title of type String.
	 *
	 ****************************************************/
	public String getTitle() 
	{
		return title;
	}

	/****************************************************
	 * Method     : setTitle
	 *
	 * Purpose    : Sets the private field of title.
	 *
	 * Parameters : A title of type String.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public void setTitle(String title) 
	{
		this.title = title;
	}

	/****************************************************
	 * Method     : getAuthor
	 *
	 * Purpose    : To expose the private field of author.
	 *
	 * Parameters : None
	 *
	 * Returns    : An author of type String.
	 *
	 ****************************************************/
	public String getAuthor() 
	{
		return author;
	}

	/****************************************************
	 * Method     : setAuthor
	 *
	 * Purpose    : Sets the private field of author.
	 *
	 * Parameters : An author of type String.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
	/****************************************************
	 * Method     : (overridden) toString
	 *
	 * Purpose    : This prints the Book object in a <title> 
	 * 				by <author> format.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method returns a specified string 
	 * 				that can be called on the class.
	 *
	 ****************************************************/
	@Override
	public String toString()
	{
		return String.format("%s by %s", getTitle(), getAuthor());
	}
	
}
