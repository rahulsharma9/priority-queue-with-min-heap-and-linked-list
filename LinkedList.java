
public class LinkedList implements PriorityQueue {
	
	static class Node{
		int item;
		Node next;
		
		Node(int item){
			this.item = item;
			this.next = null;
		}
	}
	
	private int numOfItems;
	private int MAX = 10000;
	Node head = null;
	Node tail = null;
	
	LinkedList(){
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
		
		if(numOfItems == MAX) {
			System.out.println("Cannot insert because priority list is already full!");
			return;
		}
		
		numOfItems++;
		
		Node node = new Node(x);
		
	    if(head == null) {  
            head = node;
            tail = node;
        }
	    else{
	    	tail.next = node;
	    	tail = node;
	    }

	    
    	Node current = head;
    	Node index = null;
    	int temp;
    	
    	while(current != null) {
    		index = current.next;
    		while(index != null) {
    			if(current.item > index.item) {
    				temp = current.item;
    				current.item = index.item;
    				index.item = temp;
    			}
    			index = index.next;
    		}
    		current = current.next;
    	}
		
	}

	@Override
	public int delete() {
		if(numOfItems == 0) {
			System.out.println("Cannot delete becuase the priority list is empty!");
		}
		int temp = head.item;
		head = head.next;
		numOfItems--;
		return temp;
	}

	@Override
	public void makeEmpty() {
		this.head = null;
		numOfItems = 0;
	}
	
	@Override
	public String toString() {
		StringBuilder list = new StringBuilder("");
        Node temp;
        temp = head;
        while(temp.next != null)
        {
            list.append(temp.item + " ");
            temp = temp.next;
        }
        list.append(temp.item);
        return list.toString();
	}
	
	

}
