package OOPConcepts.PracticeAssignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

class EmployeeManagementSystem{
    //managing ids available and unpresent:
    //works automatically without id being needed as its corresponding to the
    //list sizes directly
    List<Employee> empList = new ArrayList<>();
    List<List<Review>> reviewsList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    
    protected void addEmployee(){
        Employee e = new Employee();
        List<Review> r = new ArrayList<>();
        e.addEmployee();
        empList.add(e);
        reviewsList.add(r);
    }

    protected void addEmployee(Employee e, List<Review> r){
        empList.add(e);
        reviewsList.add(r);
    }

    protected void showAllEmployees(){
        for(Employee i: empList){
            i.displayEmployee();
        }
    }
    
    protected void addReview(){
        int id = -1;
        for(Employee e: empList){
            System.out.println("name: " + e.getName() + " id: " + e.getID());
        }
        System.out.println("for which employee do you want to leave a review?(enter id): ");
        id = Integer.valueOf(sc.nextLine());
        Review r = new Review();
        r.addReview();
        reviewsList.get(id).add(r);
    }

    protected void showReview(){
        int id = -1;
        for(Employee e: empList){
            System.out.println("name: " + e.getName() + " id: " + e.getID());
        }
        System.out.println("for which employee do you want to show a review?(enter id): ");
        id = Integer.valueOf(sc.nextLine());
        System.out.println("employee id is: " + empList.get(id).getID());
        int j = 0;
        for(Review r : reviewsList.get(id)){
            System.out.println("review "+ j + ":" + r.getDate());
            j++;
        }
        j = 0;
        System.out.println("enter the number of the review you want to show: ");
        int num = Integer.valueOf(sc.nextLine());
        for(Review r: reviewsList.get(id)){
            if(j == num){
                r.printReview();
            }
            j++;
        }
    }

    protected void updateReview(){
        int id = -1;
        for(Employee e: empList){
            System.out.println("name: " + e.getName() + " id: " + e.getID());
        }
        System.out.println("for which employee do you want to update a review?(enter id): ");
        id = Integer.valueOf(sc.nextLine());
        System.out.println("employee id is: " + empList.get(id).getID());
        int j = 0;
        for(Review r : reviewsList.get(id)){
            System.out.println("review "+ j + ":" + r.getDate());
            j++;
        }
        j = 0;
        System.out.println("enter the number of the review you want to edit: ");
        int num = Integer.valueOf(sc.nextLine());
        for(Review r: reviewsList.get(id)){
            if(j == num){
                r.updateReview();
            }
            j++;
        }
    }
}

class Review{
    private LocalDate ldt;
    private double rating; //I chose double instead of float so I don't have to explicitly cast so much, it's way more convenient
    private List<String> comment = new ArrayList<>(); //make sure to INITIALIZE BOY
    Scanner sc = new Scanner(System.in);

    protected LocalDate getDate(){
        return ldt;
    }

    protected void addReview(){
        LocalDate ldt = LocalDate.now();
        this.ldt = ldt;
        System.out.println("The date is: " + ldt);
        System.out.println("What rating would you like to give the employee?: ");
        double rat = Double.valueOf(sc.nextLine());
        this.rating = rat;
        char c = 'y';
        System.out.println("Add a comment for the employee: ");
        //c = Character.valueOf(sc.nextLine().charAt(0));
        int j = 0;
        while(c == 'y'){
            System.out.println("Enter comment number " + j + ": ");
            String s = sc.nextLine();
            comment.add(s);
            System.out.println("Add another comment for the employee?(y/n): ");
            j++;
            c = Character.valueOf(sc.nextLine().charAt(0));
        }
        System.out.println("Review details: ");
        System.out.println("Review date: "+ ldt +" Rating given: " + this.rating);
        System.out.println("comments are: ");
        for(String i: comment){
            System.out.println(i);
        }
        System.out.println("Thank you for leaving a review!");
    }

