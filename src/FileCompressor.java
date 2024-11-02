import java.io.*;

import java.util.Scanner;

public class FileCompressor {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String file_path;

        System.out.print("Please enter the path of the file you want to Compress/Decompress: ");
        file_path = scan.nextLine();
        file_path = "C:\\Users\\Admin\\Desktop\\New Text Document.txt";
        file_path = file_path.replace("\"", "");

        try 
        {
            checkIfFileExist(file_path);
        } 
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        
        scan.close();
        
    }

    public static void checkIfFileExist(String file_path) throws FileNotFoundException {
        
        File file;
        
        file = new File(file_path);

        if(file.exists())
        {
            System.out.println("File is found");
            isCompressed(file_path);
        }
        else
        {
            throw new FileNotFoundException("File not found at the specified path: " + file_path);
        }
    }

                
    private static void isCompressed(String file_path) {

        File file;

        file = new File(file_path);

        if (file_path.endsWith(".zip") || file_path.endsWith(".gz") || file_path.endsWith(".huf") 
            || file_path.endsWith(".7z") || file_path.endsWith(".rar") || file_path.endsWith(".tar"))
        {
            
            Decompressor decompress_file = new Decompressor();
            decompress_file.decompress(file);
        }
        else
        {
            
            Compressor compress_file = new Compressor();
            compress_file.Compress(file);

        }
    }
}
