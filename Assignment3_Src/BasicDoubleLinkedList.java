import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import javax.xml.soap.Node;

public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node<T> head, tail;
	protected int size;
	
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public int getSize() {
		
		return size;
	}
	
	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node <T> oldTail;
		
		if (size == 0) {
			head = new Node<T>(data);
			tail = head;
			size++;
		}
		else {
			oldTail = tail;
			tail = new Node<T>(data);
			oldTail.next = tail;
			tail.prev = oldTail;
			size++;
		}
		return this;
	}
	
	BasicDoubleLinkedList<T> addToFront(T data){
		Node <T> oldHead;
		
		if (size == 0) {
			head = new Node<T>(data);
			tail = head;
			size++;
		}
		else {
			oldHead = head;
			head = new Node<T>(data);
			oldHead.prev = head;
			head.next = oldHead;
			size++;
		}
		return this;
	}
	
	T getFirst() {
		return head.data;
	}
	
	T getLast() {
		return tail.data;
	}
	
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException{
		class Iterator implements ListIterator<T> {
			Node <T> iteration = null;
			Node <T> iterationFollow = head;
			private Node<T> toRight;
			private Node<T> toLeft;
			
			@Override
			public boolean hasNext() {
				if(iteration.next != null)
					return true;
				else
					return false;
			}

			@Override
			public T next() throws NoSuchElementException{
				if(iteration == null) {
					iteration = head;
					return iteration.data;
				}
				else if(!hasNext()) {
					throw new NoSuchElementException();
				}
				else {
					iteration = iteration.next;
					return iteration.data;
				}
			}

			@Override
			public boolean hasPrevious() {
				if((iteration == head) || (iteration == null))
					return false;
				else 
					return true;
			}

			@Override
			public T previous() throws NoSuchElementException{
				if (!hasPrevious()) {
					throw new NoSuchElementException();
				}
				else {
					for(int i = 1; i < size; i++) {
						if(iterationFollow.next == iteration) {
							iteration = iterationFollow;
							break;
						}
						iterationFollow = iterationFollow.next;
					}
					iterationFollow = head;
					return iteration.data;
				}
			}

			@Override
			public int nextIndex() {
				throw new UnsupportedOperationException();
			}

			@Override
			public int previousIndex() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

			@Override
			public void set(T e) {
				throw new UnsupportedOperationException();
			}

			@Override
			public void add(T e) {
				throw new UnsupportedOperationException();
			}
			
		}
		return null;
	}
	
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node<T> current = head;
		do {
			if(comparator.compare(targetData, current.data) == 0) {
				if(current == head) {
					head = head.next;
					size = size - 1;
					break;
				}
				else if(current == tail) {
					tail.next = null;
					size = size - 1;
					break;
				}
			}
			current = current.next;
		}while(current != null);
		return this;
	}
	
	public T retrieveFirstElement() {
		T first = head.data;
		if(size == 0) {
			return null;
		} else {
			head = head.next;
			size--;
			return first;
		}
	}
	
	public T retrieveLastElement() {
		T last = tail.data;
		Node <T> newNode;
		newNode = head;
		if (size == 0)
			return null;
		else {
			for(int i = 0; i < size; i++) {
				newNode = newNode.next;
			}
			tail = newNode;
			size--;
			return last; 
		}
	}
	
	public ArrayList<T> toArrayList(){
		ArrayList<T> arrayList = new ArrayList<T>();
		Node<T> current = head;
		
		while (current != null) {
			arrayList.add(current.data);
			current = current.next;
		}
		return arrayList;
	}
	
	protected class Node<T> {
		
		public BasicDoubleLinkedList<T>.Node<T> prev;
		protected T data;
		protected Node<T> next;
		
		public Node(T element) {
			data = element;
			
		}
	}
}
