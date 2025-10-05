/*OBJECTIVE - The purpose of this lab is to learn to format a table using Java printf. 

Consider the following table: 

++++++++++++++++++++++++++++++++++++++ 

Java Pattern Printf chart for  

PI = 3.14159265359 

++++++++++++++++++++++++++++++++++++++ 

+    Pattern    +                    Result                              + 

++++++++++++++++++++++++++++++++++++++ 

+    %f           +                   3.141593                          + 

++++++++++++++++++++++++++++++++++++++ 

The header or first 4 lines of the table can be implemented as follows: 
*/


public class PrintfExample { 

   public static void main(String args[]) { 

      double PI = 3.14159265359; 

      System.out.printf("++++++++++++++++++++++++++++++++++++++%n"); 

      System.out.printf(" Java Pattern Printf chart for%n"); 

      System.out.printf(" PI = 3.14159265359”;           %n"); 

      System.out.printf("++++++++++++++++++++++++++++++++++++++%n"); 

      // Your code go here
      System.out.printf("+ %4s %11c %18.11f %17c %n", "%f",'+',PI, '+'); 

   } 

}

/*
The following output: 

+    %18.11f           +                  3.14159265359                 + 

can be displayed with this statement: 

System.out.printf("+ %4s %11c %18.11f %17c %n", "%f",'+',PI, '+'); 

The + is printed first, then the %4s printed the string “%d”. Note that the number as in %4s adds 4 spaces before the formatted string “%d”. 

The %11c is used to print 11 spaces and the character '+'.  

The %18.11f is used to print PI which is declared earlier as double PI = 3.14159265359. Note that the number 18 specifies 18 spaces and the .11 specifies 11 digits of precision. 

The %17c is used to print 17 spaces and the character '+'. 

Your task is to complete the entire table, expand and display the results for PI using patterns %f, %15.10f, and %12.3f.
Adjust the spaces between PI and the + so that the + signs align with the edges of the headers. Use the example above and the reference below for quick Java printf usage.
Explain your code. 

What to Submit: 

Screen shots of your output, written code, lesson learned, any known errors or bugs in your code in a Word document.

*/