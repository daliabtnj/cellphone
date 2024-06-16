/**
 * Name(s) and ID(s) (Dalia Betinjaneh 40200966)
 * COMP249
 * Assignment # (3)
 * Due Date (Saturday December 2)
 * 
 */

import java.util.NoSuchElementException;

/**
 * The CellList class represents a linked list of CellPhone objects.
 * It provides various methods to manipulate and interact with the linked list.
 */

public class CellList {
	/**
     * The private inner class CellNode represents a node in the linked list.
     * Each node contains a CellPhone object and a reference to the next node.
     * The class is private so that there is no privacy leaks
     */
	private class CellNode implements Cloneable{
		
		private CellPhone cell; // Initialize variables
		private CellNode next; // reference/link
		private static int nodeCount = 0; // counter to get the size
		

        /**
         * Default constructor for creating an empty CellNode.
         */
		public CellNode() {
			this.cell = null;
			this.next = null;
			nodeCount++;
		}
		
		/**
         * Parameterized constructor for creating a CellNode with a CellPhone and a reference to the next node.
         *
         * @param cell The CellPhone object to be stored in the node.
         * @param next The reference to the next node.
         */
		public CellNode(CellPhone cell, CellNode next) {
			this.cell = cell;
			this.next = next;
			nodeCount++;
		}
		
        /**
         * Copy constructor for creating a deep copy of a CellNode.
         *
         * @param other The CellNode to be copied.
         */
	    public CellNode(CellNode other) {
	        // Use the copy constructor of CellPhone to create a deep copy
	    	// since cellPhone copy constructor takes cell and a serial number as variable we
	    	// use getSerialNumber()
	        this.cell = new CellPhone(other.cell, other.cell.getSerialNumber());
	        this.next = other.next;
	        nodeCount++;
	    }

	    /**
         * Clone method for creating a deep copy of the CellNode.
         *
         * @return A new CellNode that is a deep copy of this node.
         */	    public CellNode clone() {
            nodeCount++;
            return new CellNode(this);
        }
		
         /**
          * Getter method for retrieving the CellPhone stored in the node.
          *
          * @return The CellPhone stored in the node.
          */		
         public CellPhone getCell() {
			return cell;
		}
         
         /**
          * Setter method for setting the CellPhone in the node.
          *
          * @param cell The CellPhone to be set in the node.
          */
		public void setCell(CellPhone cell) {
			this.cell = cell;
		}
		
		/**
         * Getter method for retrieving the reference to the next node.
         *
         * @return The reference to the next node.
         */
		public CellNode getNext() {
			return next;
		}
		
		/**
         * Setter method for setting the reference to the next node.
         *
         * @param next The reference to the next node.
         */
		public void setNext(CellNode next) {
			this.next = next;
		}
		
	}
	
	// attributes of CellList
	private CellNode head;
	private int size = CellList.CellNode.nodeCount;
	
	/**
     * Default constructor for creating an empty CellList.
     * Initializes the head to null and size to 0.
     */
	public CellList() {
		head = null;
		size = 0;
	}
	
	/**
     * Copy constructor for creating a deep copy of an existing CellList.
     *
     * @param list The CellList to be copied.
     */
	public CellList(CellList list) {
	    // test if list is empty
	    if (list.head == null) {
	        head = null; // returns an empty list
	    } else {
	        head = null; // setting head of copied list to null
	        CellNode t1, t2, t3; // create 3 temporary pointers

	        t1 = list.head; // t1 points to the head of the list we want to copy
	        t2 = t3 = null;
	        while (t1 != null) { // loop goes on until we reach the end of the list
	            if (head == null) { // happens only once
	                t2 = new CellNode(t1); // creating a deep copy of t1 in t2
	                head = t2; // the head now has a copy of list.head 
	            } else { // head is set, now we copy all other elements of the list
	                t3 = new CellNode(t1); // place copy of t1 in t3
	                t2.next = t3; // copied the next element of the list
	                t2 = t3; // shift t2 to t3 to be able to repeat the process
	            }
	            t1 = t1.next; 
	        }
	        t2 = t3 = null; // t1 is already null by now
	        size = list.size; // Set the size to be the same as the original list
	    }
	}

	
	/**
     * Adds a CellPhone to the start of the linked list.
     *
     * @param c The CellPhone to be added.
     */
	public void addToStart(CellPhone c)
	{
		CellNode n = new CellNode(c, head);	// create a new node with cellPhone c inside  
		head = n; // set the head of the list as that created node pushing the existing nodes								
		size++;
	}
	
	// method insert at index inserts a cellPhone to an indicated index
    /**
     * Inserts a CellPhone at the specified index in the linked list.
     *
     * @param c     The CellPhone to be inserted.
     * @param index The index at which to insert the CellPhone.
     * @throws NoSuchElementException If the index is invalid.
     */
	public void insertAtIndex(CellPhone c, int index) throws NoSuchElementException {
		 if (index < 0 || index > size  ) {
	            throw new NoSuchElementException("Invalid index");
	        }
		 
		 // If inserting at the beginning
	        if (index == 0) {
	            addToStart(c);
	            return;
	        }
	        
	        CellNode previous = head;
	        
	        // go through the list to find the node at the position before the specified index
	        // It uses a loop to move previous to the node at index - 1.
	        // we stop at index - 1 for example we stop at i = 0 if index = 2
	        for (int i = 0; i < index - 1; i++) {
	            previous = previous.getNext();
	            
	        }
	        
	        // creating a new node between 1 and 2 => new node is now at position 2 and old position 2 is at position 3
	        // the node at position index gets pushed to position index + 1
	        CellNode newNode = new CellNode(c, previous.getNext());
	        previous.setNext(newNode); // setting the link between the previous and the new node
	        size++; // Increment the size of the list
	}

