import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class FileEncoder {
    
    public FileEncoder() {

    }

    public static String getFileName(String fileName) {
        int index = fileName.lastIndexOf('.');
        if (index == -1) {
            return fileName;
        } else {
            return fileName.substring(0, index);
        }
    }
    
    public void encodeFile(Map<Character, String> huffman_codes, File file) {
        
        String file_name = getFileName(file.getName());

        String path = file.getParentFile().getAbsolutePath() + "\\" + file_name + ".huff";

        try {
            File encoded_file = new File(path);
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
            int data;
            //  System.out.println(huffman_codes);
            while((data = reader.read()) != -1) {

            }
        }
        catch (IOException e) {
            System.out.println("Error Occurred");
        }

    }

}
