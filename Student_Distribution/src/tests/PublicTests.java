package tests;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.junit.Test;

import priorityqueue.MyPriorityQueue;

public class PublicTests {
	
	/** The String outcome of the two should both be [A, B, D, E, C]. 
	 * Demo:
	 * 1. add E    ->           E
	 * 
	 * 2. add D    -> 	       E       -> see that D is smaller than its parent, E, so swap
	 * 						  /          to maintain the property of PriorityQueue
	 * 						 D		
	 * 
	 *  		   ->          D      
	 *  					  /
	 *  				     E
	 *  
	 * 3. add C    ->          D      -> see that C is smaller than its parent, D, so swap
	 *                        / \        to maintain the property of PriorityQueue
	 *                       E   C
	 *                       
	 *              ->         C      
	 *  					  / \
	 *  				     E   D    
	 *  
	 *  4. add B ->            C      -> see that B is smaller than its parent, B, so swap
	 *  					  / \        to maintain the property of PriorityQueue
	 *  				     E   D  
	 *                      /
	 *                     B
	 *                     
	 *              ->         C      -> see that B is smaller than its parent, C, so swap
	 *  					  / \        to maintain the property of PriorityQueue
	 *  				     B   D  
	 *                      /
	 *                     E
	 *                     
	 *              ->         B      
	 *  					  / \       
	 *  				     C   D  
	 *                      /
	 *                     E
	 *                     
	 *  5. add A ->            B      -> see that A is smaller than its parent, C, so swap
	 *  					  / \        to maintain the property of PriorityQueue
	 *  				     C   D  
	 *                      / \
	 *                     E   A
	 *               
	 *              ->         B      -> see that A is smaller than its parent, B, so swap
	 *  					  / \        to maintain the property of PriorityQueue
	 *  				     A   D  
	 *                      / \
	 *                     E   C
	 *                     
	 *              ->         A      -> done!
	 *  					  / \        
	 *  				     B   D  
	 *                      / \
	 *                     E   C
	 *                     
	 *  
	 * **/
	@Test
	public void testAdd1() {
		PriorityQueue<String> expectedQueue = new PriorityQueue<String>();
		MyPriorityQueue<String> myQueue = new MyPriorityQueue<String>();
		myQueue.insert("E");
		myQueue.insert("D");
		myQueue.insert("C");
		myQueue.insert("B");
		myQueue.insert("A");
		
		expectedQueue.add("E");
		expectedQueue.add("D");
		expectedQueue.add("C");
		expectedQueue.add("B");
		expectedQueue.add("A");
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
	}
	
	/** The String outcome of the two should both be [0, 1, 5, 3]. 
	 * Demo:
	 * 1. add 3    ->          3
	 * 
	 * 2. add 1    -> 	       3      -> see that 1 is smaller than its parent, 3, so swap
	 * 						  /          to maintain the property of PriorityQueue
	 * 						 1		
	 * 
	 *  		   ->          1      
	 *  					  /
	 *  				     3
	 *  
	 * 3. add 5    ->          1      -> see that 5 is not smaller than its parent, 1, so 
	 *                        / \        no need to swap
	 *                       3   5
	 *                       
	 *  
	 * 3. add 0    ->          1      -> see that 0 is smaller than its parent, 3, so swap
	 *                        / \        to maintain the property of PriorityQueue
	 *                       3   5    
	 *                      /
	 *                     0
	 *                 
	 *             ->          1      -> see that 0 is smaller than its parent, 1, so swap
	 *                        / \        to maintain the property of PriorityQueue
	 *                       0   5    
	 *                      /
	 *                     3
	 *             
	 *             ->          0      -> done!
	 *                        / \        
	 *                       1   5    
	 *                      /
	 *                     3
	 *              
	 
	 *  
	 * **/
	@Test 
	public void testAdd2() {
		PriorityQueue<Integer> expectedQueue = new PriorityQueue<Integer>();
		MyPriorityQueue<Integer> myQueue = new MyPriorityQueue<Integer>();
		myQueue.insert(3);
		myQueue.insert(1);
		myQueue.insert(5);
		myQueue.insert(0);
		
		expectedQueue.add(3);
		expectedQueue.add(1);
		expectedQueue.add(5);
		expectedQueue.add(0);
	
		assertEquals(expectedQueue.toString(), myQueue.toString());
	}
	
