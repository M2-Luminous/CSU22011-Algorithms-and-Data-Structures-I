import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  TODO
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
  //TODO write more tests here.

  
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree",
             "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

 	@Test
 	public void testContains() {
 		BST<Integer, Integer> bst = new BST<Integer, Integer>();
 		assertEquals("Checking empty tree", false, bst.contains(null));
     
 		bst.put(7, 7);   //        _7_
 		bst.put(8, 8);   //      /     \
 		bst.put(3, 3);   //    _3_      8
 		bst.put(1, 1);   //  /     \
 		bst.put(2, 2);   // 1       6
 		bst.put(6, 6);   //  \     /
 		bst.put(4, 4);   //   2   4
 		bst.put(5, 5);   //        \
 						 //         5
 		
 		assertEquals("Checking constructed tree", true, bst.contains(7));
 		assertEquals("Checking constructed tree", true, bst.contains(8));
 		assertEquals("Checking constructed tree", true, bst.contains(3));
 		assertEquals("Checking constructed tree", true, bst.contains(1));
 		assertEquals("Checking constructed tree", true, bst.contains(2));
 		assertEquals("Checking constructed tree", true, bst.contains(6));
 		assertEquals("Checking constructed tree", true, bst.contains(4));
 		assertEquals("Checking constructed tree", true, bst.contains(5));
 		
 		bst.put(3, 5);
 		bst.put(0, 9);
 		bst.put(0, null);

 }
  
 	@Test
 	public void testGet() {
 		BST<Integer, Integer> bst = new BST<Integer, Integer>();
 		assertEquals("Getting empty tree", null, bst.get(null));
     
 		bst.put(7, 7);   //        _7_
 		bst.put(8, 8);   //      /     \
 		bst.put(3, 3);   //    _3_      8
 		bst.put(1, 1);   //  /     \
 		bst.put(2, 2);   // 1       6
 		bst.put(6, 6);   //  \     /
 		bst.put(4, 4);   //   2   4
 		bst.put(5, 5);   //        \
 						 //         5
 		
 		assertEquals("Getting constructed tree", "7", bst.get(7).toString());
 		assertEquals("Getting constructed tree", "8", bst.get(8).toString());
 		assertEquals("Getting constructed tree", "3", bst.get(3).toString());
 		assertEquals("Getting constructed tree", "1", bst.get(1).toString());
 		assertEquals("Getting constructed tree", "2", bst.get(2).toString());
 		assertEquals("Getting constructed tree", "6", bst.get(6).toString());
 		assertEquals("Getting constructed tree", "4", bst.get(4).toString());
 		assertEquals("Getting constructed tree", "5", bst.get(5).toString());

 }
 	
 	
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
         
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
         
         bst.delete(4);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()5()))7())", bst.printKeysInOrder());
         
         bst.delete(2);
         bst.delete(5);
         bst.delete(1);
         bst.delete(7);
     }

     @Test
     public void testHeight() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         assertEquals("Checking height of no tree existed", -1, bst.height());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking height of constructed tree", 4, bst.height());
          
         bst.delete(8);
         assertEquals("Checking height of the tree after deleting leaf", 4, bst.height());
 
         bst.delete(6);
         assertEquals("Checking height of the tree after deleting node with single child", 3, bst.height());
 
         bst.delete(3);
         assertEquals("Checking height of the tree after deleting node with two children", 3, bst.height());
     }
     
     @Test
     public void testKeysInOrder() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         assertEquals("Testing empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         assertEquals("Testing one node tree", "(()7())", bst.printKeysInOrder());
         bst.put(8, 8);   //      /     \
         assertEquals("Testing two node tree", "(()7(()8()))", bst.printKeysInOrder());
         bst.put(3, 3);   //    _3_      8
         assertEquals("Testing three node tree", "((()3())7(()8()))", bst.printKeysInOrder());
         bst.put(1, 1);   //  /     \
         assertEquals("Testing one node tree", "(((()1())3())7(()8()))", bst.printKeysInOrder());
         bst.put(2, 2);   // 1       6
         assertEquals("Testing one node tree", "(((()1(()2()))3())7(()8()))", bst.printKeysInOrder());
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(0);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
     }
     
     @Test
     public void testMedian() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         assertEquals("Checking median of empty tree", null, bst.median());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking median of constructed tree", "4", bst.median().toString());
         
         bst.delete(8);
         assertEquals("Checking median of constructed tree after deleting leaf", "4", bst.median().toString());
 
     }
}
