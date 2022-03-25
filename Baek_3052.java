package BaekJoon;
//3052
import java.util.Arrays;
import java.util.Scanner;

public class Baek_3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i=0; i<arr.length;i++){
            int div = sc.nextInt();
            arr[i] = div%42;
        }
        Arrays.sort(arr);
        int count = 1;

        for (int i = 0 ; i<9; i++){
            if (arr[i] != arr[i+1]){
                count++;
            }
        }
        System.out.println(count);
    }
}