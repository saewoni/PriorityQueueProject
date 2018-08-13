package tests;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.junit.Test;

import priorityqueue.MyPriorityQueue;

public class ReleaseTests {

	@Test
	public void Release1() {
		PriorityQueue<Character> expectedQueue = new PriorityQueue<Character>();
		MyPriorityQueue<Character> myQueue = new MyPriorityQueue<Character>();
		assertTrue(expectedQueue.poll() == myQueue.remove()); // null == null
		assertTrue(expectedQueue.peek() == myQueue.top()); // null == null
	}
	/*
	@Test
	public void Release2() {
		PriorityQueue<Character> expectedQueue = new PriorityQueue<Character>();
		MyPriorityQueue<Character> myQueue = new MyPriorityQueue<Character>();
		expectedQueue.add('c');
		expectedQueue.add('x');
		expectedQueue.add('a');
		expectedQueue.add('d');
		expectedQueue.add('w');
		
		myQueue.insert('c');
		myQueue.insert('x');
		myQueue.insert('a');
		myQueue.insert('d');
		myQueue.insert('w');
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		assertFalse(expectedQueue.contains(null));
		assertFalse(myQueue.contains(null));
		
		assertFalse(expectedQueue.contains('C'));
		assertFalse(myQueue.contains('C'));
		assertFalse(expectedQueue.contains(1));
		assertFalse(myQueue.contains(1));
		assertFalse(expectedQueue.contains("C"));
		assertFalse(myQueue.contains("C"));
		
		
		assertTrue(expectedQueue.remove('a'));
		assertTrue(myQueue.remove('a'));
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		assertTrue(expectedQueue.remove('c'));
		assertTrue(myQueue.remove('c'));
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		assertTrue(expectedQueue.remove('x'));
		assertTrue(myQueue.remove('x'));
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		assertTrue(expectedQueue.remove('w'));
		assertTrue(myQueue.remove('w'));
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		
		assertTrue(expectedQueue.remove('d'));
		assertTrue(myQueue.remove('d'));
		
		assertEquals(expectedQueue.toString(), myQueue.toString());
		assertTrue(myQueue.size() == 0);

	}*/
	
	@Test
	public void Release3() {
		MyPriorityQueue<Character> myQueue = new MyPriorityQueue<Character>();
		myQueue.insert('x');
		myQueue.insert('z');
		myQueue.insert('d');
		myQueue.insert('e');
		myQueue.insert('f');
		
		assertTrue(myQueue.contains('x'));
		assertTrue(myQueue.contains('z'));
		assertTrue(myQueue.contains('d'));
		assertTrue(myQueue.contains('e'));
		assertTrue(myQueue.contains('f'));
		
		assertFalse(myQueue.contains('X'));
		assertFalse(myQueue.contains(null));
		assertFalse(myQueue.contains("X"));
		
		myQueue.clear();
		
		assertTrue(myQueue.size() == 0);
		assertEquals("[]", myQueue.toString());
		
	}

}
