import java.util.Arrays;
import java.util.Scanner;

public class PracticeAssignment1{
  //my method to print the grid and bot location on it
  public static void printGrid(String[][] grid){
  	for(int i = 0; i<grid.length; i++){
    	System.out.println(Arrays.toString(grid[i]));
    }
  }
  
  public static void main(String[] args){
    /*the 2d puzzle solved --- the grid is 5x5 0,0 top left to 4,4 bottom right okay --- bot starts at 2,2 --- making the bot's grid to traverse it --- String grid because let's make bot represented by "O" String and tiles by "[]" String */
    String[][] botGrid = new String[5][5];
    for(int i = 0; i<botGrid.length; i++){
      Arrays.fill(botGrid[i], "[]");
    }
    botGrid[2][2] = "O "; //start position
    System.out.println("Start position was: ");
    printGrid(botGrid);
    botGrid[2][2] = "[]"; //if the bot moved somewhere besides 2,2 then this will be an empty tile []
    Scanner sc = new Scanner(System.in); //to scan the strings entered.
    System.out.println("How many commands do you want to enter to move the bot?: ");
    int commands = Integer.valueOf(sc.nextInt());
    sc.nextLine();
    String[] commandArray = new String[commands];
    //we know the format will be like U 2, D 1, L 3, etc etc so we will scan the string that way
    for(int i = 0; i<commandArray.length; i++){
    	commandArray[i] = String.valueOf(sc.nextLine());
    }
    int leftRight = 2;
    int upDown = 2; //for row calculation 0-4th index
    
    for(int i = 0; i<commandArray.length; i++){
    	if(commandArray[i].contains("u") || commandArray[i].contains("U")){
        	int move = Integer.parseInt(""+(commandArray[i].charAt(commandArray[i].length()-1)));
          	upDown-=move;
            if(upDown>4) upDown = 4; //resetting if out of the grid
            if(upDown<0) upDown = 0;
      }
      if(commandArray[i].contains("d") || commandArray[i].contains("D")){
        	int move = Integer.parseInt(""+(commandArray[i].charAt(commandArray[i].length()-1)));
          	upDown+=move;
            if(upDown>4) upDown = 4; //resetting if out of the grid
            if(upDown<0) upDown = 0;
      }
      if(commandArray[i].contains("r") || commandArray[i].contains("R")){
        	int move = Integer.parseInt(""+(commandArray[i].charAt(commandArray[i].length()-1)));
          	leftRight+=move;
            if(leftRight>4) leftRight = 4; //resetting if out of the grid
            if(leftRight<0) leftRight = 0;
      }
      if(commandArray[i].contains("l") || commandArray[i].contains("L")){
        	int move = Integer.parseInt(""+(commandArray[i].charAt(commandArray[i].length()-1)));
          	leftRight-=move;
            if(leftRight>4) leftRight = 4; //resetting if out of the grid
            if(leftRight<0) leftRight = 0;
      }
    }
    //my solution assumes that there is no input where the numbers go beyong single digits with U D L R directions..
    botGrid[upDown][leftRight] = "O ";
    System.out.println("After the specified inputs, the position is: ");
    printGrid(botGrid);
  }
}