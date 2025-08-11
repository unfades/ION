package StacksAndQueues;

import java.util.Stack;

public class BroCodeStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //5 unique methods
        //1push on top of the stack
        //2pop from the top of the stack
        //3peek at the item at the top of the stack
        //4empty check to see if it is empty
        //5search our stack for an item
        //in JAVA

        System.out.println(stack.empty());
        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("Doom");
        stack.push("Borderlands");
        stack.push("FinalFantasy7");
        //no longer empty
        System.out.println(stack.empty());
        System.out.println(stack.search("Minecraft"));
    }
}
