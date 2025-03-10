import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Compressor {

    public void compress(File file) {

        try {
            
            int data;
            HashMap<Integer, Integer> frequency = new HashMap<>();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

            while((data = reader.read()) != -1) {
                
                if(frequency.containsKey(data))
                    frequency.put(data, frequency.get(data) + 1);
                else
                    frequency.put(data, 1);
            }
  
            reader.close();
            LinkedHashMap<Integer, Integer> sorted_frequency = sortHashMap(frequency);
            ByteFrequencyEncoder encoder = new ByteFrequencyEncoder();
            encoder.generateTree(sorted_frequency, file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //sorting the hashmap in descending order using lambda expression with some built in methods 
    //according to the value (frequency of each character)
    //then we store them into a linked hashmap because it keeps the entries in order while the hashmap doesn't
    public LinkedHashMap<Integer, Integer> sortHashMap(HashMap<Integer, Integer> frequency) {
        return frequency.entrySet().stream()
                .sorted((value1, value2) -> value2.getValue().compareTo(value1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value1, LinkedHashMap::new));
    }
}
