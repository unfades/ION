package Answers;

enum Code{
    
    RED("Fire","Called Fire Department"),
    BLUE("Cardiac Arrest","Called Cardiologist in charge"),
    YELLOW("Bomb Threat","Called 911"),
    ORANGE("Hazardous Material Spill","Called Health and Safety"),
    GREEN("Evacuation","Push the emergency button/alerted hospitals nearby"),
    CLEAR("Situation Resolved","Situation has been resolved");

    private String meaning;
    private String codeName;

    private Code(String codeName, String meaning){
        this.codeName = codeName;
        this.meaning = meaning;
    }

    public String getMeaning(){
        if(!(this == RED || this == YELLOW))
            return this.meaning;
        return this.meaning +", code green activated also: "+ GREEN.meaning;
    }

    public String getCodeName(){
        if(!(this == RED || this == YELLOW))
            return this.codeName;
        return this.codeName +" which also calls "+ GREEN.codeName;
    }

    public static void display(Code c){
        System.out.println( "the codeName is: " + c.getCodeName());
    }
}

public class M5Assignment {
    public static void main(String[] args) {
        Code[] codes = Code.values();
        System.out.println("Display of codes using display() from Code enum: ");
        for(Code c: codes){
            Code.display(c);
        }

        for(Code c: codes){
            System.out.println(c.getMeaning() + ", code: " + c.getCodeName());
        }

        Code[] mine = new Code[2];
        Code m = Code.RED;
        Code n = Code.BLUE;
        mine[0] = m;
        mine[1] = n;
        System.out.println("enum is "+mine[0] + ", code is " + mine[0].getCodeName() + ", meaning is " + mine[0].getMeaning());
        System.out.println("enum is "+mine[1] + ", code is " + mine[1].getCodeName() + ", meaning is " + mine[1].getMeaning());
    }
}

/*
OBJECTIVE: to apply knowledge of Java Enumerations.
TO DO: Read lecture notes several times before doing the Assignment. This is an individual assignment; you are responsible for writing your code and answers. Don't try to copy code from other sources. Start early to finish the assignment on time. Try to use proper variables and constants names using the style and notation you like. Also do proper documentation. Documenting the important part of your code is a must. Submit your pseudocode, Java code, and screenshots of the Java output 
Write a program in Java using enumerations to display hospital emergency code which are defined as follows: 
Code Red = Fire 
Code Blue = Cardiac Arrest 
Code Yellow = Bomb Threat 
Code Orange = Hazardous Material Spill 
Code Green = Evacuation. 
Code Clear = Situation has been resolved
Your program must include a function to display the instructions for each code. For example: 

Code Red: Call Fire Department and activate code Green 
Code Blue: Call cardiologist in charge 
Code Yellow: Call 911 and activate code Green 
Code Orange: Call Health and Safety 
Code Green: push the emergency button or alert hospital workers. 
Code Clear: deactivate all code.
Your program also must include a function to display the initialization values for each code. For example, Code Green must display Evacuation, Code Red must display Fire, and so on.
*/
