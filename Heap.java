
public class Heap implements PriorityQueue{
	
	private int CAPACITY = 10000;
	private int items[];
	private int numOfItems;
	
	Heap(){
		items = new int[CAPACITY];
		numOfItems = 0;
	}
	
	private int parent(int i) {
		int parent = (i-1)/2;
		return parent;
	}
	
	private int leftChild(int i) {
		int leftChild = 2*i+1;
		return leftChild;
	}
	
	private int rightChild(int i) {
		int rightChild = 2*i+2;
		return rightChild;
	}

	@Override
	public boolean isEmpty() {
		return numOfItems == 0;
	}

	@Override
	public int size() {
		return numOfItems;
	}

	@Override
	public void insert(int x) {
		if(numOfItems == CAPACITY) {
			System.out.println("Cannot insert because underlying array of the priority list is full!");
			return;
		}
		numOfItems++;
		int child = numOfItems-1;
		while (child > 0 && items[parent(child)] > x) {
			items[child] = items[parent(child)];
			child = parent(child);
		}
		items[child] = x;
	}

	@Override
	public int delete() {
		int result = 0;
		if(numOfItems == 0) {
			System.out.println("Cannot delete becuase the priority list is empty!");
		}
		else {
			result = items[0];
			int temp = items[numOfItems - 1];
			numOfItems--;
			int current = 0;
			
			while(leftChild(current) < numOfItems) {
				int child = leftChild(current);
				if(rightChild(current) < numOfItems && items[child] > items[rightChild(current)]) {
					child = rightChild(current);
				}
				if(temp > items[child]) {
					items[current] = items[child];
					current = child;
				}
				else {
					break;
				}
			}
			items[current] = temp;
		}
		return result;
	}

	@Override
	public void makeEmpty() {
		int[] temp = new int[CAPACITY];
		items = temp;
		numOfItems = 0;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < numOfItems; i++) {
			str = str + items[i] + " ";
		}
		return str;
	}

}
