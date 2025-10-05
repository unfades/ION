package Answers;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class M4Assignment {
    public static void main(String[] args) {
        FileReader fr = null;
        try{
            fr = new FileReader("D:\\Code Playground\\PSPION\\Answers\\input.txt");
            BufferedReader br = new BufferedReader(fr);
            String str;
            String stored = "";
            while((str = br.readLine())!=null){
                stored+=str;
            }
            List<Integer> myList = new ArrayList<>();
            String[] arr = stored.split(",");
            int sum = 0;
            for(String i : arr){
                sum+=Integer.parseInt(i);
                myList.add(Integer.parseInt(i));
            }
            double average = (double)sum/myList.size();

            System.out.println("UNSORTED: ");
            System.out.println(myList);

            for(int i = 0; i<myList.size()-1; i++){
            double min = myList.get(i);
                for(int j = i; j<myList.size(); j++){
                    if(myList.get(j) < min){
                        min = myList.get(j);
                        Integer temp = myList.get(j);
                        myList.set(j,myList.get(i));
                        myList.set(i, temp);
                    }
                }
            }
            System.out.println("SORTED: ");
            System.out.println(myList);
            System.out.println("The average of the numbers in input.txt: " + average);
        }catch(FileNotFoundException fnf){
            System.out.println("Sorry file not found: " + fnf.getMessage());
        }catch(IOException io){
            System.out.println("Sorry error reading the file: " + io.getMessage());
        }finally{
            if(fr!=null){
                try{
                    fr.close();
                }catch(Exception e){
                    System.out.println("Error parsing");
                }
            }
        }
    }
}

/*
OBJECTIVE: to learn how to create variables and methods using proper Java types.

TO DO: Read Chapter 5 several times before doing the Assignment. 
This is an individual assignment; you are responsible for writing your code and answers.
Don't try to copy code from other sources. Start early to finish the assignment on time.
Try to use proper variables and constants names using the style and notation you like.
Also do proper documentation. Documenting the important part of your code is must.
Submit your pseudocode, Java code, and screenshots of the Java output

Programming Exercises 
Create a text file that contains the following numbers:
10,31,9,20,100,1,20,16,3,25,1973,8,7,1999

Name this file input.txt. Write a program to parse this file for numbers (without the commas) and store them in an ArrayList.
Sort the numbers using selection sort. Calculate the average of the numbers in the ArrayList and display it on screen. 
*/