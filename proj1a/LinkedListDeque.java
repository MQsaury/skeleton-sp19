public class LinkedListDeque<Flag> {

	public class AnyNode {
		public Flag item;
		public AnyNode next;
		public AnyNode last;

		public AnyNode(Flag i, AnyNode n, AnyNode l) {
			item = i;
			next = n;
			last = l;
		}
	}

	private AnyNode items;
	private int size;
	public AnyNode sentinel;
	private AnyNode front;
	private AnyNode rear;

// Create empty Deque
	public LinkedListDeque() {
		size = 0;
		sentinel = new AnyNode(null, null, null);
		front = sentinel;
		rear = sentinel;
	}

	public LinkedListDeque(LinkedListDeque other) {
		size = 0;
		sentinel = new AnyNode(null, null, null);
		front = sentinel;
		rear = sentinel;

		for(int i=0; i<other.size; i++) {
			//this.addLast((Flag)other.get(i));
			this.addLast((Flag)other.get(i));
		}
	}

	public void addFirst(Flag x) {
		size = size +1;
		sentinel.next = new AnyNode(x,sentinel.next,sentinel);
		front = sentinel.next;
		if (front.next == null) {
			rear = sentinel.next;
		}
	}

	public void addLast(Flag x) {
		size = size +1;
		rear.next = new AnyNode(x,null,rear);
		rear = rear.next;
		if (sentinel.next.next == null) {
			front = sentinel.next;
		}
	}

	public boolean isEmpty() {
		if (size==0) {
			return true;
		} else return false;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
		AnyNode p = sentinel;
		for (int i=0;i<size;i++) {
			System.out.print(p.next.item+" ");
			p = p.next;
		}
		System.out.println("");
		System.out.println("");
	}

	public Flag removeFirst() {
		Flag store;
		if (size == 0) {
			return null;
		} else {
			size = size - 1;
			store = front.item;
			sentinel.next = front.next;
			front = sentinel.next; 
			return store;
		}
	}

	public Flag removeLast() {
		Flag store;
		size = size -1;
		store = rear.item;
		AnyNode tmp = new AnyNode(rear.last.item,null,rear.last.last);
		// create a new last-rear node that points to null next 
		// and share the same node value, and point rear to there
		rear = tmp;
		return store;
	}

	public Flag get(int index) {
		if (index >= size) {
			return null;
		} else {
			AnyNode p = sentinel;
			for(int i=0;i<=index;i++) {
				p = p.next;
			}
			return p.item;
		}
	}



	private Flag size(AnyNode Node, int current_index) {
		if(current_index == 0) {
			return Node.item;
		} else {
			return size(Node.next, current_index-1);
		}
	}


	public Flag getRecursive(int index) {
		return size(sentinel.next,index);
	}


	public static void main(String[] args) {
		LinkedListDeque<String> L = new LinkedListDeque();
		L.addLast("a");
		L.addLast("b");
		L.addLast("c");
		L.printDeque();
		System.out.println("The third item is: " + L.getRecursive(0));
	}
}