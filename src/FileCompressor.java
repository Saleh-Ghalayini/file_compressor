import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileCompressor {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String file_path_string;
        Path file_path;

        System.out.print("Please enter the path of the file you want to Compress/Decompress: ");
        file_path_string = scan.nextLine();
        file_path_string = file_path_string.replace("\"", "");
        file_path = Paths.get(file_path_string);

        try 
        {
            checkIfFileExist(file_path_string, file_path);
        } 
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        
        scan.close();
        
    }

    public static void checkIfFileExist(String file_path_string, Path file_path) throws FileNotFoundException {
        
        File file;
        
        file = new File(file_path_string);

        if(file.exists())
        {
            System.out.println("File is found");
            isCompressed(file_path_string, file_path);
        }
        else
        {
            throw new FileNotFoundException("File not found at the specified path: " + file_path_string);
        }
    }

                
    private static void isCompressed(String file_path_string, Path file_path) {

        File file;

        file = new File(file_path_string);

        if (file_path_string.endsWith(".zip") || file_path_string.endsWith(".gz") || file_path_string.endsWith(".huf") 
            || file_path_string.endsWith(".7z") || file_path_string.endsWith(".rar") || file_path_string.endsWith(".tar"))
        {
            
            Decompressor decompress_file = new Decompressor();
            decompress_file.decompress(file, file_path);
        }
        else
        {
            Compressor compress_file = new Compressor();
            compress_file.Compress(file, file_path);

        }
    }
}
