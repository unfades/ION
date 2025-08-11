package Inheritance.SkillBuildingExercises;

import java.util.List;
import java.util.ArrayList;

class Course{

    String name;
    private List<Object> courseList = new ArrayList<>();

    public void setName(String name){   
        this.name = name;
    }

    public void setSchedule(String course){
        courseList.add(course);
    }

    public void getSchedule(){
        System.out.println("Course name is: " + this.name);
        System.out.println("Schedule of the courses are: " );
        for(Object o : courseList){
            System.out.println(o);
        }
    }
}

class HybridCourse extends Course{
    
    String name;
    private List<String> hybridList = new ArrayList<>();

    @Override
    public void setName(String name){   
        this.name = name;
    }
    @Override
    public void setSchedule(String s){
            hybridList.add(s);
    }

    @Override
    public void getSchedule(){
        System.out.println("hybrid course name is: " + this.name);
        System.out.println("courses are: ");
        for(String s: hybridList){
            System.out.println(s);
        }
    }

}

class OnlineCourse extends Course{

    String name;
    private List<String> onlineList = new ArrayList<>();
    
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setSchedule(String s){
            onlineList.add(s);
    }

    @Override
    public void getSchedule(){
        System.out.println("online course name is: " + this.name);
        System.out.println("courses are: ");
        for(String s: onlineList){
            System.out.println(s);
        }
    }
}

class OfflineCourse extends Course{

    String name;
    private List<String> offlineList = new ArrayList<>();
    
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setSchedule(String s){
            offlineList.add(s);
    }
    @Override
    public void getSchedule(){
        System.out.println("offline course name is: " + this.name);
        System.out.println("courses are: ");
        for(String s: offlineList){
            System.out.println(s);
        }
    }
}

abstract class Appliance{
    abstract void specifyDevice(String name);
}

abstract interface CoolingDevice{
    abstract void setMaxTemp(double maxTemp);
}

abstract interface WiFiEnabled{
    abstract void wifiStatus(boolean b);
}

class SmartFridge extends Appliance implements CoolingDevice, WiFiEnabled{

    String name;
    double maxTemp;
    int capacity;
    boolean wifiStatus;
    
    public void specifyDevice(String name){
        this.name = name;
    }
    public void setMaxTemp(double maxTemp){
        this.maxTemp = maxTemp;
    }
    public void wifiStatus( boolean wifiStatus){
        this.wifiStatus = wifiStatus;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void printDetails(){
        System.out.println("name: " + this.name);
        System.out.println("maxTemp: " + this.maxTemp);
        System.out.println("capacity: "+ this.capacity);
        System.out.println("wifiStatus: " + this.wifiStatus);
    }
}


public class BeginnerSkills{
    public static void main(String[] args) {
        //exercise 1
        List<Course> courseList = new ArrayList<>();
        Course courseAdder = new HybridCourse();
        courseAdder.setName("Java Hybrid Course");
        courseAdder.setSchedule("9:AM-5PM");
        courseList.add(courseAdder);
        courseAdder = new OfflineCourse();
        courseAdder.setName("Java Offline Course");
        courseAdder.setSchedule("Monday-Friday, 5PM-6PM");
        courseList.add(courseAdder);
        courseAdder = new OnlineCourse();
        courseAdder.setName("Python Online Course");
        courseAdder.setSchedule("Mondays, 5PM-6PM");
        courseList.add(courseAdder);
        //runtime polymorphism, getSchedule called for hybrid, offline, and online course for all the child classes... using parent object reference
        for(Course c : courseList){
            c.getSchedule();
        }
        System.out.println("-----------------------------------");
        //exercise 2
        SmartFridge smarty = new SmartFridge();
        smarty.specifyDevice("tata Smart Fridge");
        smarty.setMaxTemp(100.0);
        smarty.setCapacity(10);
        smarty.wifiStatus(true);
        smarty.printDetails();
    }
}
