package Inheritance.SkillBuildingExercises;

//base class parent
class Product{
    protected String name;
    protected double price;
    
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public double getFinalPrice(){
        return this.price;
    }
    public void setTaxPercent(double tax) {
        //just to override it because I am using the parent class object in main
        //to point to children classes objects and this didnt have a child's method setTaxPercent
        //so I made it in the parent so in the child there are no problems and @Overrided it
    }
}
//subClasses of children
//10 percent off
class DiscountedProduct extends Product{
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setPrice(double price){
        price -= (0.10*price);
        this.price = price;
    }
    @Override
    public double getFinalPrice(){
        return this.price;
    }
    public void getName(){
        System.out.println(this.name);
    }
}
//taxExcempt
class TaxExemptProduct extends Product{
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setPrice(double price){

        this.price = price;
    }
    @Override
    public double getFinalPrice(){
        return this.price;
    }
    public void getName(){
        System.out.println(this.name);
    }
}
//taxed
class TaxedProduct extends Product{
    double tax;
    public void setName(String name){
        this.name = name;
    }
    @Override
    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public void setTaxPercent(double tax){
        this.tax = tax/100;
    }
    @Override
    public double getFinalPrice(){
        return this.price + tax;
    }
    public void getName(){
        System.out.println(this.name);
    }
}
//exercise 2
class Human{
    protected String name;
}

class Employee extends Human{
    protected int employeeID;
}

class RemoteWorker extends Employee{
    protected String location;
}
//multi-level inheritance implemented now RemoteEmployee can use both RemoteWorker and Employee done
class RemoteEmployee extends RemoteWorker{
    //this one will display all the inherited attributes from the other classes in this one's method

    public void setRemoteEmployee(String name, int employeeID, String location){
        this.name = name;
        this.employeeID = employeeID;
        this.location = location;
    }
    public void displayRemoteEmployee(){
        System.out.println("name is: "+this.name + " id is: " + this.employeeID +" location is: "+ this.location);
    }
}

public class IntermediateSkills {
    public static void main(String[] args) {
        Product p = new Product();
        p.setName("apple");
        p.setPrice(5.0);
        System.out.println(p.getFinalPrice());

        p = new DiscountedProduct();
        p.setName("discounted");
        p.setPrice(10.0);
        System.out.println(p.getFinalPrice());

        p = new TaxExemptProduct();
        p.setName("exempt");
        p.setPrice(5.0);
        System.out.println(p.getFinalPrice());

        p = new TaxedProduct();
        p.setName("exempt");
        p.setTaxPercent(10);
        p.setPrice(5.0);
        System.out.println(p.getFinalPrice());
        
        System.out.println("_______________________________________");
        RemoteEmployee rem = new RemoteEmployee();
        rem.setRemoteEmployee("ryan holmes", 77, "north america");
        rem.displayRemoteEmployee();
    }
}

//do not duplicate variables from the parent in the child classes
//they will just be inherited alright,
//useful when the parent object ref points to children objects in memory
//to specify their values into it

//also note in order to use inherited attributes from other classes in children make them protected
//then only children classes can extend and use the attributes within them
//if private then they cannot

/*
Exercise 2
You are designing a personnel system for a modern organization that
supports on-site and remote employees. Employees have general
human attributes (like name), and depending on their role and
location, they may also have specialized attributes.
Model an employee system:
• Human (base class with name)
• Employee (extends Human, adds employee_id)
• Remote Worker (has location)
• Remote Employee inherits from both and prints all details
Implement this system using object-oriented principles, particularly
focusing on inheritance and constructor chaining in the context of
hybrid inheritance.
*/