import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class FileEncoder {
    
    public FileEncoder() {

    }
    
    public void encodeFile(Map<Character, String> huffman_codes, File file) {
        
        try {

            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
            int data;
            System.out.println(huffman_codes);
            while((data = reader.read()) != -1) {

            }
        }
        catch (IOException e) {
            System.out.println("Error Occurred");
        }

    }

}