	/** The String outcome of the two should both be [0, 1, 5, 3]. 
	 * Demo:
	 * 1. add c    ->          c
	 * 
	 * 2. add a    -> 	       c      -> see that a is smaller than its parent, c, so swap
	 * 						  /          to maintain the property of PriorityQueue
	 * 						 a		
	 *			   
	 *			   -> 	       a     
	 * 						  /          
	 * 						 c		
	 * 
	 * 3. add d    -> 	       a     
	 * 						  / \         
	 * 						 c	 d
	 * 
	 * 
	 * 4. poll()   ->         -a-    -> to remove a, physically remove the bottom-most, right-most 
	 * 					      / \       leaf, d, and replace it on a's position
	 * 						 c   d
	 * 
	 * 			   ->          d     -> see that d is larger than its only child, c, so swap 
	 * 					      /         to maintain the property of PriorityQueue.
	 * 						 c   
	 *   
	 * 5. poll()    ->        -c-    -> to remove c, physically remove the bottom-most, right-most
	 * 					      /         leaf, d, and replace it on c's position
	 * 						 d   
	 * 
	 * 				->	       d
	 * 
	 * 5. poll()    ->        -d-     -> done
	 * 
	 * **/
	@Test
	public void testRemove1() {
		PriorityQueue<Character> expectedQueue = new PriorityQueue<Character>();
		MyPriorityQueue<Character> myQueue = new MyPriorityQueue<Character>();
		
		expectedQueue.add('c');
		expectedQueue.add('a');
		expectedQueue.add('d');
		
		myQueue.insert('c');
		myQueue.insert('a');
		myQueue.insert('d');
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		assertTrue(expectedQueue.poll() == 'a');
		assertTrue(myQueue.remove() == 'a');
		
		assertTrue(expectedQueue.poll() == 'c');
		assertTrue(myQueue.remove() == 'c');
		
		assertTrue(expectedQueue.poll() == 'd');
		assertTrue(myQueue.remove() == 'd');
		
	}
	
	@Test
	public void testPoll2() {
		PriorityQueue<Integer> expectedQueue = new PriorityQueue<Integer>();
		MyPriorityQueue<Integer> myQueue = new MyPriorityQueue<Integer>();
		
		expectedQueue.add(5);
		expectedQueue.add(4);
		expectedQueue.add(3);
		expectedQueue.add(2);
		expectedQueue.add(1);
		
		myQueue.insert(5);
		myQueue.insert(4);
		myQueue.insert(3);
		myQueue.insert(2);
		myQueue.insert(1);
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		/*
		 * notice that when poll() is called each time, 
		 * the elements in the PriorityQueue are retrieved
		 * in ascending order.
		 */
		assertTrue(expectedQueue.poll() == 1);
		assertTrue(myQueue.remove() == 1);
		
		assertTrue(expectedQueue.poll() == 2);
		assertTrue(myQueue.remove() == 2);
		
		assertTrue(expectedQueue.poll() == 3);
		assertTrue(myQueue.remove() == 3);
		
		assertTrue(expectedQueue.poll() == 4);
		assertTrue(myQueue.remove() == 4);
		
		assertTrue(expectedQueue.poll() == 5);
		assertTrue(myQueue.remove() == 5);
	
	}
	
	public void testPeek1() {
		PriorityQueue<Integer> expectedQueue = new PriorityQueue<Integer>();
		MyPriorityQueue<Integer> myQueue = new MyPriorityQueue<Integer>();
		
		expectedQueue.add(5);
		expectedQueue.add(4);
		expectedQueue.add(3);
		expectedQueue.add(2);
		expectedQueue.add(1);
		
		myQueue.insert(5);
		myQueue.insert(4);
		myQueue.insert(3);
		myQueue.insert(2);
		myQueue.insert(1);
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		/*
		 * notice that when poll() is called each time, 
		 * the elements in the PriorityQueue are retrieved
		 * in ascending order.
		 */
		assertTrue(expectedQueue.peek() == 1);
		assertTrue(myQueue.top() == 1);
		assertTrue(expectedQueue.poll() == 1);
		assertTrue(myQueue.remove() == 1);
		assertFalse(expectedQueue.peek() == 1);
		assertFalse(myQueue.top() == 1);
		
		assertTrue(expectedQueue.peek() == 2);
		assertTrue(myQueue.top() == 2);
		assertTrue(expectedQueue.poll() == 2);
		assertTrue(myQueue.remove() == 2);
		assertFalse(expectedQueue.peek() == 1);
		assertFalse(myQueue.top() == 1);
		
		assertTrue(expectedQueue.peek() == 3);
		assertTrue(myQueue.top() == 3);
		assertTrue(expectedQueue.poll() == 3);
		assertTrue(myQueue.remove() == 3);
		assertFalse(myQueue.top() == 3);
		
		assertTrue(expectedQueue.peek() == 4);
		assertTrue(myQueue.top() == 4);
		assertTrue(expectedQueue.poll() == 4);
		assertTrue(myQueue.remove() == 4);
		assertFalse(expectedQueue.peek() == 4);
		assertFalse(myQueue.top() == 4);
		
		assertTrue(expectedQueue.peek() == 5);
		assertTrue(myQueue.top() == 5);
		assertTrue(expectedQueue.poll() == 5);
		assertTrue(myQueue.remove() == 5);
		assertFalse(expectedQueue.peek() == 5);
		assertFalse(myQueue.top() == 5);
	}
	
