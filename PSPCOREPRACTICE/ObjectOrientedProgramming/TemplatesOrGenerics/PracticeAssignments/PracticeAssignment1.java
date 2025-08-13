package TemplatesOrGenerics.PracticeAssignments;

//code from old assignments I did used just made it <T> and objects as T
//then in the object references specified they are 'T' objects thats it done easy.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//FIFO
class QueueOfGenerics<T>{

    List<T> queueList = new ArrayList<>();

    public void enqueue(T task){
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

//Now I can even store StudentMenu Objects in the above queue made from our dsa make a queue assignment
//I just made it <T> for a raw type generics and we refer to the objects as T object, like String name, T varname as parameters passed syntax
class StudentMenu{
    private static int roll = 1;
    List<List<Object>> studentList = new ArrayList<>();

    public void addStudent(String name, String grade){
        List<Object> student = new ArrayList<>();
        student.add(name);
        student.add(roll++);
        student.add(grade);
        studentList.add(student);
    }

    public void addNStudents(){
        System.out.print("How many students do you want to add admin?: ");
        Scanner sc = new Scanner(System.in);
        System.out.println();
        int len = Integer.parseInt(sc.nextLine());
        for(int i = 0; i<len; i++){
        List<Object> student = new ArrayList<>();
        System.out.print("Enter name for student " + roll + ": ");
        String name = String.valueOf(sc.nextLine());
        student.add(name);
        System.out.println("Give a grade to student " + roll + ": ");
        String grade = String.valueOf(sc.nextLine());
        student.add(roll++); //because THIS IS PARAMETER index 1 on the ARRAYLIST
        student.add(grade);
        //PUTTING ROLL HERE MADE IT PARAMETER 2 index on the arrlist that was why the error was there >:)
        studentList.add(student);
        }
    }

    public void displayStudents(){
        System.out.println("_______________________________");
        int j = 1;
        for(List<Object> i: studentList){
            String stuName = (String)i.get(0);
            int stuRoll = (int)i.get(1);
            String stuGrade = (String)i.get(2);
            System.out.println("_______________________________");
            System.out.println("Student  "+ j + " information: ");
            System.out.println("name:    "+stuName);
            System.out.println("roll no: "+stuRoll);
            System.out.println("grade:   "+stuGrade);
            System.out.println("_______________________________");
            j++;
        }
        System.out.println("_______________________________");
    }
}


public class PracticeAssignment1 {
    public static void main(String[] args) {
        //DOne easy just use <T> and T when mentioning objects I guess..! EZ IN JAVA
        //QueueOfGenerics is a raw type,
        //references to raw type QueueOfGenerics should be parameterized
        //means writing this QueueOfGenerics qG = new QueueOfGenerics(); is not right
        //we write like the below, specifying the type we want to store to make it safe
        //then the compiler warnings go away
        QueueOfGenerics<String> qG = new QueueOfGenerics<>();
        String yuh = "uh";
        qG.enqueue(yuh);
        qG.enqueue(yuh);
        qG.displayQueue();

        QueueOfGenerics<StudentMenu> qG2 = new QueueOfGenerics();
        StudentMenu studMenu = new StudentMenu();
        studMenu.addStudent("rav", "A+");
        qG2.enqueue(studMenu); //now qG2 holds object of StudentMenu, the power of Generics in java
    }
}
