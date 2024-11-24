public class Node {
    int byte_value;
    int frequency;
    Node left_node;
    Node right_node;

    public Node(int byte_value, int frequency) {

        this.byte_value = byte_value;
        this.frequency = frequency;
        left_node = null;
        right_node = null;

    }
}
