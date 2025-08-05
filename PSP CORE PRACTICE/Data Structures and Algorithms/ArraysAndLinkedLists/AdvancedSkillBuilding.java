import java.util.LinkedList;
import java.util.List;

public class AdvancedSkillBuilding {
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
    }
}
