import java.util.List;
import java.util.LinkedList;

class CourseRegistration{
    private int courseID;
    private String courseName;
    private String instructor;
    private int credits;
    private final int maxEnrollments = 5;
    private boolean[] enrollments = new boolean[maxEnrollments];
    List<Object> tracker = new LinkedList<>();
    List<List<Object>> studentTracker = new LinkedList<>();
    public void addCourse(String courseName){
        this.courseName = courseName;
    }
    public String updateCourseName(String courseName){
        this.courseName = courseName;
        return "The course has been updated\n" + "The courseName is " + this.courseName;
    }
    public String updateCourseID(int courseID){
        this.courseID = courseID;
        return "The course has been updated\n" + "The courseID is " + this.courseID;
    }
    public String updateCourseInstructor(String instructor){
        this.instructor = instructor;
        return "The course instructor has been updated\n" + "The course instructor is now " + this.instructor;
    }
    public String updateCourseCredits(int credits){
        this.credits = credits;
        return "The credits for the course " + this.courseName + " have been updated to " + this.credits;
    }
    public String isAvailable(){
        String s  = "The course is unavailable";
        for(int i = 0; i<enrollments.length; i++){
            if(enrollments[i] == false){ s = "The course is available with " + (maxEnrollments-i) + " seats left"; break;}
        }
        return s;
    }

    public String enrollForCourse(String courseName){
        String s = "Sorry you cannot enroll in the course as it is fully booked out";
        int memberNumber = 0;
        for(int i = 0; i<enrollments.length; i++){
            if(enrollments[i] == false){
                enrollments[i] = true;
                s = "You have been booked into the course as it was available, welcome to " + this.courseName + "!";
                memberNumber = i;
                break;
            }
        }
        if(s.contains("You have been booked")){
            System.out.println("Congratulations, you're member number " + (memberNumber+1) + "!");
            
            //initialized here for the course they are taking
            // NEW tracker for each student
            List<Object> tracker = new LinkedList<>();
            tracker.add((Integer)(memberNumber+1)); //StudentID
            tracker.add((Integer)this.courseID);    // courseID
            tracker.add("Unstarted");             // Grade
            tracker.add("0.0");                   // Completion %
            tracker.add("Not Started");           // Status
            studentTracker.add(tracker); // Add unique tracker
            //I guess it works that way...
            //[StudentID(const)][courseID(const)][GradeOfCOurse][CompletionStatus(Percentage to Str)][CourseCompletion(NotStarted, Partial, Completed)]
        }else{
            System.out.println("The capacity of " + maxEnrollments + " has been reached for the course " + this.courseName);
        }
        return s;
    }
    public void completeModule1(int studentID) {
    
    List<Object> studentData = (List<Object>) studentTracker.get(studentID);
    double currentCompletion = Double.parseDouble((String) studentData.get(3));
    if (currentCompletion >= 10.0) return;
        currentCompletion += 10.0;
        studentData.set(3, "" + currentCompletion);
        studentData.set(4, "Partial");
        if (currentCompletion == 100.0) {
        studentData.set(4, "Completed");
        studentData.set(2, "A");
        }
        studentTracker.set(studentID, studentData);
    }

    public void completeModule2(int studentID) {
    
    List<Object> studentData = (List<Object>) studentTracker.get(studentID);
    double currentCompletion = Double.parseDouble((String) studentData.get(3));
    if (currentCompletion >= 20.0) return;
        currentCompletion += 20.0;
        studentData.set(3, "" + currentCompletion);
        studentData.set(4, "Partial");
        if (currentCompletion == 100.0) {
        studentData.set(4, "Completed");
        studentData.set(2, "A");
        }
        studentTracker.set(studentID, studentData);
    }
    public void completeModule3(int studentID) {
    
    List<Object> studentData = (List<Object>) studentTracker.get(studentID);
    double currentCompletion = Double.parseDouble((String) studentData.get(3));
    if (currentCompletion >= 100.0) return;
        currentCompletion += 70.0;
        studentData.set(3, "" + currentCompletion);
        studentData.set(4, "Partial");
        if (currentCompletion == 100.0) {
        studentData.set(4, "Completed");
        studentData.set(2, "A");
        }
        studentTracker.set(studentID, studentData);
    }
}

public class PracticeAssignment1 {
    public static void main(String[] args) {
        CourseRegistration c = new CourseRegistration();
        c.addCourse("C Programming");
        c.updateCourseID(1);
        c.updateCourseInstructor("Benjamin Franklin");
        c.updateCourseCredits(4);
        System.out.println(c.isAvailable());
        System.out.println(c.enrollForCourse("C Programming"));
        System.out.println(c.isAvailable());
        System.out.println(c.enrollForCourse("C Programming"));
        System.out.println(c.isAvailable());
        System.out.println(c.enrollForCourse("C Programming"));
        System.out.println(c.isAvailable());
        System.out.println(c.enrollForCourse("C Programming"));
        System.out.println(c.isAvailable());
        System.out.println(c.enrollForCourse("C Programming"));
        System.out.println(c.isAvailable());
        System.out.println(c.enrollForCourse("C Programming"));
        System.out.println(c.isAvailable());
        System.out.println(c.enrollForCourse("C Programming"));

        System.out.println(c.studentTracker.get(0)); //gets the ID

        c.completeModule1(0); //for student 1 of the c course
        c.completeModule2(0);
        c.completeModule3(0);//for student 1 of c course
        System.out.println(c.studentTracker.get(0)); //gets the ID

        CourseRegistration java = new CourseRegistration();
        java.addCourse("Java Programming");
        java.updateCourseID(2);
        java.updateCourseInstructor("Benjamin Button");
        java.updateCourseCredits(4);
        System.out.println(java.isAvailable());
        System.out.println(java.enrollForCourse("Java Programming"));
        //LinkedListStructure we created for each course...
        //[StudentID(const)][courseID(const)][GradeOfCOurse][CompletionStatus(Percentage)][CourseCompletion(NotS, Part, Comp)]
        System.out.println(java.studentTracker.get(0)); //gets the ID
        java.completeModule1(0); //for student 1 of the java course
        java.completeModule2(0);
        java.completeModule3(0);//for student 1 of java course
        java.completeModule2(0);
        System.out.println(java.studentTracker.get(0)); //gets the ID

        System.out.println(java.isAvailable());
        System.out.println(java.enrollForCourse("Java Programming"));
        //LinkedListStructure we created for each course...
        //[StudentID(const)][courseID(const)][GradeOfCOurse][CompletionStatus(Percentage)][CourseCompletion(NotS, Part, Comp)]
        System.out.println(java.studentTracker.get(1));
        
        java.completeModule1(1);
        //java.completeModule2(1);
        java.completeModule3(1);
        java.completeModule2(1);
        System.out.println(java.studentTracker.get(1));
        
    }
}