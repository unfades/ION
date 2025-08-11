package RecursionDP;


//PHASE 0 RECURSION MINDSET, EVERYTHING YOU CAN DO ITERATIVELY, YOU CAN RECURSIVELY
//JUST RECURSE IT ALL
//and remember...
/*
Base Case: Prevents infinite recursion.
Recursive Step: Moves toward the base case.
Parameters: Carry information between calls.
Return Values: Flow back from leaves to root of the recursion tree.
*/

public class recurseArraySum {
    
    public static int recurseSum(int[] array, int index){
        if(index == 0) return array[index];
        return array[index] + recurseSum(array, index-1);
    }
    
    public static int recurseSum2(int[] array, int index){
        if(index == array.length) return 0;
        return array[index] + recurseSum2(array, index + 1);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,45};
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
        }
        System.out.println(sum); //done iteratively
        //int recSum = recurseSum(arr, arr.length-1);
        int recSum = recurseSum2(arr, 0);
        System.out.println(recSum);
    }
}
//level 1 complete
//imagine the tree and branches of the recursion
