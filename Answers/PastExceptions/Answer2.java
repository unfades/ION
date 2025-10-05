import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Answer2 {
    public static void main(String[] args) {
        
        String message = "Hello World";
        FileWriter myFile = null;
        // create a file object of class FileWriter 
        try{
            myFile = new FileWriter("C:\\results\\result.txt"); 
        // read character wise from message and write into FileWriter 

        for (int i = 0; i < message.length(); i++) 
            myFile.write(message.charAt(i));
        System.out.println("Writing successful");
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
        //close the file
            if(myFile!=null){
                try{
                    myFile.close();
                }catch(Exception ex){
                    System.out.println("Error while trying to close the file");
                }
            }
        } 
    }
}

/*
OBJECTIVE: This lab's purpose is to learn to read and write files using byte stream and to apply file handling exceptions. 

Consider the following code: 

// Creating a text File using FileWriter 

import java.io.FileWriter; 

import java.io.IOException; 

class CreateFile 

{ 

    public static void main(String[] args) 

    { 

        // Accept a string 

        String message = "Hello World!";   

        // create a file object of class FileWriter 

        FileWriter myFile = new FileWriter("C:\\results\\result.txt"); 

        // read character wise from message and write into FileWriter 

        for (int i = 0; i < message.length(); i++) 

            myFile.write(message.charAt(i)); 

        System.out.println("Writing successful"); 

        //close the file 

        myFile.close(); 

    } 

}

"C:\results" <-INVALID
"D:/Code Playground/CodePractice" <-VALID
"D:\\Code Playground\\CodePractice" <-VALID
WRONG^
"C:\\results"
"C:/results"
OKAY WAYS
In this code, we use FileWriter to write a message “Hello World!” 
to a file called “result.txt”. Right now, the output file “result.txt” 
is placed in the directory C:\results. Note that on Windows, the reverse 
slash \ is the separator in the 'pathname' of a file. Therefore, the pathname 
C:\results\result.txt must include a reverse slash thus makes it a double reverse 
slash as seen in the statement FileWriter(“C:\\results\\result.txt”). The for loop 
is used to read each character from the message “Hello World!” and write it to myFile, 
which is a FileWriter object. To use FileWriter and FileReader, you must import the library 
java.io.FileWriter.  

The problem with this code is that it does not use any file handling exception. Your task is to: 

    Create an empty file and call it results on your C drive. Modify the code using throw exception handling 
    to throw an IOException that checks if an I/O error occurs, or the end of the stream is reached. 
    Modify the code using FileReader to read file “result.txt” and display the contents of the file on screen. 
    Use try and catch to check for FileNotFoundException. See module 2 lecture for examples of try and catch.
*/