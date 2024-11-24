import java.util.LinkedHashMap;
import java.util.PriorityQueue;


public class ByteFrequencyEncoder {

    public ByteFrequencyEncoder() {
        
    }
    
    public void generateTree(LinkedHashMap<Integer, Integer> sorted_frequency) {
        PriorityQueue<Node> node_queue = new PriorityQueue<>();
         
        sorted_frequency.forEach((key, value) -> {
            Node new_node = new Node(key, value);       //creating new nodes for each linkedhashmap key/value
            node_queue.add(new_node);                   //adding it to the priorityQueue
        });
        
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
