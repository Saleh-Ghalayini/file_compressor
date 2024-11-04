import java.io.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Compressor {
    public void Compress(File file,Path file_path)
    {
        try
        {
            BufferedReader reader = Files.newBufferedReader(file_path, StandardCharsets.UTF_8);
            int data;

            HashMap<Integer, Integer> frequency = new HashMap<>();

            while((data = reader.read()) != -1)
            {
                
                if(frequency.containsKey(data))
                {
                    frequency.put(data, frequency.get(data) + 1);
                }
                else
                {
                    frequency.put(data, 1);
                }
            }

            //sorting the hashmap in descending order using lambda expression with some built in methods 
            //according to the value (frequency of each character)
            //then we store them into a linked hashmap because it keeps the entries in order while the hashmap doesn't  
            LinkedHashMap<Integer, Integer> sorted_frequency = frequency.entrySet().stream()
                .sorted((value1, value2) -> value2.getValue().compareTo(value1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (value1, value2) -> value1, LinkedHashMap::new));

            

            //System.out.println(sorted_frequency);

            reader.close();
        } 
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
    }
}
