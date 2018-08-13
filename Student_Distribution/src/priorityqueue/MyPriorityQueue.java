package priorityqueue;

import java.util.ArrayList;

/* 
	The purpose of MyPriorityQueue class is for the students to practice
	how the priority queue works by implementing it with an ArrayList. 
	PriorityQueue is implemented using a min heap, meaning the parent
	value is smaller than the children. 
*/
public class MyPriorityQueue<E extends Comparable<E>> {
	private ArrayList<E> list;
	
    
	public MyPriorityQueue() {
		// initialize the list here.
	}

	//adding the item to the priority queue. You might want to use the bubbleUp helper method.
	public void insert(E item) {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}
	
	/** Helper method for add() and remove(). Swim happens in a PriorityQueue when 
	   the child value is smaller than the parent value. Then, the parent and child
	   value need to swap to maintain the property of PriorityQueue. 

	   ex.
	        5      (Property of PriorityQueue is maintained.)
		   /
		  6

		[5, 6]

		(adding 2 to the PriorityQueue) ->

		    5      (Notice that 2 is smaller than its parent, 5)   ->       2     (swapped!)
		   / \															   / \
		  6   2															  6   5

		[5, 6, 2]														[2, 6, 5]

	*/
	private void swim(int parent, int child) {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}
	
	/** Helper method for add() and remove(). Sink happens when the
	   root item is not in the correct position and need to move down to
	   maintain the property of PriorityQueue. 

	   ex. 
	     
		  1
		 / \
		2  3			 -> when remove() is called, 1 is removed, so the bottom-most, right-most node value replaces the 
	   /\				    1's place (head)
	  4  5

	  [1, 2, 3, 4, 5]

	      5
		 / \
		2  3			 -> the property of PriorityQueue is violated because 5 is greater than its children, 2 and 3. 
	   /			        Swap 5 with the SMALLEST child node value. If there is only one child available, swap	
	  4  					with that one child. 

	  [5, 2, 3, 4]

	  	  2
		 / \
		5  3			 -> the property of PriorityQueue is violated because 5 is greater than its child, 4.
	   /			        Swap 5 with its only and smaller child, 4.
	  4  					

	  [2, 5, 3, 4]

	      2
		 / \
		4  3			 -> 5 becomes a leaf and doesn't have anywhere else to move down to. Stop the heapify procedure because
	   /			        the property of PriorityQueue is maintained. 
	  5  					

	  [2, 4, 3, 5]
		
	*/
	private void sink(int startPoint) {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}

	// helper method that is provided to students to retrieve the smaller element
	// between the leftChildIdx and the rightChildIdx. 
	private int smallerElement(int left, int right) {
		if (left > list.size() - 1 || list.get(left) == null) {
			return right;
		}
		if (right > list.size() - 1 || list.get(right) == null) {
			return left;
		}

		
		E leftChild = list.get(left);
		E rightChild = list.get(right);
		if (leftChild.compareTo(rightChild) < 0) {
			return left;
		} else {
			return right;
		}
	}
	
	// returns the number of elements in the PriorityQueue.
	public int size() {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}

	/**
	 * Remvoes and returns the element with the highest priority
	 * @return the element with the highest priority
	 */
	public E remove() {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}
	
	/**
	 * 
	 * @return the element with the highest priority
	 */
	public E top() {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}
	/**
	 * Deletes everything from teh queue
	 */
	public void clear() {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}
	
	// helper method for swapping the values. 
	private void swap(int parentIdx, int childIdx) {
		E temp = list.get(childIdx);
		list.set(childIdx, list.get(parentIdx));
		list.set(parentIdx, temp);
	}
	/**
	 * Check if an item exits in the queue
	 * @param o 
	 * @return
	 */
	public boolean contains(Object o) {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}

	/** retrieves the index of the parent from position index i. 
		ex. 
		   1
		  /\
		 2 3

		  0  1  2     -> getParentIdx(2) will return 0, because 1 is 3's parent, 
		 [1, 2, 3]       and 3's idx position is 2 and 1's idx position is 0.

	*/
	private int getParentIdx(int i) {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}

	/** retrieves the index of the left child from position index i. 
		ex. 
		   1
		  /\
		 2 3

		  0  1  2     -> getLeftChildIdx(0) will return 1, because 2 is 1's left child, 
		 [1, 2, 3]       and 1's idx position is 0 and 2's idx position is 1.

	*/
	private int getLeftChildIdx(int i) {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}

	/** retrieves the index of the right child from position index i. 
		ex. 
		   1
		  /\
		 2 3

		  0  1  2     -> getRightChildIdx(0) will return 2, because 3 is 1's right child, 
		 [1, 2, 3]       and 1's idx position is 0 and 3's idx position is 2.

	*/
	private int getRightChildIdx(int i) {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}
	
	public String toString() {
		throw new Exception ("Haven't implemented!.. yet! :)");
	}
}
