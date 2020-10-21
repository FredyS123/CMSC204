import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T>{

	private ArrayList<T> stack;
	private int size;
	
	public NotationStack(){
		size = 100;
		stack = new ArrayList<T>();
	}
	
	public NotationStack(int size){
		this.size = size;
		stack = new ArrayList<T>();
	}
	
	
	@Override
	public boolean isEmpty() {
		if(stack.size()==0)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(stack.size()==size)
			return true;
		return false;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
        } else { 
        	T element = stack.get(size() - 1);
            stack.remove(size() - 1);
            return element;
        }
	}

	@Override
	public T top() throws StackUnderflowException {
		if(stack.size()==0)
			throw new StackUnderflowException();
		return stack.get(0);
	}

	@Override
	public int size() {
		return stack.size();
	}

	@SuppressWarnings("unchecked")
	public boolean push(Object e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
        } else {
        	return stack.add((T) e);
        }
	}
	
	public String toString() {
		String toReturn = "";
		for(int i = stack.size()-1; i >= 0; i--) 
			toReturn += stack.get(i)+"";

		return toReturn;
	}
	
	@Override
	public String toString(String delimiter) {
		 String toReturn = "";
	        for (T e : stack) {
	            toReturn += e + delimiter;
	        }
	        return toReturn.substring(0, toReturn.length() - 1);
	}

	@Override
	public void fill(ArrayList<T> list) {
		stack.clear();
		for (T item : list) {
			stack.add(item);
		}
	}
	
}
