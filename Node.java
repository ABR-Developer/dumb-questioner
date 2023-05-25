public class Node {
        String value;
        boolean question;
        Node left;
        Node right;

        Node(String value) {
            this.value = value;
            question = false;
            right = null;
            left = null;
        }
}
