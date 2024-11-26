import java.io.File;
import java.util.Scanner;

public class FileCompressor {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String file_path_string;
        File file;

        System.out.print("Please enter the path of the file you want to Compress/Decompress: ");
        file_path_string = scan.nextLine().replace("\"", "");
        file = new File(file_path_string);

        checkIfFileExist(file);
        
        scan.close();

    }

    public static void checkIfFileExist(File file)  {

        if(file.exists()) {

            System.out.println("File is found");

            isCompressed(file);

        }
        else {

            System.out.print("File not found at the specified path: " + file.getPath());

            System.exit(0);

        }
    }
                
    private static void isCompressed(File file) {

        String file_name = file.getName();

        if (file_name.endsWith(".zip") || file_name.endsWith(".gz") 
            || file_name.endsWith(".huf") || file_name.endsWith(".7z")
            || file_name.endsWith(".rar") || file_name.endsWith(".tar"))
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
