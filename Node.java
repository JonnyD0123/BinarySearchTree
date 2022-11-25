public class Node {

    protected Album album;
    protected Integer data;
    protected Node leftChild;
    protected Node rightChild;

    public Node(Integer data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    public Node(Album album) {
        this.album = album;
        this.leftChild = null;
        this.rightChild = null;
    }
}
