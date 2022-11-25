import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void testInsert(){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(25);
        assertEquals(25, bst.root.data);
        bst.insert(45);
        bst.insert(15);
        assertEquals(45, bst.root.rightChild.data);
        assertEquals(15, bst.root.leftChild.data);
    }

    @Test
    public void testOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 5);
        Album a2 = new Album(2, artistNames, "album 2", 12);
        Album a3 = new Album(3, artistNames, "album 3", 13);
        Album a4 = new Album(4, artistNames, "album 4", 14);
        Album a5 = new Album(5, artistNames, "album 5", 11);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3;
        bst.insert(a4);
        bst.insert(a5);
        assertEquals("5 15 25 45 55 ", bst.orderTraversal(0));
        assertEquals("25 15 5 45 55 ", bst.orderTraversal(-1));
        assertEquals("5 15 55 45 25 ", bst.orderTraversal(1));
    }

    @Test
    public void testDelete() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(25);
        bst.insert(45);
        bst.insert(15);
        bst.insert(5);
        bst.insert(55);

        bst.delete(55);
        assertEquals("5 15 25 45 ", bst.orderTraversal(0));
        assertEquals(null, bst.root.rightChild.rightChild);
        assertEquals(45, bst.root.rightChild.data);
    }

    @Test
    public void testMinValue() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(25);
        bst.insert(45);
        bst.insert(15);
        bst.insert(5);
        bst.insert(55);
        bst.insert(35);

        assertEquals(5, bst.minvalue(bst.root));
        assertEquals(35, bst.minvalue(bst.root.rightChild));
    }
}