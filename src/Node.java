public class Node {
    int byte_value;
    int frequency;
    Node left;
    Node right;

    public Node(int byte_value, int frequency) {

        this.byte_value = byte_value;
        this.frequency = frequency;
        left = null;
        right = null;

    }
}
