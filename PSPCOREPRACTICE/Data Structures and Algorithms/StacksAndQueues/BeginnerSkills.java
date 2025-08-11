package StacksAndQueues;

import java.util.Stack;
public class BeginnerSkills {
    //1reverse stack using recursion O(1) space
    //2Design a queue with O(1) getMin() operation
    //ASK SCA SIR
    public static Stack<Integer> reverse(Stack<Integer> st){
        Stack<Integer> st2 = new Stack<>();
        while(!st.isEmpty()){
            st2.push(st.pop());
        }
        return st2;
    }
    
    static Stack<Integer> stRev = new Stack<>();
    public static Stack<Integer> recReverse(Stack<Integer> st){
        if(!st.isEmpty()){
            stRev.push(st.pop());
            recReverse(st); //used recursion
        }
        st.addAll(stRev); //LEARNED ADDALL not a hollow copy but actual reassignment
        stRev.clear(); 
        return st;
    }

    /*
    //THis is that O(1) that the problem meant but figure out how tracing the logic later
    public static Stack<Integer> recReverse(Stack<Integer> st){
        if(st.isEmpty()) return st;
        int top = st.pop();
        recReverse(st);
        insertAB(st, top);
        return st;
    }
    */
    public static void insertAB(Stack<Integer> st, int item){
        if(st.isEmpty()){
            st.push(item);
            return;
        }
        int top = st.pop();
        insertAB(st, item);
        st.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        //iteratively -
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st);
        st = reverse(st);
        System.out.println(st);
        //recursively again reversing
        st = recReverse(st);
        System.out.println(st);

        Stack<Integer> st3 = new Stack<>();
        st3.push(2);
        st3.push(2);
        st3.push(3);
        st3 = recReverse(st3);
        
    }
}

