package priorityqueue;

import java.util.ArrayList;

public class MyPriorityQueue<E extends Comparable<E>> {
	private ArrayList<E> list;
	
    
	public MyPriorityQueue() {
		list = new ArrayList<E>();
	}

	public void insert(E item) {
		if (item != null) {
			list.add(item);
			int child = list.size() - 1;
			int parent = getParentIdx(child);

			swim(parent, child);
		}
	}
	
	private void swim(int parent, int child) {
		while (list.get(parent) != null && list.get(child) != null
				&& list.get(parent).compareTo(list.get(child)) > 0) {
			swap(parent, child);
			child = parent;
			parent = getParentIdx(child);
		}
	}
	
	private void sink(int startPoint) {
		boolean heapify = true;
		int parent = startPoint;
		int child1 = getLeftChildIdx(parent);
		int child2 = getRightChildIdx(parent);
		while (heapify && list.get(parent) != null && 
				(child1 < list.size() || child2 < list.size())) {
			
			int smallerChild = smallerElement(child1, child2);
			//System.out.println(list.get(parent));
			//System.out.println(list.get(smallerChild));
			if (list.get(parent).compareTo(list.get(smallerChild)) > 0) {
				swap(parent, smallerChild);
				parent = smallerChild;
				child1 = getLeftChildIdx(parent);
				child2 = getRightChildIdx(parent);
			} else {
				heapify = false;
			}

		}
	}

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
	
	public int size() {
		return list.size();
	}

	public E remove() {
		if (list.size() == 0) {
			return null;
		}
		if (list.size() == 1) {
			E temp = list.remove(0);
			return temp;
		}
		E temp = list.get(list.size() - 1);
		E head = list.get(0);
		list.remove(list.size() - 1);
		list.set(0, temp);
		
		if (list.size() > 1) {
			sink(0);
		}
		return head;
	}

	public E top() {
		return list.size() > 0 ? list.get(0) : null;
	}
	
	public void clear() {
		list = new ArrayList<E>();
	}
	/*
	public boolean remove(Object o) {
		if (o == null) {
			return false;
		}
		int i = 0; 
		int startPos = -1;
		for (E e : list) {
			if (e != null && e.equals(o)) {
				startPos = i;
				break;
			} else {
				i++;
			}
		}
		
		if (startPos == -1) {
			return false;
		}
		
		E temp = list.get(list.size() - 1);
		int size = list.size();
		
		if (startPos + 1 != size) {
			list.remove(list.size() - 1);
			list.set(startPos, temp);
			int parentIdx = getParentIdx(startPos);
			int child1Idx = getLeftChildIdx(startPos);
			int child2Idx = getRightChildIdx(startPos);
			
			if (list.get(parentIdx).compareTo(list.get(startPos)) > 0) {
				swim(parentIdx, startPos);
			} else if (child1Idx < list.size() && child2Idx < list.size() && 
					(list.get(startPos).compareTo(list.get(child1Idx)) > 0 ||
					list.get(startPos).compareTo(list.get(child2Idx)) > 0)) {
				sink(startPos);
			}
		} else {
			list.remove(list.size() - 1);
		}
		
		return true;
	}*/

	public void swap(int parentIdx, int childIdx) {
		E temp = list.get(childIdx);
		list.set(childIdx, list.get(parentIdx));
		list.set(parentIdx, temp);
	}
	
	public boolean contains(Object o) {
		if (o != null) {
			for (E e : list) {
				if (e != null && e.equals(o)) {
					return true;
				}
			}
		}
		return false;
	}

	private int getParentIdx(int i) {
		return (i - 1) / 2;
	}

	private int getLeftChildIdx(int i) {
		return 2 * i + 1;
	}

	private int getRightChildIdx(int i) {
		return 2 * i + 2;
	}
	
	public String toString() {
		return list.toString();
	}
}
