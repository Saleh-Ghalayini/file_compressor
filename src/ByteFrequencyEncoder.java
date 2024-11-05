import java.util.LinkedHashMap;
import java.util.PriorityQueue;


public class ByteFrequencyEncoder {

    public ByteFrequencyEncoder()
    {
        
    }
    
    public void generateTree(LinkedHashMap<Integer, Integer> sorted_frequency)
    {
        PriorityQueue<Node> node_queue = new PriorityQueue<>();
         
        sorted_frequency.forEach((key, value) -> {
            Node new_node = new Node(key, value);       //creating new nodes for each linkedhashmap key/value
            node_queue.add(new_node);                   //adding it to the priorityQueue
        });
    }

}
