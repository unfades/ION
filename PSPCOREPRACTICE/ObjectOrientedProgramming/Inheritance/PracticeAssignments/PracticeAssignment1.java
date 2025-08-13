package Inheritance.PracticeAssignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Train management inheritance practice assignment 1

class RailwayManagementSystem{
    protected List<Train> trainList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
   
    public void addTrain(int id, String name, int capacity){
        Train t = new Train();
        t.addTrain(id, name, capacity);
        trainList.add(t);
    }

    public void addTrain(){
        Train t = new Train();
        System.out.println("Enter the train name: ");
        String name = String.valueOf(sc.nextLine());
        System.out.println("Enter the train ID: ");
        int id = Integer.valueOf(sc.nextLine());
        System.out.println("Enter the capacity of the train: ");
        int cap = Integer.valueOf(sc.nextLine());
        t.addTrain(id, name, cap);
        trainList.add(t);
    }

    public void addFreightTrain(int id, String name, int capacity){
        Train t = new FreightTrain();
        t.addTrain(id,name,capacity);
        trainList.add(t);
    }

    public void addPassengerTrain(int id, String name, int capacity){
        Train t = new PassengerTrain();
        t.addTrain(id,name,capacity);
        trainList.add(t);
    }
    
    public void showAllTrains(){
        for(Train t: trainList){
            t.displayTrain();
            System.out.println("______________________");
        }
    }
}

//base class train
class Train{
    protected int trainID;
    protected String trainName;
    protected int capacity;

    public void addTrain(int trainID, String trainName, int capacity){
        this.trainID = trainID;
        this.trainName = trainName;
        this.capacity = capacity;
    }

    public void displayTrain(){
        System.out.println("id: " + this.trainID);
        System.out.println("name: " + this.trainName);
        System.out.println("capacity: " + this.capacity);
    }
}

class PassengerTrain extends Train{
    protected int coaches;
    @Override
    public void addTrain(int trainID, String trainName, int capacity){
        this.trainID = trainID;
        this.trainName = trainName;
        this.capacity = capacity;
        this.coaches = capacity;
    }
    @Override
    public void displayTrain(){
        System.out.println("id: " + this.trainID);
        System.out.println("name: " + this.trainName);
        System.out.println("capacity: " + this.capacity);
        System.out.println("Coaches: "+ this.coaches);
    }
}

class FreightTrain extends Train{
    protected int cargoCapacity;
    @Override
    public void addTrain(int trainID, String trainName, int capacity){
        this.trainID = trainID;
        this.trainName = trainName;
        this.capacity = capacity;
        this.cargoCapacity = capacity;
    }
    @Override
    public void displayTrain(){
        System.out.println("id: " + this.trainID);
        System.out.println("name: " + this.trainName);
        System.out.println("capacity: " + this.capacity);
        System.out.println("CargoCap: " + this.cargoCapacity);
    }
}

public class PracticeAssignment1 {
    public static void main(String[] args) {
        RailwayManagementSystem rw = new RailwayManagementSystem();
        rw.addTrain(0,"Train",10);
        rw.addFreightTrain(1,"PasTrain",15);
        rw.addFreightTrain(2,"FreightTrain",20);
        rw.showAllTrains();
    }
}
