import java.io.*;
import java.util.HashMap;

public class Compressor {
    public void Compress(File file)
    {
        try
        {
            FileReader reader = new FileReader(file);
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