	/** 
	 *  Prior remove -> 	1
	 *    				   / \
	 *    				  2   4
	 *    			     / \
	 *    			    5   3
	 *    
	 *  1. remove 3  -> 	1		->		1
	 *    				   / \			   / \
	 *    				  2   4           2   4
	 *    			     / \             / 
	 *    			    5  -3-          5
	 *  
	 *  2. remove 2 ->      1	    -> removing 2 means replacing 2 with the bottom-most, right-most
	 *    				   / \		   leaf's value and physically removing the leaf. 
	 *    				 -2-  4          
	 *    			     /              
	 *    			    5  
	 *     
	 *     	        ->      1	    
	 *    				   / \		   
	 *    				  5   4    
	 *    
	 *   3. remove 1 ->    -1-	     -> removing 1 means replacing 1 with the bottom-most, right-most
	 *    				   / \		    leaf value and physically removing that leaf. 
	 *    				  5   4     
	 *    
	 *    		     ->     4	     
	 *    				   / 		    
	 *    				  5    
	 *    			      
	 *   4. remove 4 ->    -4-       -> removing 4 means replacing 4 with the bottom-most, right-most	     
	 *    				   / 			leaf value and physically removing that leaf.	    
	 *    				  5   
	 *     
	 *     		     ->     5
	 *     
	 *   5. remove 5 ->    -5-        -> done!
	 */
	/*
	@Test
	public void testRemove1() {
		PriorityQueue<Integer> expectedQueue = new PriorityQueue<Integer>();
		MyPriorityQueue<Integer> myQueue = new MyPriorityQueue<Integer>();
		
		expectedQueue.add(5);
		expectedQueue.add(4);
		expectedQueue.add(3);
		expectedQueue.add(2);
		expectedQueue.add(1);
		
		myQueue.insert(5);
		myQueue.insert(4);
		myQueue.insert(3);
		myQueue.insert(2);
		myQueue.insert(1);
		
		System.out.println(expectedQueue.toString());
		expectedQueue.remove(3);
		myQueue.remove(3);
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		expectedQueue.remove(2);
		myQueue.remove(2);
		assertEquals(expectedQueue.toString(), myQueue.toString());
		expectedQueue.remove(1);
		myQueue.remove(1);
		
	
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		expectedQueue.remove(4);
		myQueue.remove(4);
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		expectedQueue.remove(5);
		myQueue.remove(5);
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		assertTrue(myQueue.size() == 0);
		
		
	}
	*/
	
	@Test
	public void testRemove2() {
		PriorityQueue<String> expectedQueue = new PriorityQueue<String>();
		MyPriorityQueue<String> myQueue = new MyPriorityQueue<String>();
		
		expectedQueue.add("Yogurt");
		myQueue.insert("Yogurt");
		assertTrue(myQueue.contains("Yogurt"));
		assertFalse(myQueue.contains("yoGurt"));
		
		expectedQueue.add("Carrot");
		myQueue.insert("Carrot");
		assertTrue(myQueue.contains("Carrot"));
		assertFalse(myQueue.contains("CARROT"));
		
		expectedQueue.add("Squash");
		myQueue.insert("Squash");
		assertTrue(myQueue.contains("Squash"));
		assertFalse(myQueue.contains("SqAsH"));
		
		expectedQueue.add("Apple");
		myQueue.insert("Apple");
		assertTrue(myQueue.contains("Apple"));
		assertFalse(myQueue.contains("appLe"));
		
		expectedQueue.add("Banana");
		myQueue.insert("Banana");
		assertTrue(myQueue.contains("Banana"));
		assertFalse(myQueue.contains("bananA"));
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
	}

	
}
