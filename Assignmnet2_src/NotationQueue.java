import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T>{
	private ArrayList<T> queue;
	private int size;
	
	public NotationQueue() {
		queue = new ArrayList<>();
		size = 100;
	}
	
	public NotationQueue(int size){
		this.size = size;
		queue = new ArrayList<T>();
	}

	@Override
	public boolean isEmpty() {
		if(queue.size()==0)
			return true;
		else
			return false;
	}

	@Override
	public boolean isFull() {
		if(queue.size()==size)
			return true;
		else
			return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty())
			throw new QueueUnderflowException();
		else {
			T element = queue.get(0);
            queue.remove(0);
            return element;
		}
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(isFull())
			throw new QueueOverflowException();
		else {
			return queue.add(e);
		}
	}
	
	public String toString() {
		String queueStr = "";
		for(T e: queue)
			queueStr += e + "";

		return queueStr;
	}
	
	@Override
	public String toString(String delimiter) {
		String queueStr = "";
        for (T e : queue) {
            queueStr += e + delimiter;
        }
        return queueStr.substring(0, queueStr.length() - 1);
	}

	@Override
	public void fill(ArrayList<T> list) {
		queue.clear();
		for (T item : list) {
			queue.add(item);
		}
	}
	
}
