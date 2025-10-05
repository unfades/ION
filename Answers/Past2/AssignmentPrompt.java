package Answers;

import java.util.Arrays;

public class AssignmentPrompt {
    public static void main(String[] args) {
        int[] arr = {23,43,35,38,7,12,76,10};
        int min = arr[0];
        for(int i = 0; i<arr.length; i++){
            min = arr[i]<min? arr[i]: min;
        }
        System.out.println("minimum element is: "+min);
        
        for(int i = 0; i<arr.length-1; i++){
            int max = arr[i];
            for(int j = i; j<arr.length; j++){
                if(arr[j] > max){
                    max = arr[j];
                    Integer temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("now the array is sorted oppositely using selectionsort after finding the minimum element in it that was : "+ min);
        System.out.println(Arrays.toString(arr));
    }
}
