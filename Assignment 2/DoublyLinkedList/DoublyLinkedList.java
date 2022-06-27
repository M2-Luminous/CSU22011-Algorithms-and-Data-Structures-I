import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode{
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head,tail;
    private int length;

    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    public DoublyLinkedList() {
      head = null;
      tail = null;
      this.length = 0;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     *  If the list has no element, then it has 0 length, then this is an empty list
     */
    public boolean isEmpty(){
    	return (this.length==0);
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     * 	There is only two while-loop(O(N)) in the whole function, and the worst case is passing through it and the others are all 
     *  if statement(O(1)), which means the worst case asymptotic running time cost will base on simple addition between O(N) and O(1)
     *  , and this will end up with a single O(N)  
  
     */
    public void insertBefore( int pos, T data ) {

        int size = 0;
        DLLNode temp = head;
        
        while(temp != null){
       	 temp = temp.next;
       	 size++;
        }
    	
    	if(isEmpty()) {
    		DLLNode newNode = new DLLNode(data,null,null);
    		head = newNode;
    		tail = head;
    	}
    	else {
	    	if(pos <= 0) {
	       	 DLLNode newNode = new DLLNode(data, null, head);
	    	 if(head != null){
	    		 head.prev = newNode;
	    	 }
	         head = newNode;
	    	}
	    	
	    	else if(pos >= length){
	    	DLLNode preTail = tail;
	    	DLLNode newNode = new DLLNode(data, preTail, null);
	    	preTail.next = newNode;
	    	tail = newNode;
	    	}
	    	
	    	else {
	       	 DLLNode mid = head;
	    	 int times = 0;
	      
	    	 while(times != (pos - 1)){
	    		 mid = mid.next;
	    		 times++;
	    	 }	      
	    	 DLLNode newNode = new DLLNode(data, null, null);
	    	 newNode.next = mid.next;
	    	 mid.next.prev = newNode;
	    	 mid.next = newNode;
	    	 newNode.prev = mid;   
	    	}	    	
    	}
    	length++;
    	
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     * There is only one while-loop(O(N)) in the whole function, and the worst case is passing through it and the others are all 
     *  if statements(O(1)), which means the worst case asymptotic running time cost will base on simple addition between O(N) and O(1)
     *  , and this will end up with a single O(N)  
     */
    public T get(int pos) {
        //TODO
      	int size = 0;
      	DLLNode count = head;
      	     
      	while(count != null){
      		count = count.next;
      	    size++;
      	}
      	if(!isEmpty() && pos < length && pos >= 0) {     
      		if(pos <= 0){
      			return head.data;
      		}
      		else if(pos > 0){
      			DLLNode temp = head;
      			int time = 0;
      	      
      			while(time != pos){
      				temp = temp.next;
      				time++;
      			}
      			return temp.data;
      		}      		
      	}
      	return null;
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     * There is only one for-loop(O(N)) in the whole function, and the worst case is passing through it and the others are all 
     *  if statements(O(1)), which means the worst case asymptotic running time cost will base on simple addition between O(N) and O(1)
     *  , and this will end up with a single O(N) 
     */
    public boolean deleteAt(int pos) {
    	if(!isEmpty() && pos < length && pos >= 0) {
	    	DLLNode temp = head;
	    	DLLNode beforeDeleteNode = head;
    		if(pos <= 0) {//delete head
    			if(length>1) {
	    			head = head.next;
	    			head.prev = null;//left arrow delete
	    			temp.next = null;//right arrow delete
    			}
    			else if(length == 1){
    				head = null;
    			}
    		}
    		else if(pos >= length-1) {//delete tail
    			temp = tail;
    			tail = tail.prev;
    			tail.next = null;//right arrow delete
    			temp.prev = null;//left arrow delete
    		}
    		else {//delete mid node
		    	for(int index = 0; index < pos - 1; index ++) {
		    		beforeDeleteNode = beforeDeleteNode.next;
	    		}
		    	DLLNode afterDeleteNode = beforeDeleteNode.next.next;
		    	beforeDeleteNode.next = afterDeleteNode;
		    	afterDeleteNode.prev = beforeDeleteNode;
    		}
    		length--;
	    	return true;
    	}
    	return false;
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: O(N)
     *
     * Justification:
     * There is only two while loops(O(N)) in the whole function, and the worst case is passing through it 
     * and the others are all if statements(O(1)), which means the worst case asymptotic running time cost will base on 
     * simple addition between O(N) and O(1), and this will end up with a single O(N) 
     */
    public void reverse(){
        //TODO
        if(!isEmpty()) {    
        	int size = 0;
        	DLLNode temp = head;
        	     
        	while(temp != null){
        		temp = temp.next;
        	    size++;
        	}
        	  
        	size = size - 1;
        	int index = size;
        	          	       
        	int count1 = 0;
        	while(count1 <= (index / 2)) {
        		int count2 = index - count1;
        	    T data1 = get(count1);
        	    T data2 = get(count2);
        	    
        	    deleteAt(count1);
        	    insertBefore(count1, data2);
        	    
        	    deleteAt(count2);
        	    insertBefore(count2, data1);
        	    
        	    count1++; 
        	}
        }
/*
      	int size = 0;
      	DLLNode count = head;
      	     
      	while(count != null){
      		count = count.next;
      	    size++;
      	}	
      	
     	 if(!isEmpty()) {
     		 int index = size - 2;
     		 for(DLLNode tempNode = tail.prev;
  				 tempNode != null;
  				 	tempNode = tempNode.prev) {			 
  			 insertBefore(size + 1, tempNode.data);
  			 	deleteAt(index--);
     		 }
     	 }
*/
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements unique.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: O(N^2)
     *
     * Justification:There are two nested for-loop(O(N)) in the whole function, and the worst case is passing through it 
     * and the others are all if statements(O(1)), which means the worst case asymptotic running time cost will base on 
     * the two nested loop as they form a running time cost O(N^2), after some simple addition between O(N^2) and O(1),
     * the result will then be simplified into a single O(N^2)
     * 
     *  TODO
     */
     public void makeUnique(){
         //TODO
         int size = 0;
         DLLNode count = head;
           	     
         while(count != null){
          	count = count.next;
            size++;
         }
           	
    	 

	    	for(int i = 0; i <= size - 1; i ++) {
	    		T data1 = get(i);     
	    		for(int j = i + 1; j <= size - 1 ; j ++) {
	    			T data2 = get(j);
	    			if (data1 == data2) {
	    				deleteAt(j);
	    		        size--; 
	    		        j--;//check whether there is another target or not
	    			}                                                                 
	    		}                            
	    	}                                                                                                         
     }
    	 /*
    	 if(!isEmpty()) {
	 		DLLNode temp1 = head;
	    	for(int i = 0; i < length - 1; i ++) {
	     		DLLNode temp2 = temp1.next;       
	    		for(int j = i + 1; j < length - 1 ; j ++) {
	    			if (temp1.data.compareTo(temp2.data) == 0) {
	    				temp2 = temp2.prev;                     
	    				j--;
	    				deleteAt(j+1);                          
	    			}                                           
	    			temp2 = temp2.next;                         
	    		}
	    		temp1 = temp1.next;                             
	    	}                                                   
    	 }             
       	*/
    	 
                                         


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     * As there is no loop inside the method
     * and all the codes run for only one time.
     * the total cost will then lead to O(1).
     * 
     */
    public void push(T item) {
		DLLNode newNode = new DLLNode(item,null,head);
    	head = newNode;
    	length++;
    	//LIFO
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     * As there is no loop inside the method
     * and all the codes run for only one time.
     * the total cost will then lead to O(1).
     */
    public T pop() {
      	if(isEmpty()) {
      		return null;
      	}
      	else {
      		DLLNode preHead = head;
      		head = head.next;
      		preHead.next = null;
      		length--;
      		return preHead.data;
      	}
      	//LIFO
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     * As there is no loop inside the method
     * and all the codes run for only one time.
     * the total cost will then lead to O(1).
     */
    public void enqueue(T item) 
    {
    	if (isEmpty()){
    		tail = new DLLNode(item,null,null);
        	head = tail;
        	length++;
        }
    	else {
    		DLLNode preTail = tail;
    		tail = new DLLNode(item, null, null);
        	preTail.next = tail;
        	length++;
        }
    	
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an enqueue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: O(1)
     *
     * Justification:
     * As there is no loop inside the method
     * and all the codes run for only one time.
     * the total cost will then lead to O(1).
     */
    public T dequeue() 
    {
    	if(isEmpty()) {
    		return null;
    	}
    	else {
    		DLLNode preHead = head;
    		head = preHead.next;
    		preHead.next = null;
    		length--;
    		return preHead.data;
    	}
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
    	  if (!isFirst)
    	  {
    		  s.append(",");
    	  } else {
    		  isFirst = false;
    	  }
    	  s.append(iter.data.toString());
      }
      return s.toString();
    }


}



