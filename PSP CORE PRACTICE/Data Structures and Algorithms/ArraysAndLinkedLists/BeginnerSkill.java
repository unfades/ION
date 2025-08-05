/*a.write a recursive function to find the max value in the array without
    using the in built function.
  b.count the number of vowels in the given string using an iterative approach
*/

public class BeginnerSkill{

    static int maxi = Integer.MIN_VALUE;
    static int i = 0;
    public static void max(int[] arr){
        if(i==arr.length-1){
            System.out.println("max is " + maxi);
        }
        if(arr[i]>maxi){
            maxi = arr[i];
        }
        i++;
        if(i<=arr.length-1){
        max(arr);
        }
    }

    public static void main(String[] args) {
        //recursive function finding max
        int[] arr = {-1,-2,-3,-4000,4,-69,-75,-30};
        //a. done
        max(arr);
        
        String myString = "YuhAYEAYE YYH UH iHUH UHUH UHUH HowManyVoweelsssareTHERE?";
        //count numbe of vowels iteratively in the string
        int vcount = 0;
        for(int i = 0; i<myString.length(); i++){
            if("AEIOUaeiou".contains(Character.toString(myString.charAt(i)))){
                vcount++;
            }
        }
        
        //b. done
        System.out.println(myString + " has " + vcount + " vowels in it...");
        //NEEDED HELP FROM https://www.geeksforgeeks.org/java/regular-expressions-in-java/
        //b done while flexing
        int newerVCount = myString.length() - myString.replaceAll("[AEIOUaeiou]", "").length();
        System.out.println(newerVCount);
    }
}