	// method deleteFromIndex
	/**
     * Deletes the CellPhone at the specified index in the linked list.
     *
     * @param index The index at which to delete the CellPhone.
     * @throws NoSuchElementException If the index is invalid.
     */
	public void deleteFromIndex(int index) throws NoSuchElementException {
		if (index < 0 || index > size - 1) // check ifindex is out of bounds
			throw new NoSuchElementException("Index out of bounds");
		
		if (index == 0) { // case where index is first element
			deleteFromStart();
			return;
		}
		
		
		CellNode temp = head;
		// for loop that goes through all values until it reaches the value before index 
			for (int i = 0; i < index-1; i++) {
			temp = temp.next;
		}
		
		// set the node coming after temp to skip one
		// this way the node at temp will not be part of the list anymore it will be skipped
		temp.next = temp.next.next;

		size--;
	}
	
	// method deleteFromStart
	/**
     * Deletes the CellPhone from the start of the linked list.
     *
     * @throws NoSuchElementException If the linked list is empty.
     */
	public void deleteFromStart() throws NoSuchElementException{
		if (head == null) // case where list is empty
			throw new NoSuchElementException("Linked list is empty.");
		
		// If there is only one node in the list then we say the list is empty
        if (head.getNext() == null) {
            head = null;
        } else { // now we have made sure that there is a list, and it has more than one item
            head = head.getNext(); // setting the head to the element that comes after it
        }
        size--; // size gets smaller
		
	}
	
	// method replace at index
	/**
     * Replaces the CellPhone at the specified index with a new CellPhone.
     *
     * @param c     The new CellPhone to be inserted.
     * @param index The index at which to replace the CellPhone.
     */
	public void replaceAtIndex(CellPhone c, int index){
		deleteFromIndex(index); // we delete from the index and then add the new cellphone to the index
		insertAtIndex(c, index);
	}
	
	// method find if serial number is part of the list
	// PRIVACY LEAK 
	/* Returning a pointer to a node can be considered a privacy leak because it exposes internal details of the data structure to 
	 * the outside world. Objects are passed by reference, and when we return a pointer to a node, we allow external code to 
	 * modify the internal state of the node, violating the principle of encapsulation.
	 * 
	 * a solution would be to return the object. We would have to change the return type of the method.
	 * in other words we would have to return a cellPhone object instead of a CellNode
	 * we have to return temp.c instead of temp so that we just get the cellphone object
	 */
	/**
     * Searches for a CellNode containing a CellPhone with the specified serial number.
     *
     * @param SN The serial number to search for.
     * @return The CellNode containing the CellPhone if found; otherwise, null.
     */
	public CellNode find(long SN) {
		CellNode temp = head;
		
		int count = 0;
		while (temp!=null) {
			count++;
			// if the serial number of the cell inside the node is equal to the entered serial number we return the pointer 
			if (temp.cell.getSerialNumber() == SN) {
				System.out.print("Before finding the serial number in the list, " + count + " itirations was/were made : ");
				return temp; 
			}
			temp = temp.next; // in this case the serial number and SN are not equal loop continues
		}
		return null; // case where it is not found, we reached the end of the loop and no same SN found
		// or case where the list is empty
	}
	
	
	// contains method returns true if serial number is part of the list
	/**
     * Checks if a CellPhone with the specified serial number is present in the linked list.
     *
     * @param SN The serial number to check for.
     * @return true if the linked list contains the serial number; false otherwise.
     */
	public boolean contains(long SN) {
		if (find(SN) == null) // use find method to check if not in the list
			return false;
		else
			return true;
	}
	
	// show content method
    /**
     * Displays the contents of the linked list.
     */
	public void showContent() {
		CellNode temp = head;
		if (temp == null)
			System.out.println("\nThe list is empty.");
		else {
			System.out.println("The current size of the list is " + size + ". Here are the contents of the list");
			System.out.println("============================================================================");
			
			int count = 0;
			while (temp != null) {
			System.out.print(temp.cell + " ---> ");
			temp = temp.next;
			count++;
			
			if (count%3 == 0)
				System.out.println();
			}
				
			System.out.println("X");
		}
	}

    /**
     * Checks if this CellList is equal to another CellList.
     *
     * @param list The CellList to compare with.
     * @return true if the two CellLists are equal; false otherwise.
     */
	public boolean equals(CellList list) {
		CellNode thisNode = head;
		CellNode listNode = list.head;
		
		// if they are both empty it returns true
		if (list.head == null && head == null) {
			return true;
		}
		
		// they are both the same size now we check if the objects inside are the same
		while (thisNode != null) {
			if (!(thisNode.getCell().equals(listNode.getCell()))) {
				return false;
			}
			
			thisNode = thisNode.next;
			listNode = listNode.next;
				
		}
		return true;
	}
	
	
}

