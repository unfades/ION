import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class AdvancedSkillBuilding {

    //coming in is String[] arr = {"eat", "tea","tan","ate","nat","bat"};
    //strat arrays.sort compare each then just group similars into their own arrays
    public static String[][] groupAnagrams(String[] arr){
        HashSet<String> set = new HashSet<>();
        List<List<String>> endList = new ArrayList<>();
        for(int i = 0; i< arr.length-1; i++){
            List<String> list = new ArrayList<>();
            char[] ch = arr[i].toCharArray();
            Arrays.sort(ch);
            for(int j = i+1; j<arr.length; j++){
                char[] ch2 = arr[j].toCharArray();
                Arrays.sort(ch2);
                String one = new String(ch);
                String two = new String(ch2);
                if(one.equals(two)){
                    if(!set.contains(arr[i])){
                    list.add(arr[i]);
                    set.add(arr[i]);
                    }
                    if(!set.contains(arr[j])){
                        list.add(arr[j]);
                        set.add(arr[j]);
                    }
                }
            }
            if(!list.isEmpty())
            endList.add(list);
            
        }

        for(int i = 0; i<arr.length; i++){
            if(!set.contains(arr[i])){
                List<String> single = new ArrayList<>();
                single.add(arr[i]);
                endList.add(single);
            }
        }

        String[][] returned = new String[endList.size()][];
        int j = 0;
        for(List<String> l : endList){
            returned[j] = new String[l.size()];
            int k = 0;
            for(String i: l){
                returned[j][k] = i;
                k++;
            }
            j++;
        }
        return returned;
    }
    
    public static void main(String[] args) {
        List<Integer> ll = new LinkedList<>();
        //reverse linked list in groups of size K at a time
        int k = 4;
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        ll.add(10);
        System.out.println(ll);
        //with gpt improvements, go over this code
        for(int i = 0; i<ll.size()-k; i+=k){
            if (i + k > ll.size()) break;
            List<Integer> ll2 = new LinkedList<>();
            for(int j = 0; j<k; j++){
                ll2.add(ll.get(i + k - j - 1));
            }
            System.out.println(ll2);
            for (int j = 0; j < k; j++) {
                ll2.add(ll.get(i + k - j - 1));
            }
            for (int j = 0; j < k; j++){
                ll.set(i+j, ll2.get(j));
            }
        }
        System.out.println(ll);

        //Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
        //Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
        String[] arr = {"eat", "tea","tan","ate","nat","bat", "nate", "ante"};
        String[][] answer = groupAnagrams(arr);
        for(String[] i: answer){
            System.out.print(Arrays.toString(i) + " ");
        }
    }
}

/*
b. group anagrams

Group Anagrams

Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
Write a program to group all anagrams together from the given list of
strings.
What is the time complexity of grouping anagrams from the given list
of strings?

*/
