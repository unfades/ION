package SearchingNSortingAlgorithms;

import java.util.Arrays;

public class BroCodeMergeSort {

    private static void mergeSort(int[] array) {
        int length = array.length;
        if(length<=1) return; //base case to stop
        int middle = length/2;
        int[] leftarr = new int[middle];
        int[] rightarr = new int[length - middle];
        //fill left and right arrs with vals from arr
        for(int i = 0; i<leftarr.length; i++){
            leftarr[i] = array[i];
        }
        for(int i = 0; i<rightarr.length; i++){
            rightarr[i] = array[i+middle];
        }
        mergeSort(leftarr);
		mergeSort(rightarr);
		merge(leftarr, rightarr, array);
    }
    private static void merge(int[] leftarr, int[] rightarr, int[] array){
        int i = 0, r = 0, l = 0;
        int rightSize = rightarr.length;
        int leftSize = leftarr.length;
        while(l<leftSize && r<rightSize){
            if(leftarr[l]<rightarr[r]){
                array[i] = leftarr[l];
                i++;
                l++;
            }else{
                array[i] = rightarr[r];
                i++;
                r++;
            }
        }
        while(l<leftSize){
            array[i] = leftarr[l];
            i++;
            l++;
        }
        while(r<rightSize){
            array[i] = rightarr[r];
            i++;
            r++;
        }
    }
    public static void main(String[] args) {
        int[] array = {1,4,5,2,35,8,99,10,101,3};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
