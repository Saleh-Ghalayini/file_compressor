import java.util.LinkedHashMap;
import java.util.PriorityQueue;


public class ByteFrequencyEncoder {

    public ByteFrequencyEncoder() {
        
    }

    public void buildHuffmanTree(PriorityQueue<Node> node_queue){

        if(node_queue.size() == 1) {

            return;

        }
        
        combineNodes(node_queue);
        buildHuffmanTree(node_queue);

    }
    
    public void generateTree(LinkedHashMap<Integer, Integer> sorted_frequency) {
        PriorityQueue<Node> node_queue = new PriorityQueue<>();
         
        sorted_frequency.forEach((key, value) -> {
            Node new_node = new Node(key, value);       //creating new nodes for each linkedhashmap key/value
            node_queue.add(new_node);                   //adding it to the priorityQueue
        });
        
        buildHuffmanTree(node_queue);

    }

    public void combineNodes(PriorityQueue<Node> node_queue) {
        
        Node left_node = node_queue.poll();
        Node right_node = node_queue.poll();
        Node parent_node = new Node(-1, left_node.frequency + right_node.frequency);

        parent_node.left_node = left_node;
        parent_node.right_node = right_node;

        node_queue.add(parent_node);
    }

}
