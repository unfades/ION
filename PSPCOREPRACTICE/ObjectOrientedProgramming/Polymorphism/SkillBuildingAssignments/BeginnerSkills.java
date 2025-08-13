package Polymorphism.SkillBuildingAssignments;
import java.util.Scanner;

class Adder{

    public int adder(int a, int b){
        return a+b;
    }
}

class DoubleAdder extends Adder{
    
    @Override
    public int adder(int a, int b){
        return a+b;
    }

    public double adder(double a, int b){
        return a+b;
    }

    public double adder(int a, double b){
        return a+b;
    }

    public double adder(double a, double b){
        return a+b;
    }
}


//ex2
class Animal{
    public void makeSound(){
        System.out.println("Animal noises");
    }
}

class Cow extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Cow noises");
    }
}

class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Dog noises");
    }
}

public class BeginnerSkills {
    public static void main(String[] args) {
        Adder a = new Adder();
        System.out.println(a.adder(  5,  5));
        System.out.println(a.adder( 10,5));
        a = new DoubleAdder();
        System.out.println(a.adder(10,5));
        System.out.println("_________________");
        System.out.println("Compile Time Polymorphism the compiler chooses...");
        Scanner sc = new Scanner(System.in);
        System.out.println("do you want to add integers?(y/n):");
        char choice = 'n';
        choice = sc.nextLine().charAt(0);
        if(choice=='y'){
            System.out.println("Enter two numbers: ");
            int one = sc.nextInt();
            int two = sc.nextInt();
            System.out.println(a.adder(one,two));
        }else{
            System.out.println("Enter two numbers(decimal):");
            DoubleAdder d = new DoubleAdder();
            double one = sc.nextDouble();
            double two = sc.nextDouble();
            System.out.println(d.adder(one,two));
        }

        //exercise 2
        Animal animal = new Animal();
        animal.makeSound();
        System.out.println("do you want animal to be a cow?(y/n):");
        choice = 'n';
        choice = sc.next().charAt(0);
        if(choice == 'y')
            animal = new Cow();
        animal.makeSound();
        animal = new Dog();
        animal.makeSound();
    }
}

//ex1
//key skill learned - compile time polymorphism is method overloading
//runtime polymorphism is method overriding in child classes from parent class
//then exhibiting that behavior calling the child version

/*
ex2:
Exercise 2
Build foundational understanding of polymorphism in object-oriented
programming by simulating behavior through a shared interface.
Tasks :
• Create a base class or interface Animal with a method makeSound().
• Implement derived classes like Dog, Cat, and Cow, each overriding
makeSound() to print a different sound.
• Demonstrate polymorphism by calling makeSound() using a common
reference or interface.
*/