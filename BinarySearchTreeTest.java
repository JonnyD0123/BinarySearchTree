import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void testInsert(){
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 5);
        Album a2 = new Album(2, artistNames, "album 2", 4);
        Album a3 = new Album(3, artistNames, "album 3", 13);

        bst.insert(a1);
        assertEquals(5, bst.root.album.numSongs);

        bst.insert(a2);
        bst.insert(a3);
        assertEquals(4, bst.root.leftChild.album.numSongs);
        assertEquals(13, bst.root.rightChild.album.numSongs);
    }

    @Test
    public void testOrderTraversal() {
        BinarySearchTree bst = new BinarySearchTree();

        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 4);
        Album a2 = new Album(2, artistNames, "album 2", 5);
        Album a3 = new Album(3, artistNames, "album 3", 13);
        Album a4 = new Album(4, artistNames, "album 4", 14);
        Album a5 = new Album(5, artistNames, "album 5", 11);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);
        assertEquals("4 5 11 13 14 ", bst.orderTraversal(0));
        assertEquals("4 5 13 11 14 ", bst.orderTraversal(-1));
        assertEquals("11 14 13 5 4 ", bst.orderTraversal(1));
    }

    @Test
    public void testDelete() {
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 25);
        Album a2 = new Album(2, artistNames, "album 2", 45);
        Album a3 = new Album(3, artistNames, "album 3", 15);
        Album a4 = new Album(4, artistNames, "album 4", 5);
        Album a5 = new Album(5, artistNames, "album 5", 55);
        Album a6 = new Album(6, artistNames, "album 6", 35);

        //returns null because list is empty
        bst.delete(a1);

        //returns null because Album a6 is not found in list
        bst.delete(a6);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);

        bst.delete(a5);
        assertEquals("5 15 25 45 ", bst.orderTraversal(0));
        assertEquals(null, bst.root.rightChild.rightChild);
        assertEquals(45, bst.root.rightChild.album.numSongs);
    }

    @Test
    public void testMinValue() {
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 25);
        Album a2 = new Album(2, artistNames, "album 2", 45);
        Album a3 = new Album(3, artistNames, "album 3", 15);
        Album a4 = new Album(4, artistNames, "album 4", 5);
        Album a5 = new Album(5, artistNames, "album 5", 55);
        Album a6 = new Album(6, artistNames, "album 6", 35);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);
        bst.insert(a6);

        assertEquals(5, bst.minvalue(bst.root));
        assertEquals(35, bst.minvalue(bst.root.rightChild));
    }

    @Test
    public void testContains() {
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 25);
        Album a2 = new Album(2, artistNames, "album 2", 45);
        Album a3 = new Album(3, artistNames, "album 3", 15);
        Album a4 = new Album(4, artistNames, "album 4", 5);
        Album a5 = new Album(5, artistNames, "album 5", 55);
        Album a6 = new Album(6, artistNames, "album 6", 35);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);

        assertEquals(true, bst.contains(a1));
        assertEquals(true, bst.contains(a3));
        assertEquals(false, bst.contains(a6));
    }

    @Test
    public void testToString() {
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 25);
        Album a2 = new Album(2, artistNames, "album 2", 45);
        Album a3 = new Album(3, artistNames, "album 3", 15);
        Album a4 = new Album(4, artistNames, "album 4", 5);
        Album a5 = new Album(5, artistNames, "album 5", 55);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);

        assertEquals("25 15 45 5 N N 55 N N N N ", bst.toString());
    }

    @Test
    public void testStoreBSTNodes() {
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 25);
        Album a2 = new Album(2, artistNames, "album 2", 45);
        Album a3 = new Album(3, artistNames, "album 3", 15);
        Album a4 = new Album(4, artistNames, "album 4", 5);
        Album a5 = new Album(5, artistNames, "album 5", 55);
        Album a6 = new Album(6, artistNames, "album 6", 35);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);

        ArrayList<Node> nodes = new ArrayList<>();
        bst.storeBSTNodes(bst.root, nodes);
        assertEquals(5, nodes.size());
    }

    @Test
    public void testBuildTree() {
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 25);
        Album a2 = new Album(2, artistNames, "album 2", 45);
        Album a3 = new Album(3, artistNames, "album 3", 15);
        Album a4 = new Album(4, artistNames, "album 4", 5);
        Album a5 = new Album(5, artistNames, "album 5", 55);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);

        ArrayList<Node> nodes = new ArrayList<>();
        bst.storeBSTNodes(bst.root, nodes);
        assertEquals(25, bst.buildTree(nodes, 0, nodes.size()-1).album.numSongs);
    }

    @Test
    public void testRebalance() {
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 1);
        Album a2 = new Album(2, artistNames, "album 2", 2);
        Album a3 = new Album(3, artistNames, "album 3", 3);
        Album a4 = new Album(4, artistNames, "album 4", 4);
        Album a5 = new Album(5, artistNames, "album 5", 5);
        Album a6 = new Album(6, artistNames, "album 6", 6);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);
        bst.insert(a6);

        System.out.println(bst.toString());
        System.out.println(bst.rebalance().toString());
        assertEquals("4 2 6 1 3 5 N N N N N N N ", bst.rebalance().toString());
    }

    @Test
    public void testPartition() {
        BinarySearchTree bst = new BinarySearchTree();
        ArrayList<String> artistNames = new ArrayList<>();
        artistNames.add("Artist 1");
        artistNames.add("Artist 2");

        Album a1 = new Album(1, artistNames, "album 1", 25);
        Album a2 = new Album(2, artistNames, "album 2", 45);
        Album a3 = new Album(3, artistNames, "album 3", 15);
        Album a4 = new Album(4, artistNames, "album 4", 5);
        Album a5 = new Album(5, artistNames, "album 5", 55);
        Album a6 = new Album(6, artistNames, "album 6", 35);
        Album a7 = new Album(7, artistNames, "album 7", 40);

        bst.insert(a1);
        bst.insert(a2);
        bst.insert(a3);
        bst.insert(a4);
        bst.insert(a5);
        bst.insert(a7);

        assertEquals("[ID: 2 NUM_SONGS: 45 -- ARTIST NAMES: [Artist 1, Artist 2], " +
                "ID: 7 NUM_SONGS: 40 -- ARTIST NAMES: [Artist 1, Artist 2], " +
                "ID: 5 NUM_SONGS: 55 -- ARTIST NAMES: [Artist 1, Artist 2]]", bst.partition(a6).toString());
    }
}