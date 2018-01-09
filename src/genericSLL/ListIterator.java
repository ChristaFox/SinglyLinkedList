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

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListIterator<E> implements Iterator<E> 
{
	private Node<E> nextNode;  
    private Node<E> lastReturnedNode;  
    private Node<E> previousNode;  
    private int removed = 0;  
  
    /****************************************************
	 * Method     : Parameterized ListIterator Constructor
	 *
	 * Purpose    : Constructor for the list iterator assigns 
	 * 				the node passed to the parameter as the next 
	 * 				node
	 *
	 * Parameters : A node
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
    public ListIterator(Node<E> node)
    {  
        this.nextNode = node;  
    }   
     
    /****************************************************
 	 * Method     : hasNext method
 	 *
 	 * Purpose    : Returns whether or not there is another
     * 				node in the list
 	 *
 	 * Parameters : None.
 	 *
 	 * Returns    : This method returns true or false
 	 *
 	 ****************************************************/
    public boolean hasNext ()  
    {  
        return nextNode != null;  
    }  
  
    /****************************************************
 	 * Method     : next method
 	 *
 	 * Purpose    : If the item is not found a no such element 
     * 				exception is thrown, but will iterate through 
     * 				the list as long as there are nodes.
 	 *
 	 * Parameters : None.
 	 *
 	 * Returns    : This method returns a generic type.  It is
 	 * 				hard-coded to return an exception or null
 	 * 				within the method body.
 	 *
 	 ****************************************************/
    public E next () throws NoSuchElementException  
    {  
        if (!this.hasNext ())  
        {
            throw new NoSuchElementException ("That item could not be found.");
        }
        
        else
        {
	        setPreviousNode(lastReturnedNode);  
	        lastReturnedNode = nextNode;  
	        nextNode = nextNode.getNext();
        }
        
		return null;
   
    }  
  
    /**
     * If last returned node can't be set the state 
     * the remove is in is illegal and throws and exception
     */
    /****************************************************
 	 * Method     : remove method
 	 *
 	 * Purpose    : If last returned node is null, the remove 
 	 * 				is in an illegal state.  An exception is
 	 * 				thrown.
 	 *
 	 * Parameters : None.
 	 *
 	 * Returns    : This method returns a generic type.  It is
 	 * 				hard-coded to return an exception or null
 	 * 				within the method body.
 	 *
 	 ****************************************************/
    public void remove() throws IllegalStateException  
    {  
        removed++;  
        if (lastReturnedNode == null)
        {
            throw new IllegalStateException ("Improper iterator state for remove operation");  
        }  
        else
        {  
            lastReturnedNode = null;  
        }  

    }

    /****************************************************
	 * Method     : getPreviousNode method
	 *
	 * Purpose    : Sets the private field of the previous Node.
	 *
	 * Parameters : None.
	 *
	 * Returns    : This method returns a generic Node.
	 *
	 ****************************************************/
	public Node<E> getPreviousNode() {
		return previousNode;
	}

	/****************************************************
	 * Method     : setPreviousNode method
	 *
	 * Purpose    : Sets the private field of previous Node.
	 *
	 * Parameters : Takes in a generic Node.
	 *
	 * Returns    : This method does not return a value.
	 *
	 ****************************************************/
	public void setPreviousNode(Node<E> previousNode) {
		this.previousNode = previousNode;
	}  
      
}
