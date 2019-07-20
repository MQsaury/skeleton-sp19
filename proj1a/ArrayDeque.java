public class ArrayDeque<Flag>{
	public int size;
	public Flag[] items; 


	public ArrayDeque() {
		size = 0;
		items = (Flag[]) new Object[8];
	}

	public ArrayDeque(ArrayDeque other) {
		items = (Flag[]) new Object[8];
		for(int i=0;i<other.size;i+=1) {
			this.addLast((Flag) other.get(i));
		}
	}

	private Flag[] resize(int capacity) {
		Flag[] new_deque = (Flag[]) new Object[capacity];
		return new_deque;
	}

	public void addFirst(Flag item) {
		size = size+1;
		Flag[] new_deque = resize(size+1);
		new_deque[0] = item;
		System.arraycopy(items,0,new_deque,1,size);
		items = new_deque;
	}

	public void addLast(Flag item) {
		if(size == items.length) {
			Flag[] new_deque = resize(size + 1);
			System.arraycopy(items,0,new_deque,0,size);
			items = new_deque;
		}
		items[size] = item;
		size = size+1;		
	}

	public boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		for(int i =0; i<size;i+=1) {
			System.out.print(items[i]+" ");
		}
		System.out.println(" ");
		System.out.println(" ");
	}

	public Flag removeFirst() {
		Flag[] new_deque = resize(size-1);
		Flag store = items[0];
		System.arraycopy(items,1,new_deque,0,size-1);
		items = new_deque;
		size = size-1;
		return store;
	}

	public Flag removeLast() {
		Flag[] new_deque = resize(size-1);
		Flag store = items[size-1];
		System.arraycopy(items,0,new_deque,0,size-1);
		items = new_deque;
		size = size-1;
		return store;
	}

	public Flag get(int index) {
		if(index <=size-1) {
			return items[index];
		} else {
			return null;
		}
		
	}


	public static void main(String[] args) {
		ArrayDeque<String> L = new ArrayDeque();
		L.addFirst("a");
		L.addLast("b");
		L.addLast("c");
		L.printDeque();
	}

}