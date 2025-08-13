package Polymorphism.PracticeAssignments;

import java.util.Scanner;

class Shape{

    protected int shapeID;
    protected String color;

    public void draw(){
        System.out.println("nothing to draw, specify shape");
    }

    public void displayShape(){
        System.out.println("nothing to show");
    }
}

class Circle extends Shape{
    protected int radius;
    @Override
    public void draw(){
        System.out.println("drew a circle");
    }
    @Override
    public void displayShape(){
        System.out.println("displayed a circle");
    }
}

class Rectangle extends Shape{
    protected int width;
    protected int height;

    @Override
    public void draw(){
        System.out.println("drew a rectangle");
    }
    @Override
    public void displayShape(){
        System.out.println("displayed a rectangle");
    }
}

//dynamic method dispatch
public class PracticeAssignment1 {
    public static void main(String[] args) {
        
        Shape s = new Shape();
        s.draw();
        s.displayShape();
        System.out.println("wanna make it a circle?(y/n): ");
        Scanner sc = new Scanner(System.in);
        String choice = String.valueOf(sc.nextLine());
        if(choice.equals("y") || choice.equals("yes"))
            s = new Circle();
            s.draw();
            s.displayShape();
        s = new Rectangle();
        s.draw();
        s.displayShape();
    }
}
