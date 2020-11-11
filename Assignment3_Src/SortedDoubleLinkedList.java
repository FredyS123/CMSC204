import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList <T>{
	Comparator<T> comparator;
	
	SortedDoubleLinkedList(java.util.Comparator<T> comparator2){
		super();
		comparator = comparator2;
	}
	
	public void add(T data){
		Node<T> current = head;
		Node<T> temp;
		Node<T> follow = head;
		
		if(head == null && tail == null)
			super.addToFront(data);
		else if(size == 0) {
			head = new Node<T>(data);
			tail = head;
			size = size + 1;
		} else if(comparator.compare(data, head.data) < 1) 
			super.addToFront(data);
		else if(comparator.compare(data, head.data) > 0) {
			while(comparator.compare(data, current.data) != 0 || !(comparator.compare(data, current.data) < 0)) {
				if(current.next == null) {
					super.addToEnd(data);
					break;
				}
				if(follow == current) {
					current = current.next;
				}
				else {
					follow = follow.next;
					current = current.next;
				}
			}
		}
	}
	
	public void addToEnd(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	public void addToFront(T data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		return null;
	}
}
