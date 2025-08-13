package Answers;

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.util.ArrayList;
import java.util.List; 

 

public class M4LabA { 
    public static void main(String[] args) { 

        String fileName = "D:\\Code Playground\\PSPION\\Answers\\lab4.txt";
        //Declare ArrayList of Integer and name it numbers
        //1. Your code goes here
        List<Integer> numbers = new ArrayList<>();

        try { 
            BufferedReader br = new BufferedReader(new FileReader(fileName)); 
            String line; 
            while ((line = br.readLine())!= null) { 
                String[] words = line.split("\\s+"); 
                //For each word in words, if it is a number, add it to ArrayList numbers. 
                for (String word : words) { 
                    try { 
                        //2. Your code goes here
                        numbers.add(Integer.parseInt(word));
                    } catch (NumberFormatException e) {
                        //ignore if word is not a number                 
                    } 
                } 
            } 
            br.close(); 
        } catch (Exception e) { 
            //display the exception
            //3. Your code goes here 
            System.out.println("Sorry theres an error parsing the file " + e.getMessage());
        }
        //print the numbers arrayLISTT
        //4. Your code goes here 
        System.out.println("before sorting");
        System.out.println(numbers);
        //implement one of the search algorithms to sort the ArrayList from biggest to smallest
        for(int i = 0; i<numbers.size()-1; i++){
            double min = numbers.get(i);
            for(int j = i; j<numbers.size(); j++){
                if(numbers.get(j) < min){
                    min = numbers.get(j);
                    Integer temp = numbers.get(j);
                    numbers.set(j,numbers.get(i));
                    numbers.set(i, temp);
                }
            }
        }
        System.out.println("after sorting");
        System.out.println(numbers);
        //then display the ArrayList
        //5. Your code goes here 
        int j = 0; 
        for(int i: numbers){
            System.out.println("The number at position " + j +" is "+ numbers.get(j));
            j++;
        }
    }
} 


/*
M4. Lab A - Declaring and Using ArrayList 

OBJECTIVE - The purpose of this lab is to introduce students to ArrayList in Java. 

Consider the following code: 

import java.io.BufferedReader; 

import java.io.FileReader; 

import java.util.ArrayList; 

 

public class NumberSearch { 

    public static void main(String[] args) { 

        String fileName = "lab4.txt";  

        //Declare ArrayList of Integer and name it numbers  

        //1. Your code goes here 

 

        try { 

            BufferedReader br = new BufferedReader(new FileReader(fileName)); 

            String line; 

            while ((line = br.readLine())!= null) { 

                String[] words = line.split("\\s+"); 

                //For each word in words, if it is a number, add it to ArrayList numbers. 

                for (String word : words) { 

                    try { 

                        //2. Your code goes here  

                    } catch (NumberFormatException e) { 

                        //ignore if word is not a number                     

                    } 

                } 

            } 

            br.close(); 

        } catch (Exception e) { 

            //display the exception 

            //3. Your code goes here 

        } 

 

        //print the numbers array 

        //4. Your code goes here 

    } 

    //implement one of the search algorithms to sort the ArrayList from biggest to smallest 

    //then display the ArrayList 

    //5. Your code goes here 

} 

This lab is like lab3b. You will use ArrayList instead of using an array to store the numbers. 

1. Create and save a plain text file name lab4.txt in your current working directory (where you create the project for this lab) that has the followings contents: 
“On 30 January 2020 COVID-19 was declared a Public Health Emergency of International Concern (PHEIC) with an official death toll of 171. By 31 December 2020, this figure stood at 1813188. Yet preliminary estimates suggest the total number of global deaths attributable to the COVID-19 pandemic in 2020 is at least 3 million, representing 1.2 million more deaths than officially reported.” 
(https://www.who.int/data/stories/the-true-death-toll-of-covid-19-estimating-global-excess-mortality
Links to an external site.)
2. Modify the code above where it says “x. Your code goes here” where x is the number of tasks. Your tasks are listed in the comments // section in the code above. You will need to open the input file lab3.txt, which you created in step 1, and scan the file for numbers and store them in the numbers ArrayList.
3. In the code above where it says “5. Your code goes here” implement one of the sort algorithms you learned in previous module to sort the ArrayList by numbers from biggest to smallest. 

What to Submit: 
Screen shots of your output, written code, lesson learned, any known errors or bugs in your code in a Word document. 
 */