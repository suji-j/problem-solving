package BaekJoon;
//2562
import java.util.Scanner;

public class Baek_2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[9];


        for (int i=0; i< array.length; i++){
            array[i] = sc.nextInt();
        }

        int max = 0;
        int maxNum = 0;

        for(int j=1 ; j<array.length ; j++){
            if (array[j] > array[max]){
                max = j;
                maxNum = j;
            }
        }

        System.out.println(array[max]);
        System.out.println(maxNum+1);
    }
}
