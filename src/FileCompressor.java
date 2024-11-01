import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileCompressor {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String file_path;

        System.out.print("Please enter the path of the file you want to Compress/Decompress: ");
        file_path = scan.nextLine();

        try 
        {
            checkIfFileExist(file_path);
        } 
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        

        
    }

    public static void checkIfFileExist(String file_path) throws FileNotFoundException {
        
        File file = new File(file_path);

        if(file.exists())
        {
            isCompressed(file_path);
        }
        else
        {
            throw new FileNotFoundException("File not found at the specified path: " + file_path);
        }
        }

                
    private static void isCompressed(String file_path) {
        if (file_path.endsWith(".zip") || file_path.endsWith(".gz") || file_path.endsWith(".huf") 
            || file_path.endsWith(".7z") || file_path.endsWith(".rar") || file_path.endsWith(".tar"))
        {

        }
    }
}

//need to fix errors about the file path and how to handle it
//then i need to proceed with continuing the isCompressed method and the rest of the program