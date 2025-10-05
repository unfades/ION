public class Assignment2 {
    
}


/*
Programming Exercises 

Write a program to create and manipulate a test data file. 
Create a text file if it does not exist. If it does exist, 
append new data to it. Ask the user how much test data to create 
(i.e., how many integers to write). Generate the test data randomly.
Write the specified number of integers into the file using text I/O.
Integers are separated by a space. 

Read the test data file.
Display the file on the screen.
Edit the file by changing the second integer to 1000.
Display the modified file. Count the number of integers,
display their total, and display their average. Hint: To change the integer,
you would need to open the file for reading then create a temporary file to write
the modified content. While reading each line, you have to split each number into a token 
(1D array) using the delimiter "" (empty space). You then replace the second element with
1000 and rewrite the line by adding the empty space back using join(). So, for example, if
my line is 1 2 20 15, using split(), String[] tokens = line.split(""); my array would be: 
my tokens[] = {1, 2, 20, 5}. You then substitute tokens[1]=1000, then write it back to the 
file. Finally, you can reconstruct the line as String newLine= String.join(" ", tokens); thus,
my new line is now 1 1000 20 5. You can refer to the Oracle database for information about String
 split() and join() methods:
*/