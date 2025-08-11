package Inheritance.SkillBuildingExercises;

import java.util.Scanner;

class RobotControlSystem{
    public void move(){
        System.out.println("right foot");
        System.out.println("left foot");
    }

    public void stop(){
        System.out.println("feet stop");
    }
}

class FlyBotSystem extends RobotControlSystem{

    @Override
    public void move(){
        System.out.println("flap fly fly");
        System.out.println("steady flight achieved");
    }
    @Override
    public void stop(){
        System.out.println("stopped flying... steady landing achieved");
    }
}

class SwimBotSystem extends RobotControlSystem{

    @Override
    public void move(){
        System.out.println("Swim swim");
        System.out.println("Slither slither");
    }

    public void stop(){
        System.out.println("stationary in water");
    }
}

public class AdvancedSkills {
    public static void main(String[] args) {
        //by flexibility and reusability it means use parent reference
        //point to child objects
        //make them do stuff then that each can do for the bots

        RobotControlSystem universalBot = new RobotControlSystem();
        boolean b = true;
        while(b){
            System.out.println("What do you want the bot to do currently?");
            System.out.println("Press 1 to switch traversal modes:(air)(water)(land)");
            System.out.println("Press 2 to move the bot.");
            System.out.println("Press 3 to stop the bot.");
            System.out.println("Press anything else to end the program.");
            String choice = "-1";
            Scanner sc = new Scanner(System.in);
            choice = String.valueOf(sc.nextLine());
            switch(choice){
                case "1":
                    System.out.println("which mode to switch to?: ");
                    System.out.println("press 1 to move on land. ");
                    System.out.println("Press 2 to fly in the air.");
                    System.out.println("Press 3 to swim in the water.");
                    int toggleMode = sc.nextInt();
                    if(toggleMode == 1){
                        universalBot = new RobotControlSystem();
                    }
                    if(toggleMode == 2){
                        universalBot = new FlyBotSystem();
                    }
                    if(toggleMode == 3){
                        universalBot = new SwimBotSystem();
                    }
                    break;

                case "2":
                    System.out.println("bot movement output is:");
                    universalBot.move();
                    break;

                case "3":
                    System.out.println("bot stopping...");
                    universalBot.stop();
                    System.out.println("bot has stopped.");
                    break;

                default:
                    b = false;
                    break;
            }
        }
    }
}
