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
        
        //String path = file.getParentFile().getAbsolutePath() + "/" + file.getName() + ".huf";
        String file_name = file.getName();

        System.out.println(getFileName(file_name));

        try {
            //File encoded_file = new File(path);
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
            int data;

            while((data = reader.read()) != -1) {

            }
        }
        catch (IOException e) {
            System.out.println("Error Occurred");
        }

    }

}
