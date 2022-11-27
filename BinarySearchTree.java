import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    protected Node root;

    public BinarySearchTree(){
        this.root = null;
    }

    public void insert(Album album) {
        this.root = this.insert(this.root, album);
    }

    public Node insert(Node current, Album album){
        if(current==null) return new Node(album);
        if(current.album.compareTo(album)>0)
            current.leftChild = insert(current.leftChild, album);
        if(current.album.compareTo(album)<0)
            current.rightChild = insert(current.rightChild, album);
        return current;
    }

    public String inOrderTraversal(){
        return this.inOrderTraversal(this.root);
    }

    public String inOrderTraversal(Node current){
        StringBuilder stb = new StringBuilder();
        if(current != null) {
            stb.append(this.inOrderTraversal(current.leftChild));
            stb.append(current.album.numSongs + " ");
            stb.append(this.inOrderTraversal(current.rightChild));
        }
        return stb.toString();
    }

    public String preOrderTraversal(Node current){
        StringBuilder stb = new StringBuilder();
        if(current != null) {
            stb.append(current.album.numSongs + " ");
            stb.append(this.preOrderTraversal(current.leftChild));
            stb.append(this.preOrderTraversal(current.rightChild));
        }
        return stb.toString();
    }

    public String postOrderTraversal(Node current){
        StringBuilder stb = new StringBuilder();
        if(current != null) {
            stb.append(this.postOrderTraversal(current.leftChild));
            stb.append(this.postOrderTraversal(current.rightChild));
            stb.append(current.album.numSongs + " ");
        }
        return stb.toString();
    }

    public String orderTraversal(int order){
        if(order == 0) return this.inOrderTraversal(this.root);
        if(order == -1) return this.preOrderTraversal(this.root);
        if(order == 1) return this.postOrderTraversal(this.root);
        return "";
    }

    public void delete(Album album) {
        this.root = this.delete(this.root, album);
    }

    public Integer minvalue(Node current) {
        int minv = current.album.numSongs;
        while(current.leftChild != null) {
            minv = current.leftChild.album.numSongs;
            current = current.leftChild;
        }
        return minv;
    }

    public Node delete(Node current, Album album) {
        if(current==null) return null;
        if(album.compareTo(current.album)<0)
            current.leftChild = delete(current.leftChild, album);
        else if(album.compareTo(current.album)>0)
            current.rightChild = delete(current.rightChild, album);
        else {
            if (current.leftChild == null)
                return current.rightChild;
            else if (current.rightChild == null)
                return current.leftChild;
            current.data = minvalue(current.rightChild);
            current.rightChild = delete(current.rightChild, current.album);
        }
        return current;
    }

    public boolean contains(Album album) {
        return this.contains(this.root, album)!=null;
    }

    public Node contains(Node current, Album album) {
        if(current != null) {
            if (current.album.compareTo(album) == 0) {
                return current;
            }
            else if (current.album.compareTo(album) > 0) {
                return contains(current.leftChild, album);
            }
            else if (current.album.compareTo(album) < 0) {
                return contains(current.rightChild, album);
            }
        }
        return current;
    }

    public ArrayList<Node> storeBSTNodes(Node current, ArrayList<Node> nodes) {
        if(current != null) {
            storeBSTNodes(current.leftChild, nodes);
            nodes.add(current);
            storeBSTNodes(current.rightChild, nodes);
        }
        return nodes;
    }

    public Node buildTree(ArrayList<Node> nodes, int start, int end) {
        if (start > end) return null;
        int mid = (start + end)/2;
        Node current = nodes.get(mid);
        current.leftChild = buildTree(nodes, start, mid-1);
        current.rightChild = buildTree(nodes, mid+1, end);
        return current;
    }

    public Node rebalance() {
        ArrayList<Node> nodes = new ArrayList<>();
        nodes = storeBSTNodes(this.root, nodes);
        int n = nodes.size();
        return buildTree(nodes, 0, n-1);
    }

    public String toString(Node root) {
        StringBuilder stb = new StringBuilder();
        if (root == null) stb.append("N ");
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        stb.append(root.album.numSongs + " ");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node current = queue.remove();
                if(current.leftChild != null) {
                    queue.add(current.leftChild);
                    stb.append(current.leftChild.album.numSongs + " ");
                } else {
                    stb.append("N ");
                }
                if (current.rightChild != null) {
                    queue.add(current.rightChild);
                    stb.append(current.rightChild.album.numSongs + " ");
                } else {
                    stb.append("N ");
                }
            }
        }
        return stb.toString();
    }

    public String toString() {
        return this.toString(this.root);
    }

    public ArrayList<Album> partition(Album a) {
        ArrayList<Album> partitioned = new ArrayList<>();
        Node temp = this.root;
        if(temp == null) {
            try {
                throw new IllegalArgumentException("Cannot delete a node from an empty list");
            } catch (IllegalArgumentException e) {
                System.out.println("Empty List");
            }
        } else {
            while(temp!=null) {
                if(temp.album.numSongs.compareTo(a.numSongs)>0){
                    partitioned.add(temp.album);
                }
                temp = temp.rightChild;
            }
        }
        return partitioned;
    }



}
