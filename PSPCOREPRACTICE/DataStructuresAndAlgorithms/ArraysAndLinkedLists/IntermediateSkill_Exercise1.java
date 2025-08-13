import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class IntermediateSkill_Exercise1 {
    public static void main(String[] args) {
        int[] unsorted = {1, 5, 7, -1, 5};
        int targetSum = 6;
        List<String> myList = new ArrayList<>();
        //Task 1 Done O(n) squared
        for(int i = 0; i<unsorted.length; i++){
            for(int j = i; j<unsorted.length; j++){
                if(unsorted[i] + unsorted[j] == targetSum){
                    int[] arr = new int[]{unsorted[i],unsorted[j]};
                    myList.add(Arrays.toString(arr));
                }
            }
        }
        System.out.println(myList);
        //Linked List now remove duplicates from an unsorted LinkedList
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(2);
        ll.add(4);
        ll.add(3);
        System.out.println(ll);
        //b. done O(n)
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i<ll.size(); i++){
            if(set.contains(ll.get(i))){
                ll.remove(i);
                i-=1;
            }
            set.add(ll.get(i));
        }
        System.out.println(ll + " removed duplicates");
    }
}

/*
Task 1:
Given an unsorted array and a target sum, write a program to find all pairs
in the array whose sum is equal to the given target.
What is the time complexity of your approach for finding all pairs in the
unsorted array that sum to the target value?
Input: arr = [1, 5, 7, -1, 5], sum = 6
Output: [(1, 5), (7, -1), (1, 5)]

Task 2:
Remove Duplicates from Unsorted Linked List
Write a program to remove duplicates from an unsorted linked list?
Input: 1 -> 2 -> 3 -> 2 -> 4 -> 3
Output: 1 -> 2 -> 3 -> 4
What is the time complexity of your solution for removing duplicates
from the unsorted linked list?
*/