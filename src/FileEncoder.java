import java.io.File;
import java.util.Map;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;



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
        String path = file.getParentFile().getAbsolutePath() + File.separator + file_name + ".huf";

        try {
            File encoded_file = new File(path);
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(encoded_file));
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
            int data;
            int byte_value;
            char character;
            String byte_bits;
            String huffman_code;
            StringBuilder bitBuffer = new StringBuilder();

            while((data = reader.read()) != -1) {

                character = (char) data;
                huffman_code = huffman_codes.get(character);

                if (huffman_code == null) {

                    System.err.println("Character '" + character + "' not found in Huffman codes.");
                }

                bitBuffer.append(huffman_code);

                while(bitBuffer.length() >= 8) {

                    byte_bits = bitBuffer.substring(0, 8);
                    bitBuffer.delete(0, 8);

                    byte_value = Integer.parseInt(byte_bits, 2);
                    outputStream.write(byte_value);

                }

            }

            if(bitBuffer.length() > 0) {

                String remaining_bits = bitBuffer.toString();

                while(remaining_bits.length() < 8) {

                    bitBuffer.append("0");

                }
                
                byte_value = Integer.parseInt(remaining_bits, 2);
                outputStream.write(byte_value); 
            }

            reader.close();
            outputStream.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
