package StacksAndQueues;

import java.util.ArrayList;
import java.util.List;

//FIFO
class QueueOfTasks{
    List<String> queueList = new ArrayList<>();

    public void enqueue(String task){
        queueList.add(0,task); //add to index 0
    }
    public void dequeue(){
        if(!queueList.isEmpty()) queueList.remove(queueList.size()-1); // remove the one waiting the longest
    }
    public void front(){
        System.out.println(queueList.get(queueList.size()-1)); //print the last index as that is the priority
    }
    public void displayQueue(){
        if(queueList.isEmpty()){System.out.println("Nothing to display even. Your Q's empty rn..."); return;}
        int j = 0;
        System.out.println("_______queue printed______________________");
        for(int i = queueList.size()-1; i>=0; i--){
            if(j == 0) System.out.printf("priority task todo:  %s\n", queueList.get(i));
            else System.out.printf("task no:%d       is: %s\n", (j+1), queueList.get(i));
            j++;
        }
    }
    public boolean isEmpty(){
        return (queueList.size()==0);
    }
}

//LIFO
class StackOfTasks{
    List<String> stackList = new ArrayList<>();

    public void push(String task){
        stackList.add(task); //add to the top of the stack
    }

    public void pop(){
        if(stackList.isEmpty()){ System.out.println("Nothing to pop.. it's empty."); return;}
        stackList.remove(stackList.size()-1); //remove the one at the top
    }

    public void peek(){
        if(stackList.isEmpty()){ System.out.println("Nothing at the top.. it's empty."); return;}
        System.out.println(stackList.get(stackList.size()-1)); //arrayList show the one at the last, top
    }

    public void isEmpty(){
        if(stackList.isEmpty()) System.out.println(stackList.isEmpty() + "Stack is empty");
        else System.out.println(stackList.isEmpty() + " Stack isn't empty");
    }

    public void displayStack(){
        if(stackList.isEmpty()){System.out.println("nothing to display, Stack is empty.."); return;}
        int j = 1;
        System.out.println("_________________stack printed________________________");
        for(int i = stackList.size()-1; i>=0; i--){
            if(i == stackList.size()-1){System.out.println("Stack's top's(element 0's)  task is :" + stackList.get(stackList.size()-1)); continue;}
            System.out.println("Stack element no: " + j + "'s       task is :" + stackList.get(i));
            j++;
        }
    }
}

public class PracticeAssignment1{
    public static void main(String[] args) {
        //declared stack of tasks Object
        StackOfTasks mine = new StackOfTasks();
        //pushed to stack of tasks
        mine.displayStack();
        mine.push("Wake Up");
        mine.push("Turn In Final Report");
        mine.push("Kill The Coding Assessment");
        mine.push("Walk The Dog");
        mine.push("Cofee Time");
        mine.peek();
        mine.displayStack();
        //popped a task
        mine.pop();
        //top becomes Walk The Dog as stacks work that way displaying the top via peek
        mine.displayStack();
        mine.peek();
        //QUEUE implementation
        QueueOfTasks myQ = new QueueOfTasks();
        myQ.isEmpty();
        myQ.displayQueue();
        myQ.enqueue("Complete order 1");
        myQ.enqueue("Complete order 2");
        myQ.enqueue("Complete order 3");
        myQ.front();
        myQ.displayQueue();
        myQ.dequeue();
        //now complete order 1 should be gone, 2 and 3 left
        myQ.front();
        myQ.displayQueue();
        myQ.isEmpty();
    }
}

/*
Tasks
1. Stack Management
Create a class to represent a stack of tasks. Each stack should
support the following operations:
• Push (add a task to the stack)
• Pop (remove the most recent task from the stack)
• Peek (view the most recent task in the stack)
• IsEmpty (check if the stack is empty)
2. Queue Management
Create a class to represent a queue of tasks. Each queue should
support the following operations:
• Enqueue (add a task to the queue)
• Dequeue (remove the oldest task from the queue)
• Front (view the oldest task in the queue)
• IsEmpty (check if the queue is empty)
*/