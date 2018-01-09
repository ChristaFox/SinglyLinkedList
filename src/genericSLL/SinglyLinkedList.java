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

package genericSLL;

import errorHandling.DoesNotContainNode;
import errorHandling.EmptyLinkedListException;

/**
 *Start generic singly linked list class 
 */
public class SinglyLinkedList <T> 
{
	/**
	 *Create field to store the first item in the list.
	 */
	private Node <T> head;
	
	/****************************************************
	 * Method     : Default generic SinglyLinkedList Constructor
	 *
	 * Purpose    : Creates a default list with no nodes.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public SinglyLinkedList ()
	{
		head = null;
	}

	/****************************************************
	 * Method     : isEmpty
	 *
	 * Purpose    : Method used to see if the List Contains Nodes.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method returns true or false.
	 *
	 ****************************************************/	
	public boolean isEmpty ()
	{
		return head == null;
	}
	
	/****************************************************
	 * Method     : addToFront
	 *
	 * Purpose    : Adds a node to the front of the singly 
	 * 				linked list using data.
	 *
	 * Parameters : It takes in generic data to assign to 
	 * 				the node.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public void addToFront (T data)
	{
		Node <T> temp = new Node <T> (data);
		this.addToFront(temp);
	}
	
	/****************************************************
	 * Method     : addToFront
	 *
	 * Purpose    : Adds a generic node to the front of the singly 
	 * 				linked list without data.
	 *
	 * Parameters : It takes in a node.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public void addToFront (Node <T> temp)
	{

		if (isEmpty())
		{
			head = temp;
		}
		//not empty
		else
		{
			temp.setNext (head);
			head = temp;
		}
	}
	
	/****************************************************
	 * Method     : find
	 *
	 * Purpose    : Takes a Singly Linked List in as the 
	 * 				argument and finds a the first matching 
	 * 				node in the Singly Linked List.  It also 
	 * 				throws the DoesNotContainNode and
	 * 				EmptyLinkedListException.
	 *
	 * Parameters : It takes in a node.
	 *
	 * Returns    : This method returns the node that matches
	 * 				the target node.
	 *
	 ****************************************************/	
	public Node<T> find (T target) throws DoesNotContainNode, EmptyLinkedListException
	{

		Node<T> current = head;
			if (isEmpty())
			{
				throw new EmptyLinkedListException ("The linked list is empty.  Please add items to search for.");
			}
			else
			{
				while(!current.isLast())
				{
					if(current.getData().equals(target))
					{
						return current;
					}
					
					else
					{
						current = current.getNext();
					}					
				}
				
			}
			
			/**
			 * returns the node if it is found
			 */
			if (current.getData().equals(target)){
				return current;
			}
			
			/**
			 * provides the user with a message if the list 
			 * does not contain the node.
			 */
			else 
				throw new DoesNotContainNode ("This list did not contain that distance node.");
	}
	
	/****************************************************
	 * Method     : removeFromFront 
	 *
	 * Purpose    : Removes the first item in the list, 
	 * 				unless the list is empty.  If the list
	 * 				is empty an EmptyLinkedListException
	 * 				is thrown.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/		
	public void removeFromFront () throws EmptyLinkedListException
	{
		if (isEmpty())
		{
			throw new EmptyLinkedListException ("Cannot remove from an empty linked list");
		}
		else
		{
			head = head.getNext();
		}
		
	}
	
	/****************************************************
	 * Method     : size 
	 *
	 * Purpose    : returns the size of the singly linked
	 * 				list.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method returns a number.
	 *
	 ****************************************************/	
	public int size()
	{
		int s = 0;
		if (isEmpty())
		{
			return s;
		}
		else
		{
			Node <T> current = head;
			s++;
			while (!current.isLast())
			{
				current = current.getNext();
				s++;
				
			}
		}
		return s;
	}
		
	/****************************************************
	 * Method     : toString
	 *
	 * Purpose    : This will print all of the nodes in 
	 * 				the list.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method returns a string or words.
	 *
	 ****************************************************/		
	public String toString ()
	{
		String answer = "";
		if (isEmpty())
		{
			answer = "SLL is empty";
		}
		else
		{
			Node <T> current = head;
			answer += current;
			while (!current.isLast())
			{
				current = current.getNext();
				answer += current;
				
			}
		}
		return answer;
	}

}
