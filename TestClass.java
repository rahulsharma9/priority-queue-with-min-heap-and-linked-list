
public class TestMinHeap {

	public static void main(String[] args) {
		
		Heap minHeap = new Heap();
		LinkedList sortedList = new LinkedList();
		final int NUMBER_OF_ELEMENTS = 10000;
		
		int[] temp = new int[NUMBER_OF_ELEMENTS];
		for(int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
			int x = (int) (Math.random()*100) + 1;
			temp[i] = x;
		}
		
		long startTime1 = System.currentTimeMillis();
		for(int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
			sortedList.insert(temp[i]);
		}
	    long endTime1 = System.currentTimeMillis();
	    System.out.println("When adding 10,000 numbers (generated randomly) to sorted list, time taken is: " + (endTime1 - startTime1) + " milliseconds.");
	    
	    
	    long startTime2 = System.currentTimeMillis();
		for(int i = 0; i < NUMBER_OF_ELEMENTS; i++) {
			minHeap.insert(temp[i]);
		}
	    long endTime2 = System.currentTimeMillis();
		System.out.println("When adding same 10,000 random numbers to heap, time taken is: " + (endTime2 - startTime2) + " milliseconds.");
		
		System.out.println("The Min-Heap: ");
		System.out.println(minHeap.toString());
		
		System.out.println("The Sorted Linked List: ");
		System.out.println(sortedList.toString());
		
		
		minHeap.delete();
		System.out.println("The Min-Heap after deleting highest priorty element: ");
		System.out.println(minHeap.toString());
		
		sortedList.delete();
		System.out.println("The Sorted Linked List after deleting highest priorty element: ");
		System.out.println(sortedList.toString());
		
	
	}

}
