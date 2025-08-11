package SkillBuildingExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

public class BeginnerSkillsEx1{
    public static void main(String[] args) {
        StudentMenu sm = new StudentMenu();
        sm.addStudent("sahabi","A");
        sm.addStudent("ayaz","A");
        sm.addStudent("peush","A");
        sm.addStudent("harry","A");
        sm.addStudent("james","A");
        System.out.println("start program: ");
        sm.displayStudents();
        sm.addNStudents();
        sm.displayStudents();
    }
}

/*
Exercise 1
Create a menu driven program that:
• Accepts a user input for n students (name, roll no, grade).
• Stores them in a structured format (array / list of objects).
• Displays data in tabular format using formatted output.
*/

