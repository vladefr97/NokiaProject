package tasks.task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    BinarySearchTree<String> binarySearchTree;
    BinarySearchTree<Integer> integerBinarySearchTree;
    @Before
    public void setUp() throws Exception {
        binarySearchTree = new BinarySearchTree<>();
        integerBinarySearchTree = new BinarySearchTree<>();
    }

    @After
    public void tearDown() throws Exception {
        binarySearchTree = null;
        integerBinarySearchTree = null;
    }

    @Test
    public void contains() {
        binarySearchTree.add("Elem");
        assertEquals(true,binarySearchTree.contains("Elem"));
    }

    @Test
    public void add() {
        binarySearchTree.add("раз");
        binarySearchTree.add("два");

        assertEquals("раз",binarySearchTree.last());
        assertEquals("два",binarySearchTree.first());

        integerBinarySearchTree.add(1);
        integerBinarySearchTree.add(2);
        integerBinarySearchTree.add(-4);
        assertEquals(new Integer(2),integerBinarySearchTree.last());
    }

    @Test
    public void remove() {

        binarySearchTree.add("Elem");

        assertEquals(true,binarySearchTree.contains("Elem"));
        assertEquals(true,binarySearchTree.remove("Elem"));
        assertEquals(false,binarySearchTree.contains("Elem"));

    }

    @Test
    public void first() {
    }

    @Test
    public void last() {
    }

    @Test
    public void size() {
        integerBinarySearchTree.add(1);
        integerBinarySearchTree.add(2);
        integerBinarySearchTree.add(-4);

        assertEquals(3,integerBinarySearchTree.size());

    }

    @Test
    public void treeHeight() {
        assertEquals(0,integerBinarySearchTree.treeHeight());
        integerBinarySearchTree.add(1);
        integerBinarySearchTree.add(2);
        integerBinarySearchTree.add(-4);
        assertEquals(1,integerBinarySearchTree.treeHeight());

        integerBinarySearchTree.add(-6);
        assertEquals(2,integerBinarySearchTree.treeHeight());

        integerBinarySearchTree.add(3);
        assertEquals(2,integerBinarySearchTree.treeHeight());



    }
}