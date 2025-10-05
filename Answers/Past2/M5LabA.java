package Answers;

enum Fruit {

    APPLE("Red", "Sweet"), 

    BANANA("Yellow", "Sweet"), 

    ORANGE("Orange", "Citrus"), 

    STRAWBERRY("Red", "Tangy"), 

    GRAPE("Purple", "Juicy");

    private String color;
    private String taste;
    //Create a constructor Fruit that accepts color and taste as default parameters 
    //1. Your code goes here 
    private Fruit(String color, String taste){
        this.color = color;
        this.taste = taste;
    }
    //Create a getColor() method to return color of selected fruit 
    //2. Your code goes here 
    public String getColor(){
        return this.color;
    }
    //Create a getTaste() method to return taste of the selected fruit 
    //3. Your code goes here 
    public String getTaste(){
        return this.taste;
    }
}

public class M5LabA {
    public static void main(String[] args) { 

        Fruit[] fruits = Fruit.values();

        System.out.println("Fruit Information:"); 
        //Implement the foreach loop to display fruit.name(), fruit.getColor(), and fruit.getTaste(). 
        //4. Your code goes here 
        for(Fruit f : fruits){
            System.out.println("name: " + f + " color: "+f.getColor() +" taste: "+ f.getTaste());
        }

        Fruit myfruit = Fruit.STRAWBERRY;
        System.out.println(myfruit);
    }
} 

/*
M5. Lab A - Enumeration

OBJECTIVE - 

The purpose of this lab is to introduce students to enumerations in Java. Students will learn to implement constructor, method, instance variables and enumerations.

Your task is to implement the followings: 

Create a constructor Fruit that accepts color and taste as default parameters. Insert your code where it says “1. Your code goes here”
Create a getColor() method to return color of selected fruit. Insert your code where it says “2. Your code goes here”
Create a getTaste() method to return taste of the selected fruit. Insert your code where it says “3. Your code goes here”
Implement the foreach loop to display fruit.name(), fruit.getColor(), and fruit.getTaste(). Insert your code where it says “4. Your code goes here” 
What to Submit: 

Screen shots of your output, written code, lesson learned, any known errors or bugs in your code in a Word document.
*/