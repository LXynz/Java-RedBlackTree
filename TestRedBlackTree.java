import org.junit.Test;
import static org.junit.Assert.*;

public class TestRedBlackTree {
    @Test
    //This test method will test the insertion case1. Which parent is red, and uncle is red
    public void TestForRBT_Case1(){
        RedBlackTree<Integer> node = new RedBlackTree<Integer>();
        node.insert(23);
        node.insert(41);
        node.insert(7);
        node.insert(6);
        if(!(node.root.isBlack || 
        		node.root.rightChild.isBlack || 
        		node.root.leftChild.isBlack || 
        		!node.root.leftChild.leftChild.isBlack))
        	fail("Color error");
        
        if(!node.toString().equals("[23, 7, 41, 6]"))
        	fail("The rotation is not right");
    }

    //This test method will test the insertion case2.1, which uncle is black, and child is same side of parent
    /*    Before          After
	 *    [gp-b]         [p-b]
	 *     /  \           /  \
	 *   [p-r][u-b]  [new-r] [gp-r]
	 *   /      \       /      \
	 * [new-r]                   [u-b]
	 *   
	 */
    @Test
    public void TestForRBT_Case2_1() {
        RedBlackTree<Integer> node = new RedBlackTree<Integer>();
        node.insert(69);
        node.insert(33);
        node.insert(31);
        if(!node.root.isBlack || 
        		node.root.rightChild.isBlack || 
        		node.root.leftChild.isBlack)
        	fail("Color error");
        if(!node.toString().equals("[33, 31, 69]"))
            fail("The rotation is not right");
    }
    
    //This test method will test the insertion case2.2, which uncle is black, and child is opposite side of parent
	/*    Before          After
	 *    [gp-b]         [new-b]
	 *     /  \           /  \
	 *   [p-r][u-b]    [p-r] [gp-r]
	 *     \     \       /      \
	 *    [new-r]              [u-b]
	 */    
	 @Test
    public void TestForRBT_Case2_2() {
        RedBlackTree<Integer> node = new RedBlackTree<Integer>();
        node.insert(69);
        node.insert(33);
        node.insert(43);
        if(!node.root.isBlack || 
        		node.root.rightChild.isBlack || 
        		node.root.leftChild.isBlack)
        	fail("Color error");
        if(!node.toString().equals("[43, 33, 69]"))
            fail("The rotation is not right");
    }
    
    //This test method will test the insertion case2.3, which uncle is black, and child is same side of parent
    /*    Before          After
	 *    [gp-b]         [p-b]
	 *     /  \           /  \
	 *   [u-b][p-r]  [gp-r] [new-r]
	 *   /      \       /      \
	 *       [new-r] [u-b]
	 *   
	 */
    @Test
    public void TestForRBT_Case2_3() {
        RedBlackTree<Integer> node = new RedBlackTree<Integer>();
        node.insert(33);
        node.insert(43);
        node.insert(53);
        if(!node.root.isBlack || 
        		node.root.rightChild.isBlack || 
        		node.root.leftChild.isBlack)
        	fail("Color error");
        if(!node.toString().equals("[43, 33, 53]"))
            fail("The rotation is not right");
    }
    
}
