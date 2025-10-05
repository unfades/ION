package Answers;
import java.lang.SuppressWarnings;

class Calculator<T extends Number> {
    public T add(T num1, T num2) { 
        if (num1 instanceof Double || num2 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue()); 
        } else if (num1 instanceof Float || num2 instanceof Float) {
            return (T) Float.valueOf(num1.floatValue() + num2.floatValue());
        } else if (num1 instanceof Long || num2 instanceof Long) { 
            return (T) Long.valueOf(num1.longValue() + num2.longValue()); 
        } else { 
            return (T) Integer.valueOf(num1.intValue() + num2.intValue());

        }
    }
    @SuppressWarnings("finally")
    public T div(T num1, T num2){
        T answer;
        boolean occurred = false;
        try{
        if (num1 instanceof Double || num2 instanceof Double) {
            answer = (T) Double.valueOf(num1.doubleValue() / num2.doubleValue());
            occurred = true;
        } else if (num1 instanceof Float || num2 instanceof Float) {
            answer = (T) Float.valueOf(num1.floatValue() / num2.floatValue());
            occurred = true;
        } else if (num1 instanceof Long || num2 instanceof Long) { 
            answer = (T) Long.valueOf(num1.longValue() / num2.longValue());
            occurred = true;
        } else { 
            answer = (T) Integer.valueOf(num1.intValue() / num2.intValue());
            occurred = true;
        }
        }catch(ArithmeticException e){
            System.out.println("Theres a problem with your inputs, details:" + e.getMessage());
        }finally{
            if(!occurred){System.out.println("There was no operation performed, try again properly...");}
            answer = (T) Integer.valueOf(0);
            return answer;
        }
    }
}

public class M6Assignment { 
    public static void main(String[] args) { 
        Calculator<Double> doubleCalculator = new Calculator<>(); 
        double num1 = 5.5; 
        double num2 = 2.0; 
        System.out.println("Addition: " + doubleCalculator.add(num1, num2));
        System.out.println("Division: " + doubleCalculator.div(num1, num2));    
        int num3 = 1;
        int num4 = 3;
        Calculator<Integer> integerCalculator = new Calculator<>();
        System.out.println("Addition: " + integerCalculator.add(num3,num4));
        System.out.println("Addition: " + integerCalculator.add(num3,num4));
        System.out.println("Division: " + integerCalculator.div(num3,0));
        float num5 = 10.0f;
        float num6 = 15.5f;
        Calculator<Float> floatCalculator = new Calculator<>();
        System.out.println("Addition: " + floatCalculator.add(num5,num6));
        System.out.println("Division: " + floatCalculator.div(num5,num6));
        //handled the exceptions
        System.out.println("Division: " + floatCalculator.div(num5,0.0f));
    }
}