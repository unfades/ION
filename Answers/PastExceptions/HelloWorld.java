import java.util.Scanner;

class Test {
    // method to print the contents of a message
    public static void print(String mesg) {
        System.out.print(mesg);
    }
    // method to print the contents of a one-dimensional array
    public static void print(int[] array) {
        // a. Your code goes here
        String s = "[" + array[0] + ",";
        for(int i = 1; i<array.length-1; i++){
            s+=array[i]+",";
        }
        s+=array[array.length-1]+"]";
        if(array.length == 1) System.out.println("["+array[0]+"]");
        else System.out.println(s);
    }
    
    // method to print the contents of a two-dimensional array
    //c. The OOP concept that the method print() shows is Polymorphism, meaning "having many forms"
    //Polymorphism is implemented here in the form of method overloading, meaning that we have more than 1 method
    //called print()
    //implemented as print(int[] array) and print(int[][] array) that is overloading, depending on the parameters entered in main,
    //the method body that is called from Test is going to be of the 1D array or the 2D array.

    public static void print(int [][] array) {
        // b. Your code goes here
        for(int i = 0; i<array.length; i++){
            for(int j = 0; j<array[i].length; j++){
                System.out.println("The element on row " + (i+1) + " column " + (j+1) + " is " + array[i][j]);
            }
        }
        for(int i = 0; i<array.length; i++){
            String s = "";
            for(int j = 0; j<array[i].length; j++){
                s+= "["+array[i][j] +"]";
            }
            System.out.println(s);
        }
    }
}
public class HelloWorld {
    public static void main(String[] args) {
    System.out.println("HelloWorld!");
    //Test msg = new Test(); unneccessary
    //Since you declared your methods in Test as 'static' there is no need to create an reference variable msg of the class Test
    //You can call them without any reference variables simply by typing Test.print() like we do Math.pow(), etc
    String message = "Welcome to CSIT-166!";
    Test.print(message);
    // create a one-dimensional array and invoke print(int[] array)
    System.out.println("What is the size of your array?");
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int[] arr = new int[size];
    for(int i = 0; i<arr.length; i++){
        System.out.println("Enter the value to be stored in element " + (i+1));
        arr[i] = sc.nextInt();
    }
    Test.print(arr);
    //In java, a 2D array is a reference to an array of references that are of course holding the address of array objects in memory
    //so the method signature in the class Test which is print(int[] array, int rows, int columns) is wrong for the assignment
    //it should just be simply, print(int[][] array) since the first [] is rows and the second [] is columns, no need for row
    //or column variables in that case since a 2D array already has them

    // create a two-dimensional array and invoke print(int[], int rows, int columns)X -> print(int[][]) will be implemented
    // b. Your code goes here
    System.out.println("We are now going to make a 2D array, a 3x3 Matrix as instructed in the assignment");
    System.out.println("How many rows do you want in your 2D array? Enter 3 for a 3x3 Matrix: ");
    int rows = sc.nextInt();
    System.out.println("How many columns do you want for your 2D array? Enter 3 for a 3x3 matrix: ");
    int columns = sc.nextInt();
    int[][] twoDArray = new int[rows][columns];
    for(int i = 0; i<twoDArray.length; i++){
        for(int j = 0; j<twoDArray[i].length; j++){
            System.out.println("Enter the element going into row " + (i+1) + " column " + (j+1) + ": ");
            twoDArray[i][j] = sc.nextInt();
        }
    }
    Test.print(twoDArray);
    sc.close();
    }
}
