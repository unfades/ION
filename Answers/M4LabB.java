package Answers;
import java.util.ArrayList; 
import java.util.List; 

public class M4LabB { 

    public static void main(String[] args) { 

    // Create a list of fruits 

        List<Fruit> fruitList = new ArrayList<>();
        //hardware of our pc holds new ArrayList<>() of type Fruit 

        // add some fruits and their prices to the list 
        // 1. Your code goes here 
        //declared fruits and added fruits
        Fruit mango = new Fruit("Mango", 10.0);
        fruitList.add(mango);
        Fruit apple = new Fruit("Apple", 5.0);
        fruitList.add(apple);
        Fruit coconut = new Fruit("Coconut", 35.0);
        fruitList.add(coconut);
        Fruit orange = new Fruit("Orange", 25.0);
        fruitList.add(orange);
        Fruit watermelon = new Fruit("Watermelon", 55.0);
        fruitList.add(watermelon);
        Fruit banana = new Fruit("Banana", 95.0);
        fruitList.add(banana);
        Fruit peach = new Fruit("Peach", 26.0);
        fruitList.add(peach);
        // print the list of fruits and their prices 
        // 2. Your code goes here 
        for(Fruit i: fruitList){
            System.out.println("____________________________________________________________");
            System.out.println("fruit name: " + i.getName() + " fruit price: $" + i.getPrice());

        }
        //selectionSort algorithm
        for(int i = 0; i<fruitList.size(); i++){
            double min = fruitList.get(i).getPrice();
            for(int j = i; j<fruitList.size(); j++){
                if(fruitList.get(j).getPrice() < min){
                    min = fruitList.get(j).getPrice();
                    Fruit temp = fruitList.get(j);
                    fruitList.set(j,fruitList.get(i));
                    fruitList.set(i, temp);
                }
            }
        }
    // Sort the list by price from cheapest to most expensive
    // and print the sorted list of the fruits and their prices
    // 3. Your code goes here 
    System.out.println("afterrrrr");
        for(Fruit i: fruitList){
            System.out.println("____________________________________________________________");
            System.out.println("fruit name: " + i.getName() + " fruit price: $" + i.getPrice());
        }
    } 
}

class Fruit { 

    private String name; //Mango
    private double price; //10.0

 

    public Fruit(String name, double price) { 
        this.name = name; 
        this.price = price;
    }

    public String getName() { 
        return name;
    } 

 

    public double getPrice() {
        return price; 
    } 
} 


/*
OBJECTIVE - The purpose of this lab is to introduce students to List in Java. 

Consider the following code: 

import java.util.ArrayList; 

import java.util.List; 

 

public class FruitPriceList { 

    public static void main(String[] args) { 

    // Create a list of fruits 

        List<Fruit> fruits = new ArrayList<>(); 

 

        // add some fruits and their prices to the list 

        // 1. Your code goes here 

 

        // print the list of fruits and their prices 

        // 2. Your code goes here 

 

    // Sort the list by price from cheapest to most expensive 

        // and print the sorted list of the fruits and their prices 

        // 3. Your code goes here 

    } 

} 

 

class Fruit { 

    private String name; 

    private double price; 

 

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;

    } 

 

    public String getName() { 

        return name; 

    } 

 

    public double getPrice() { 

        return price; 

    } 

} 

    In FruitPriceList class, where it says “1. Your code goes here”, add banana, mango, orange, apple, watermelon,
     peach, and coconut to the list and their corresponding prices.
    In the code above where it says “2. Your code goes here”, print the list of fruits and their prices. 
    In the code above where it says “3. Your code goes here,” implement one of the sort algorithms you learned 
    in previous module to sort the fruits by price from cheapest to most expensive.
*/