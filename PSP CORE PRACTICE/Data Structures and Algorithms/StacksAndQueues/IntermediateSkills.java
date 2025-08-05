package StacksAndQueues;
import java.util.Collections;
import java.util.Stack;

public class IntermediateSkills {
    public static void main(String[] args) {
        Stack<Integer> stackA = new Stack<Integer>(); //has stuff 1,2,4,5,7,6,10
        
        stackA.push(10);
        stackA.push(6);
        stackA.push(7);
        stackA.push(5);
        stackA.push(4);
        stackA.push(2);
        stackA.push(1);
        
    Stack<Integer> stackB = new Stack<>(); //empty
        Collections.sort(stackA);
        System.out.println(stackA);
        

    }
}
