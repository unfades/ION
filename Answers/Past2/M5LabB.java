package Answers;

public class M5LabB { 
    public static void main(String[] args) { 
        // Autoboxing: Converting primitive type int to wrapper object
        // Integer wrappedNum1 
        int num1 = 42; 
        Integer wrappedNum1 = num1; 

        // Autoboxing: Converting num2 to wrapper object double wrappedNum2 
        // 1. Your code goes here
        double num2 = 42.0;
        // Autoboxing: Converting primitive character to wrapper object
        Double wrappedNum2 = num2;
        // wrappedChar
        char ch1 = 'A';
        // 2. Your code goes here
        Character wrappedChar = ch1;
        System.out.println("Autoboxing:"); 
        System.out.println("Wrapped Integer: " + wrappedNum1); 
        System.out.println("Wrapped Double: " + wrappedNum2); 
        System.out.println("Wrapped Character: " + wrappedChar); 
        // Unboxing: Converting wrapper objects to primitive types
        // 3. Your code goes here.
        int backToNum1 = wrappedNum1;
        double backToNum2 = wrappedNum2;
        char backToChar = wrappedChar;

        System.out.println("unboxing done now:"); 
        System.out.println("unboxed Integer as int: " + backToNum1); 
        System.out.println("unboxed Double as double: " + backToNum2); 
        System.out.println("unboxed Character as char: " + backToChar);
        // autoboxing: invoking add()method for primitive types addition and 
        // display result1.
        // 4. Your code goes here
        int result1 = add(num1,backToNum1);
        System.out.println("\nPrimitive Type Addition: " + result1); 
        // Unboxing: use intValue()method to extract the primitive int value
        // from the Integer objects and display result2 
        // 5. Your code goes here 
        Integer toSum1 = 1; //assigned (primitive int)1 into toSum1 Wrapper Class Integer
        Integer toSum2 = 2; //same
        int result2 = toSum1.intValue() + toSum2.intValue();
        System.out.println("Wrapper Class Addition: " + result2); 
    }
    
    public static int add(int a, int b) { 
        return a + b; 
    }
}