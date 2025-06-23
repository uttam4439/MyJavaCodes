package FileHandling;
import java.io.*;

// Byte Stream 
// Character Stream 

public class FirstFile {
    public static void main(String[] args) {
        
        //read character input from console
        try(InputStreamReader isr = new InputStreamReader(System.in)){
            System.out.println("Enter letters");

            // Reads a single character as datatype in ASCII value
            int letter = isr.read();

// This checks if there are more characters available to be read without blocking
            while(isr.ready()){
                System.out.println((char) letter);

// isr.read() is blocking – it waits for the user to press Enter to start reading.
                letter = isr.read();
// Blocking means the program waits (or "blocks") for an operation (like input or output) to complete before continuing.
            }
            System.out.println();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        //File Reading
        try(FileReader fr = new FileReader("/Users/uttam4439/Documents/JavaCodes/FileHandling/File.txt")){
            int letter = fr.read();

            while(letter != -1){
                System.out.print((char) letter);
                letter = fr.read();
            }
            System.out.println();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        //File Reading Using 
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/uttam4439/Documents/JavaCodes/FileHandling/File.txt"))){
            while(br.ready()){
                System.out.print(br.readLine() + "using Bufferedreader");
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        //File Writing 
        //This method will write from start deleting what is in file 
        try(FileWriter fw = new FileWriter("/Users/uttam4439/Documents/JavaCodes/FileHandling/File.txt")){
            fw.write("Hello World");
        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        //This method will write in file adding what content already exist
        try(FileWriter fw = new FileWriter("/Users/uttam4439/Documents/JavaCodes/FileHandling/File.txt" , true)){
            fw.write("."+" "+"This Is my First code For File Handling");
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
