import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;
//    to check leaf node or internal node
//    if (current.left == null && current.right == null) {
//        return null;
//    }
    BinaryTree(){
        root = null;
    }
    BinaryTree(Node root){
        this.root = root;
    }

    public void add(String value, boolean answer) {
        root = addRecursive(root, value, answer);
        if(isInternalNode(root)){
            System.out.println(root.value + "Added as internal node");
        }
        else if (isChildNode(root)){
            System.out.println(root.value + "Added as child node");
        }
    }
    private Node addRecursive(Node current, String value, boolean answer) {
        if (current == null) {
            return new Node(value);
        }

        if (answer == true)
        {
            if (current.left == null){
                current.left = new Node(value);
            }
            else{
                current.left = addRecursive(current.left,value,answer);
            }
        }
        else if (answer == false) {
            if (current.right == null){
                current.right = new Node(value);
            }
            else{
                current.right = addRecursive(current.right,value,answer);
            }
        }
        return current;
    }

    private boolean containsNodeRecursive(Node current, String value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
//        return value < current.value
//                ? containsNodeRecursive(current.left, value)
//                : containsNodeRecursive(current.right, value);
        return false;
    }

    private Node deleteRecursive(Node current, String value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // ... code to delete the node will go here
        }
//        if (value < current.value) {
//            current.left = deleteRecursive(current.left, value);
//            return current;
//        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    public boolean isInternalNode(Node node){
        if(node.left != null && node.right !=null){
            return true;
        }
        return false;
    }
    public boolean isChildNode(Node node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }

    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
}
