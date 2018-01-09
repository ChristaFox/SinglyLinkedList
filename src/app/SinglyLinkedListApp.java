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

import javax.management.InstanceNotFoundException;

import genericSLL.Node;
import genericSLL.SinglyLinkedList;

import errorHandling.DoesNotContainNode;
import errorHandling.EmptyLinkedListException;

	/**
	 * begin app
	 */
public class SinglyLinkedListApp<T> 
{
	
	/**
	 * Field to store singly linked list
	 */
	private SinglyLinkedList<Book> sll;
	private String title;
	private String author;
	
	
	public SinglyLinkedListApp()
	{
		/**
		 * Instantiates the field sll.
		 */
		sll = new SinglyLinkedList<Book>();
		
		/**
		 * Creates 5 book objects
		 */
		Book temp1 = new Book("Pride and Prejudice", "Jane Austen");
		Book temp2 = new Book("The Catcher in the Rye", "J.D. Salinger");
	    Book temp3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
	    Book temp4 = new Book("The Stranger", "Albert Camus");
	    Book temp5 = new Book("The Perks of Being a Wallflower", "Stephen Chbosky");
	    
	    /**
	     * Adds the books to the singly linked list
	     */
	    sll.addToFront(temp1);
	    sll.addToFront(temp2);
	    sll.addToFront(temp3);
	    sll.addToFront(temp4);
	    sll.addToFront(temp5);

	}
	
	/**
	 * Begin main
	 * @throws InstanceNotFoundException 
	 */
	public static void main(String[] args) throws InstanceNotFoundException 
	{
		SinglyLinkedListApp<Book> sllApp = new SinglyLinkedListApp<Book>();
		try
		{
			sllApp.makeAChoice();
		} 
		catch (EmptyLinkedListException e) 
		{
			e.printStackTrace();
		}
		
	/**
	 * end main
	 */
	}
	
	/****************************************************
	 * Method     : displayMenu
	 *
	 * Purpose    : Displays the menu utilizing the IO class file.
	 * 				It allows the user to see what their choices are.
	 *
	 * Parameters : All of the options you would like to communicate 
	 * 				to your end user, and the associated numbers to 
	 * 				these options.  The lowest option number and 
	 * 				highest option number will be taken into account
	 * 				for error handling.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public static void displayMenu() 
	{
	question.IO.menu("1.\tAdd an item\n2.\tDelete an item\n3.\tFind an item\n4.\tDisplay the list\n5.\tExit\n", 
			1, 5);	
		
	}
	
	/****************************************************
	 * Method     : makeAChoice
	 *
	 * Purpose    : This method handles the user's choice and calls 
	 * 				the method needed to perform what the user 
	 * 				needed to be done including the following: add 
	 * 				book, delete book, find book, and display books.
	 * 				A EmptyLinkedListException and InstanceNotFoundException
	 * 				will be thrown as needed.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public void makeAChoice() throws EmptyLinkedListException, InstanceNotFoundException
	{
		int selection = 0;
		do
		{	
			displayMenu();
			
			switch(selection = question.IO.getChoice()) 
			{
				case 1: addDistanceItem(sll);
						break;
				case 2:	removeFromList(sll);
						break;
				case 3:	find();
						break;
				case 4: System.out.println(sll.toString());
						break;
				case 5: System.exit(0);
				
			}
		
		}while(selection != 5);
	
	}
		
	/****************************************************
	 * Method     : removeFromList
	 *
	 * Purpose    : This method removes the last item to 
	 * 				be added to the list--since singly 
	 * 				linked lists are first in last out.
	 * 				If the list is empty an exception will 
	 * 				be thrown.
	 *
	 * Parameters : This will take in a list.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	private void removeFromList(SinglyLinkedList<?> list) {
		try 
		{
			list.removeFromFront();
		}
		catch (EmptyLinkedListException e) 
		{
			e.printStackTrace();
		}
	}
	
	/****************************************************
	 * Method     : find
	 *
	 * Purpose    : This method utilizes the find method
	 * 				on the singly linked list.  It 
	 * 				compares the data of the nodes in the 
	 * 				list to the target node(the user creates 
	 * 				this after walked through in the console 
	 * 				by the createTargetNode() method).
	 *
	 * Parameters : This will take in a list.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	private <T> void find()
	{

		try 
		{
			Node<Book> n = sll.find(createTargetNode().getData());
			findMessage(n);
		} 
		catch (DoesNotContainNode | EmptyLinkedListException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	/****************************************************
	 * Method     : findMessage
	 *
	 * Purpose    : Produces a message to let the user know 
	 * 				if the item was found.
	 *
	 * Parameters : This takes in the book, so the title and
	 * 				author can be displayed.  If the book 
	 * 				reference is unavailable a message that it 
	 * 				was not found is printed to the console.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	private void findMessage(Node<Book> n)
	{
		if(n == null)
		{
			System.out.println("Item was not found");
		}
		else
		{
			System.out.printf("The distance item %s was found.", n.toString());
		}
	}
	
	/****************************************************
	 * Method     : createTargetNode
	 *
	 * Purpose    : Creates a Book Node with user input.  
	 * 				It works with the input/output class 
	 * 				to input the user responses. 
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method returns a Node of Type Book.
	 *
	 ****************************************************/
	public Node<Book> createTargetNode()
	{
		question.IO.promptForString("Please type the book title.");
		title = question.IO.getString();
		question.IO.promptForString("Please type the author of this book.");
		author = question.IO.getString();
		Book b = new Book(title, author);
		Node<Book> tar = new Node<Book>(b);
		return (Node<Book>) tar;
	}
	
	/****************************************************
	 * Method     : addDistanceItem
	 *
	 * Purpose    : Adds the new object to the front of the list.
	 *
	 * Parameters : Takes in a Singly Linked List.
	 *
	 * Returns    : This method returns a Node of Type Book.
	 *
	 ****************************************************/
	private void addDistanceItem(SinglyLinkedList<Book> l) 
	{
		Node<Book> temp = createTargetNode();
		l.addToFront(temp);
		System.out.printf("You have added %s.", temp.toString());	
	}
	
	/**
	 * end app
	 */
}

