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
            stb.append(current.album + " ");
            stb.append(this.inOrderTraversal(current.rightChild));
        }
        return stb.toString();
    }

    public String preOrderTraversal(Node current){
        StringBuilder stb = new StringBuilder();
        if(current != null) {
            stb.append(current.album + " ");
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
            stb.append(current.album + " ");
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
}
