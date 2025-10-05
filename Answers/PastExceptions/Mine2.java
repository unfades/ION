import java.util.Arrays;

public class Mine2 {
    public static void main(String[] args) {
        
        int n = 3;
        int[][] arr = new int[n][n];
        int f = 0, s = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                arr[f][s] = i*j;
                s++;
                System.out.println(arr[f][s]);
            }
            f++;
        }
        System.out.println(Arrays.toString(arr));
    }
}
