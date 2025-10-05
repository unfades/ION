import java.util.Arrays;

public class Mine {
    public static void main(String[] args) {
        int height = 11;
        int j = 0;
        String[] arr = new String[height];
        String spaces;
        if(height==3){spaces = " ".repeat(9);}else{
            spaces = " ".repeat(height*3+(int)Math.pow(2,height-3));
          }
          Arrays.fill(arr, spaces);
          for(String i: arr){
            System.out.println(i);
          }
          int counter = 0;
          for(int i = 0; i<height; i++){
            char[] arr2 = arr[i].toCharArray();
            arr2[i] = '*';
            arr[i] = new String(arr2);
            counter++;
          }
          
          j = 0;
          for(int i = spaces.length()-1; j<height; i--){
            char[] arr2 = arr[j].toCharArray();
            System.out.println("here");
            arr2[i] = '*';
            //System.out.println(Arrays.toString(arr2));
            arr[j] = new String(arr2);
            j++;
            counter++;
          }
          j = 0;
          for(int i = counter; i<counter+height; i++){
            char[] arr2 = arr[j].toCharArray();
            arr2[i-2] = '*';
            arr[j] = new String(arr2);
            j++;
          }
          
          j = height-1;
          for(int i = height-1; i <height*2-1; i++){
            char[] arr2 = arr[j].toCharArray();
            arr2[i] = '*';
            arr[j] = new String(arr2);
            j--;
          }
          for(String i: arr){
            System.out.println(i);
          }

    }
}
