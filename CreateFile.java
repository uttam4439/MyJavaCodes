package FileHandling;
import java.io.*;

public class CreateFile{
    public static void main(String[] args){

        // Creating New txt file
        try{
            File newFile = new File("newTextFile.txt"); // file Instance with File name
            newFile.createNewFile();    // Make you file 
            System.out.println("New File Created");
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //Writing in the file
        try(
            FileWriter fo  = new FileWriter("newTextFile.txt")){
                fo.write("My First Vs code file generation");
            } catch (IOException e){
            System.out.println(e.getMessage());

        }
        //creating random file to delete on later
        try{
            File newFile = new File("random.txt"); // file Instance with File name
            newFile.createNewFile();    // Make you file 
            System.out.println("New File Created");
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }

        //Delete The File
        try{
            File delFile = new File(".txt"); 
            delFile.createNewFile();    
            if(delFile.delete()){
                System.out.println(delFile.getName());
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}