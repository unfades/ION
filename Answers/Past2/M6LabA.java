package Answers;
import java.util.ArrayList; 

class ListPrinter<T> { 

    private ArrayList<T> list; 

    public ListPrinter(ArrayList<T> list) { 
        this.list = list; 
    } 
    public void printList() { 
        for (T item : list) { 
            System.out.println(item); 
        } 
    } 
} 

public class M6LabA {
    public static void main(String[] args) {

        ArrayList<String> citiesList = new ArrayList<>();

        citiesList.add("San Francisco");
        citiesList.add("Paris");
        citiesList.add("Lima");
        citiesList.add("Saigon");
        citiesList.add("Bangkok");
        citiesList.add("Tokyo");
        citiesList.add("Cairo");

        //Instantiate an object of type ListPrinter<String> 

        //1a. Your code goes here 
        ListPrinter<String> stringPrinter = new ListPrinter<>(citiesList);
        //Invoke printList to print out citiesList 
        //1b. Your code goes here 
        stringPrinter.printList();
        //2. Your code goes here
        ArrayList<Integer> numberList = new ArrayList<>(); 

        numberList.add(1); 
        numberList.add(2); 
        numberList.add(3); 
        numberList.add(4); 
        numberList.add(5); 
        ListPrinter<Integer> intPrinter = new ListPrinter<>(numberList);
        intPrinter.printList();
    }
}

/*
M6. Lab A - Generic Class and Methods

OBJECTIVE - The purpose of this lab is to introduce students to how to implement generic classes and methods in Java. 

Consider the following code: 

import java.util.ArrayList; 

public class ListPrinter<T> { 

    private ArrayList<T> list; 

    public ListPrinter(ArrayList<T> list) { 

        this.list = list; 

    } 

    public void printList() { 

        for (T item : list) { 

            System.out.println(item); 

        } 

    } 

} 

public class MainClass { 

    public static void main(String[] args) { 

        ArrayList<String> citiesList = new ArrayList<>(); 

        citiesList.add("San Francisco"); 

        citiesList.add("Paris"); 

        citiesList.add("Lima"); 

        citiesList.add("Saigon"); 

        citiesList.add("Bangkok"); 

        citiesList.add("Tokyo"); 

        citiesList.add("Cairo"); 

        //Instantiate an object of type ListPrinter<String> 

        //1a. Your code goes here 

    //Invoke printList to print out citiesList 

        //1b. Your code goes here 

 

    //2. Your code goes here

    }
} 

Modify the code above where it says “x. Your code goes here” where x is the number of tasks. The first task (1a) is to instantiate an object of type ListPrinter<String> and the second task (1b) is to invoke printList() to print out citiesList of this object.
Continuing with your answer to the previous question, insert the code where it says “2. Your code goes here” to create a reference to an object name numberList of type ArrayList<Integer>. The numberList contains the values of 1, 2, 3, 4, and 5. Instantiate an object of type ListPrinter<Integer> and invoke printList() to print out the numbers of this object.
Explain the purpose of Generics when both ListPrinter<String> and ListPrinter<Integer> are used.
*/