    protected void printReview(){
        System.out.println("Review details: ");
        System.out.println("Review date: "+ ldt +" Rating given: " + this.rating);
        System.out.println("comments are: ");
        for(String i: comment){
            System.out.println(i);
        }
    }

    protected void updateReview(){
        printReview();
        System.out.println("__________________________");
        System.out.println("Press 0 to update rating.");
        System.out.println("Press 1 to open comments menu.");
        System.out.println("What do you want to update?: ");
        int choice = Integer.valueOf(sc.nextLine());
        if(choice == 0){
            System.out.println("Previous rating: " + this.rating);
            System.out.println("Enter a new rating: ");
            double rat = Double.valueOf(sc.nextLine());
            this.rating = rat;
        }
        if(choice == 1){
            
            while(true){
                int j = 0;
                for(String i: comment){
                    System.out.println("comment " + j +" "+i);
                    j++;
                }
                System.out.println("Enter 1 to update comments.");
                System.out.println("Enter 2 to delete a comment.");
                System.out.println("Enter 3 to add a comment.");
                System.out.println("Enter 4 to clear all comments.");
                System.out.println("Enter anything else to exit review updation.");
                String choose = String.valueOf(sc.nextLine());
                if(choose.equals("1")){
                    System.out.println("enter the comment number to update: ");
                    int num = Integer.valueOf(sc.nextLine());
                    System.out.println("Enter the new comment: ");
                    String set = String.valueOf(sc.nextLine());
                    comment.set(num,set);
                }else if(choose.equals("2")){
                    System.out.println("enter the comment number to delete: ");
                    int num = Integer.valueOf(sc.nextLine());
                    comment.remove(num);
                }else if(choose.equals("3")){
                    System.out.println("Add a comment: ");
                    String s = String.valueOf(sc.nextLine());
                    comment.add(s);
                }else if(choose.equals("4")){
                    comment.clear();
                }else{
                    System.out.println("done updating...");
                    printReview();
                    break;
                }
            }
        }
    }
}

class Employee{
    //to generate new IDs
    private static int idAssigner;
    //this idAssigner will assign into this.id here for the Emp object
    private int id;
    private String name;
    private String position;
    private double salary;
    private double perfRating;
    Scanner sc = new Scanner(System.in);
    protected List<Review> revList = new ArrayList<>();

    //methods
    //employee creation
    protected void addEmployee(String name, String position, double salary,  double perfRating){
        this.id = idAssigner++;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.perfRating = perfRating;
    }

    protected void addEmployee(){
        String name; String position; double salary;  double perfRating;
        System.out.println("Enter the name of the employee: ");
        name = String.valueOf(sc.nextLine());
        System.out.println("Enter the position of the employee: ");
        position = String.valueOf(sc.nextLine());
        System.out.println("Enter the salary for the employee: ");
        salary = Double.valueOf(sc.nextLine());
        System.out.println("Enter the performance score for the employee: ");
        perfRating = Double.valueOf(sc.nextLine());
        this.id = idAssigner++;
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.perfRating = perfRating;
    }

    protected String getName(){
        return this.name;
    }
    protected int getID(){
        return this.id;
    }

    protected void updateDetails(String id){
        try{
            if(this.id == Integer.parseInt(id)){
                Scanner sc = new Scanner(System.in);
                while(true){
                    displayEmployee();
                    System.out.println("What do you want to change?");
                    System.out.println("enter the corresponding number to alter employee details: ");
                    System.out.println("enter anything else to exit updating Employee: name:" + this.name + " id: " + this.id);
                    String change = "0";
                    change = String.valueOf(sc.nextLine());
                    change = change.toLowerCase();
                    switch(change){
                        case "1": case "id":
                            System.out.println("Enter new id: ");
                            int newID = Integer.valueOf(sc.nextLine());
                            this.id = newID;
                            break;
                        case "2": case "name":
                            System.out.println("Enter new name: ");
                            String newName = String.valueOf(sc.nextLine());
                            this.name = newName;
                            break;
                        case "3": case "pos": case "position":
                            System.out.println("Enter new position: ");
                            String newPosition = String.valueOf(sc.nextLine());
                            this.position = newPosition;
                            break;
                        case "4": case "salary":
                            System.out.println("Enter new salary: ");
                            double newSalary = Double.valueOf(sc.nextLine());
                            this.salary = newSalary;
                            break;
                        //dynamically setting cases to be whatever the user enters even tho numbers were specified...
                        case "5": case "performance": case "performance score":
                            System.out.println("Enter new performance score: ");
                            Double newPerf = Double.valueOf(sc.nextLine());
                            this.perfRating = newPerf;
                            break;
                        default:
                            change = "stop";
                            break;
                    }
                    if(change == "stop") break;
                }
                sc.close();
            }
        }catch(Exception e){
            System.out.println("there was a problem with updating, details:" + e.getMessage());
        }
    }

