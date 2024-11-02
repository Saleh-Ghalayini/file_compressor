import java.io.*;

public class Compressor {
    public void Compress(File file)
    {
        try
        {
            FileReader reader = new FileReader(file);
            int data = reader.read();

            while(data != -1)
            {
                System.out.print((char) data);
                data = reader.read();
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
