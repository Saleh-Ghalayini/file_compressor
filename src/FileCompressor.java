import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileCompressor {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String file_path_string;
        File file;

        System.out.print("Please enter the path of the file you want to Compress/Decompress: ");
        file_path_string = scan.nextLine().replace("\"", "");
        file = new File(file_path_string);

        try {

            checkIfFileExist(file);

        } 
        catch (FileNotFoundException e) {

            System.out.println(e.getMessage());

        }
        
        scan.close();

    }

    public static void checkIfFileExist(File file) throws FileNotFoundException {

        if(file.exists()) {

            System.out.println("File is found");

            isCompressed(file);

        }
        else {

            throw new FileNotFoundException("File not found at the specified path: " + file.getPath());

        }
    }
                
    private static void isCompressed(File file) {

        String fileName = file.getName();

        if (fileName.endsWith(".zip") || fileName.endsWith(".gz") 
            || fileName.endsWith(".huf") || fileName.endsWith(".7z")
            || fileName.endsWith(".rar") || fileName.endsWith(".tar"))
        {
            
            Decompressor decompress_file = new Decompressor();
            decompress_file.decompress(file);
            
        }
        else {

            Compressor compress_file = new Compressor();
            compress_file.Compress(file);

        }
    }
}
