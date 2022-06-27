import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest{
    //~ Constructor ........................................................
    @Test
    public void testConstructor(){
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore(){
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        
        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );
        testDLL.insertBefore(9,9);        
        assertEquals( "Checking insertBefore to a list containing 9 elements at position 9 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9,9", testDLL.toString() );
        testDLL.insertBefore(0,10);        
        assertEquals( "Checking insertBefore to a list containing 10 elements at position 0 - expected the element at the head of the list", "10,7,4,5,6,1,2,3,8,9,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );


    }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    @Test
    public void testGet(){
     DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,4);
        testDLL.insertBefore(3,8);
        testDLL.insertBefore(4,16);
        
        assertEquals( "Checking get to a list containing 5 elements at position 0 - expected the element at position 0", "1", testDLL.get(0).toString());
        assertEquals( "Checking get to a list containing 5 elements at position 1 - expected the element at position 1", "2", testDLL.get(1).toString());
        assertEquals( "Checking get to a list containing 5 elements at position 2 - expected the element at position 2", "4", testDLL.get(2).toString());
        assertEquals( "Checking get to a list containing 5 elements at position 3 - expected the element at position 3", "8", testDLL.get(3).toString());
        assertEquals( "Checking get to a list containing 5 elements at position 4 - expected the element at position 4", "16", testDLL.get(4).toString());
        
        testDLL.insertBefore(4,32);
        assertEquals( "Checking get to a list containing 6 elements at position 0 - expected the element at position 0", "1", testDLL.get(0).toString());
        assertEquals( "Checking get to a list containing 6 elements at position 1 - expected the element at position 1", "2", testDLL.get(1).toString());
        assertEquals( "Checking get to a list containing 6 elements at position 2 - expected the element at position 2", "4", testDLL.get(2).toString());
        assertEquals( "Checking get to a list containing 6 elements at position 3 - expected the element at position 3", "8", testDLL.get(3).toString());
        assertEquals( "Checking get to a list containing 6 elements at position 4 - expected the element at position 4", "32", testDLL.get(4).toString());
        assertEquals( "Checking get to a list containing 6 elements at position 5 - expected the element at position 5", "16", testDLL.get(5).toString());
       
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking get to a list containing 1 elements at position 0 - expected the element at position 0", "1", testDLL.get(0).toString());
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking get to a list containing 1 elements at position 10 - expected the element at position 10", null, testDLL.get(10));
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking get to a list containing 1 elements at position -10 - expected the element at position -10", null, testDLL.get(-10));

        DoublyLinkedList<Integer> testEmptyDLL = new DoublyLinkedList<Integer>();
        assertEquals( "Checking get to an empty list at position 1 - expected null", null, testEmptyDLL.get(1));
        
    }
    
    
    
    @Test
    public void testDeleteAt(){
     DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,4);
        testDLL.insertBefore(3,8);
        testDLL.insertBefore(4,16);
        testDLL.insertBefore(5,32);
        assertEquals( "Checking insertBefore to a list containing 6 elements ", "1,2,4,8,16,32", testDLL.toString() );
        
        testDLL.deleteAt(0);        
        assertEquals( "Checking delete a node in a list containing 6 elements at position 0", "2,4,8,16,32", testDLL.toString());
        testDLL.deleteAt(4);        
        assertEquals( "Checking delete a node in a list containing 5 elements at position 4", "2,4,8,16", testDLL.toString());
        boolean falseEmpty1 = testDLL.deleteAt(10);
        assertEquals( "Checking delete a node in a list containing 5 element at position 10 - expected false", false, falseEmpty1);
        boolean falseEmpty2 = testDLL.deleteAt(-10);
        assertEquals( "Checking delete a node in a list containing 5 element at position -10 - expected false", false, falseEmpty2);
        
        //test list with one element
        DoublyLinkedList<Integer> oneDLL = new DoublyLinkedList<Integer>();
        oneDLL.insertBefore(0,1);
        assertEquals( "Checking insertBefore to a list containing 1 elements - expected list", "1", oneDLL.toString() );
        boolean oneElement = oneDLL.deleteAt(0);
        assertEquals( "Checking insertBefore to a list containing 1 elements - expected list", true, oneElement );
        
        //test empty
        DoublyLinkedList<Integer> testEmptyDLL = new DoublyLinkedList<Integer>();
        boolean trueEmpty = testEmptyDLL.deleteAt(1);
        assertEquals( "Checking delete an empty list at position 1 - expected false", false, trueEmpty);

    }
    
 @Test
    public void testReverse(){
     DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(3,4);
        testDLL.insertBefore(4,5);
        testDLL.insertBefore(5,6);
        assertEquals( "Checking get to a list containing 6 elements", "1,2,3,4,5,6", testDLL.toString());
        testDLL.reverse();
        
        assertEquals( "Checking reverse a list order containing 6 elements", "6,5,4,3,2,1", testDLL.toString());
    
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.reverse();
        assertEquals( "Checking reverse when there is only one node", "1", testDLL.toString());

    	// test empty list
    	DoublyLinkedList<Integer> emptyTest = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> testEmptyDLL = new DoublyLinkedList<Integer>();
        testEmptyDLL.reverse();
        assertEquals( "Checking deleteAt to an empty list at position 2 ", emptyTest.toString(), testEmptyDLL.toString());
    }
    
    
    
    @Test
    public void testMakeUnique(){
     DoublyLinkedList<Integer> testDLL1 = new DoublyLinkedList<Integer>();
        testDLL1.insertBefore(0,1);
        testDLL1.insertBefore(1,2);
        testDLL1.insertBefore(2,3);
        testDLL1.insertBefore(3,4);
        testDLL1.insertBefore(4,3);
        assertEquals( "Checking get to a list containing 5 elements", "1,2,3,4,3", testDLL1.toString() );
        testDLL1.makeUnique();        
        assertEquals( "Checking makeUnique to delete a node that show up more than once", "1,2,3,4", testDLL1.toString());

        DoublyLinkedList<Integer> testDLL2 = new DoublyLinkedList<Integer>();
        testDLL2.insertBefore(0,1);
        testDLL2.insertBefore(1,1);
        testDLL2.insertBefore(2,1);
        testDLL2.insertBefore(3,2);
        testDLL2.insertBefore(4,2);
        testDLL2.insertBefore(5,2);
        assertEquals( "expected the element at the tail of the list", "1,1,1,2,2,2", testDLL2.toString() );
        testDLL2.makeUnique();
        assertEquals( "Checking deleteAt to a list - expected the element at the tail of the list", "1,2", testDLL2.toString() );
        
    	// empty list
    	DoublyLinkedList<Integer> emptyTest = new DoublyLinkedList<Integer>();
        DoublyLinkedList<Integer> testEmptyDLL = new DoublyLinkedList<Integer>();
        testEmptyDLL.makeUnique();
        assertEquals( "Checking deleteAt to an empty list - expected false", emptyTest.toString(), testEmptyDLL.toString());
 
    }
    
    @Test
    public void testPush(){
     DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        testDLL.push(3);
        testDLL.push(4);
        testDLL.push(5);
        
        
        assertEquals( "Checking get to a list containing 5 elements", "5,4,3,2,1", testDLL.toString());
    }
    
    @Test
    public void testPop(){
     DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(1);
        testDLL.push(2);
        assertEquals( "Checking get to a list containing 2 elements", "2,1", testDLL.toString());
    	String test = testDLL.pop().toString();
    	assertEquals( "Checking get to a list containing 1 elements", "2", test );
    	testDLL.pop();
    	testDLL.pop();
    	assertEquals( "Checking get to a list containing no elements", null, testDLL.pop() );
                
  }

    @Test
    public void testEnqueue(){
     DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        testDLL.enqueue(4);
        testDLL.enqueue(5);
                
        assertEquals( "Checking get to a list containing 4 elements at position 0 - expected the element at position 0", "1,2,3,4,5", testDLL.toString());
    }
    
    @Test
    public void testDequeue(){
     DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        testDLL.enqueue(2);
    	assertEquals( "Checking get to a list containing 2 elements", "1,2", testDLL.toString() );
    	String testItem = testDLL.dequeue().toString();
    	assertEquals( "Checking get to a list containing 1 elements", "1", testItem );
    	testDLL.dequeue();
    	testDLL.dequeue();
    	assertEquals( "Checking get to a list containing no elements", null, testDLL.dequeue() );
   }
    

}

	