package SkillBuildingExercises;

import java.util.Scanner;

public class IntermediateSkillsEx1 {
    
    public static void getMax(int len, int[] arr){
        int max = arr[0];
        for(int i: arr){
            if(i>max) max = i;
        }
        System.out.println("the max element is "+ max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array: ");
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < arr.length; i++){
            System.out.println("enter element no "+ i +": ");
            arr[i]= sc.nextInt();
        }
        getMax(len,arr);
    }
}