    protected void displayEmployee(){
        System.out.println("1. id: "+this.id);
        System.out.println("2. name: "+this.name);
        System.out.println("3. position: "+this.position);
        System.out.println("4. salary: "+this.salary);
        System.out.println("5. performance score: "+this.perfRating);
        System.out.println("____________________________________________");
    }
}

public class PracticeAssignment1 {
    public static void main(String[] args){
        //1st task done 2nd task done 3rd task done
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.addEmployee();
        ems.addEmployee();
        ems.showAllEmployees();
        ems.addReview();
        ems.updateReview();
        ems.showReview();
    }
}

/*
Problem Description
A company needs a system to manage its employees, including adding
new employees, updating employee details, and tracking their
performance. This practice assignment outlines a structured approach for
developing a simple Employee Management System using ObjectOriented Programming principles.

Task 1: Employee Management (Class-Based Implementation)
Create a class (Python or C++ or Java) to represent an employee.
Each Employee object should contain:
• Employee ID (Integer)
• Name (String)
• Position (String)
• Salary (Float)
• Performance Rating (Float)

Operations to Implement:
• Add a new employee.
• Update employee details.
• Display employee details.

Solution Hints
- Use any programming language (C++,Java or Python)
- Create a class named Employee with
attributes: employee_id, name, position, salary,
and performance_rating.
- Use the __init__() constructor to initialize these attributes when
creating a new employee object.
- Implement a method update_details() that allows updating one or
more attributes (e.g., name, position, salary).
- Add a method display_details() to print or return a formatted string
of the employee’s information.

 Use __str__() or __repr__() for cleaner output when printing
employee objects.
• Validate input types (e.g., salary and rating should be floats) to
ensure data consistency.
• Consider using unique employee_id values to identify and manage
employees effectively.

Task 2: Performance Tracking (Class-Based Implementation)
Create a class (Pyhton, C++, Java) to track employee performance.
Each Performance object should contain:
• Employee ID (Integer)
• Review Date (String)
• Rating (Float)
• Comments (String)
Operations to Implement:
• Add a performance review for an employee.
• Update a performance review.
• Display performance reviews for a specific employee.

Solution Hints
ü Create a class named PerformanceReview withattributes: employee_id,
review_date, rating, and comments.
ü Use the __init__() constructor to initialize review details whencreating a
new review object.

• Implement a method update_review() to modify the rating and/or
comments of an existing review.
• Add a method display_review() to show the review details in a
readable format.
• Use consistent date formatting (e.g., "YYYY-MM-DD")
for review_date to simplify filtering and sorting.
• Store multiple reviews per employee using a list or dictionary keyed
by employee_id.
• Ensure that reviews are linked to valid employees by checking if
the employee_id exists before adding a review.

Task 3: Employee Management System (Class-Based Implementation)
Create a class (Pyhton, C++, Java) to manage the overall employee
management system. The Employee Management System class should
contain:
• Employees (List of Employee objects)
• Performance Reviews (List of Performance objects)
Operations to Implement:
• Add a new employee.
• Update employee details.
• Display all employees.
• Add a performance review for an employee.
• Update a pe rformance review.
• Display performance reviews for a specific employee.

*/
