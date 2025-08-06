package SearchingNSortingAlgorithms;

import java.util.List;
import java.util.ArrayList;

class SortingAndSearching{
    public static void selectionSort(List<String> a){
        for(int i = 0; i<a.size(); i++){
            for(int j = i; j<a.size(); j++){
                if(a.get(j).compareTo(a.get(i)) == 0) continue;
                if(a.get(j).compareTo(a.get(i)) <  0){
                    String temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
    }

    public static void mergeSort(List<String> a){
        int length = a.size();
        if(length<=1) return; //recursion base case
        int middle = length/2;
        List<String> leftList = new ArrayList<>();
        List<String> rightList = new ArrayList<>();
        int j = 0;
        //copy vals from a into leftList and rightList
        for(int i = 0; i<middle; i++){
            leftList.add(a.get(i));
            j++;
        }
        for(int i = 0; i<middle; i++){
            rightList.add(a.get(j));
            j++;
        }

        mergeSort(leftList);
        mergeSort(rightList);
        SortingAndSearching ss = new SortingAndSearching();
        ss.merge(leftList, rightList, a);
    }
    public void merge(List<String> leftList, List<String> rightList, List<String> a){
        int i = 0, l = 0, r = 0;
        int rightSize = rightList.size();
        int leftSize = leftList.size();

        while(l<leftSize && r<rightSize){
            if(leftList.get(l).compareTo(rightList.get(r))<0){
                a.set(i, leftList.get(l));
                i++;
                l++;
            }else{
                a.set(i, rightList.get(r));
                i++;
                r++;
            }
        }
        while(l<leftSize){
            a.set(i, leftList.get(l));
            i++;
            l++;
        }
        while(r<rightSize){
            a.set(i, rightList.get(r));
            i++;
            r++;
        }
    }
}

public class PracticeAssignment1 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("SuperSolidCar");
        myList.add("Hav");
        myList.add("Jay");
        myList.add("Bugatti");
        myList.add("Lamborghini");
        System.out.println(myList);
        SortingAndSearching.selectionSort(myList);
        System.out.println(myList);
        List<String> myList2 = new ArrayList<>();
        myList2.add("King");
        myList2.add("Jack");
        myList2.add("Spades");
        myList2.add("Joker");
        myList2.add("Queen");
        myList2.add("Ten of Hearts");
        myList2.add("Ace");
        myList2.add("Eight of Hearts");
        SortingAndSearching.mergeSort(myList2);
        System.out.println(myList2);
    }
}

/*
What mergesort does:

divides arrays by 2 into subarrays until the arrays reach size 1

a helper method merge that takes 3 args, 
2 arrs of size 1, and the original arr size 2
then it puts them into the original arr in order
*/
