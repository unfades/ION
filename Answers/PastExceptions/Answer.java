import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Answer {
    public static void main(String[] args) {
        String str = "", str2 ="";
        int generated = 0;
        PrintWriter pw = null;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        File myfile = new File("D:/Code Playground/CodePractice/Numbers.txt");
        if(!myfile.exists()){
            try{
                File newfile = new File("D:/Code Playground/CodePractice/Numbers.txt");
                newfile.createNewFile();
            }catch(IOException e){
                System.out.println("An error occurred making the file - " + e.getStackTrace());
            }
        }
        int sum  = 0;
        double avg = 0.0;
        if(myfile.exists()){
            System.out.println("How many integers should we generate?: ");
            generated = sc.nextInt();
            try{
                pw = new PrintWriter("D:\\Code Playground\\CodePractice\\Numbers.txt");
                for(int i = 0; i<generated; i++){
                    int num = rand.nextInt(100);
                    sum+=num;
                    pw.print(num + " ");
                }
            }catch(FileNotFoundException e){
                System.out.println("Sorry the file was not found" + e.getMessage());
            }finally{
                if(pw!=null){
                    try{
                        pw.close();
                        System.out.println("File was saved successfully...");
                    }catch(Exception e){
                        System.out.println("Error while closing the file...");
                    }
                }
                sc.close();
            }
        }
        //created the data all good now to just read and change all good
        String[] arr = new String[generated];

        FileReader fr = null;
        try{
            fr = new FileReader("D:/Code Playground/CodePractice/Numbers.txt");
            BufferedReader br = new BufferedReader(fr);
            str2 = "";
            int i = 0;
            while((str = br.readLine())!=null){
                str2+=str;
            }
            System.out.println("Str2 insides are - " + str2);
            arr = str2.split(" ");

        }catch(FileNotFoundException fnf){
            System.out.println("Hey the file wasnt even found - " + fnf.getMessage());
        }catch(IOException e){
            System.out.println("Hey there seems to be some io exception - " + e.getMessage());
        }finally{
            if(fr!=null){
                try{
                    fr.close();
                }catch(Exception ex){
                    System.out.println("Error while closing the file");
                }
            }
        }
        //now to change the value of the second integer in the file to 1k
        //instead of making a temporary file I am just gonna clear it
        try{
        pw = new PrintWriter("D:/Code Playground/CodePractice/Numbers.txt");
        arr[1] = "1000";
        fr = new FileReader("D:/Code Playground/CodePractice/Numbers.txt");
        BufferedReader br = new BufferedReader(fr);
        
        str2 = "";
        for(int i = 0; i<arr.length; i++){
            str2+=arr[i] + " ";
        }
        pw.print(str2);
        pw.close();
        }catch(FileNotFoundException fnf){
            System.out.println(fnf.getMessage());
        }finally{
            pw.close();
        }

        System.out.println("The sum is " + sum);
        avg = sum/(double)generated;
        System.out.printf("The average is %f", avg);
    }
}

/*
Programming Exercises 

Write a program to create and manipulate a test data file. 
Create a text file if it does not exist. 
If it does exist, append new data to it. 
Ask the user how much test data to create 
(i.e., how many integers to write). Generate the test data randomly.
Write the specified number of integers into the file using text I/O. 
Integers are separated by a space.

Read the test data file. Display the file on the screen. 
Edit the file by changing the second integer to 1000. 
Display the modified file. Count the number of integers, display their total, 
and display their average. Hint: To change the integer, 
you would need to open the file for reading then create a temporary file to 
write the modified content. While reading each line, you have to split each 
number into a token (1D array) using the delimiter "" (empty space).

You then replace the second element with 1000 and rewrite the line by adding 
the empty space back using join(). So, for example, if my line is 1 2 20 15, 
using split(), String[] tokens = line.split(""); 
my array would be: my tokens[] = {1, 2, 20, 5}. 
You then substitute tokens[1]=1000, then write it back to the file. 
Finally, you can reconstruct the line as String newLine= String.join(" ", tokens); 
thus, my new line is now 1 1000 20 5. You can refer to the Oracle database for 
information about String split() and join() methods:

 */