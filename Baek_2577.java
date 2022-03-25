package BaekJoon;
//2577
//int -> String -> int
import java.util.Arrays;
import java.util.Scanner;

public class Baek_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int mul = sc.nextInt() * sc.nextInt() * sc.nextInt();
        String temp = Integer.toString(mul); //문자열 "17037300"

        int[] arr = new int[temp.length()]; //문자열 길이 8, length()메소드
        for (int i = 0; i < temp.length(); i++) {
            arr[i] = temp.charAt(i) - 48; //char -> int(Ascii) => -48
        }

        //System.out.print(Arrays.toString(arr));

        for (int i=0; i<10; i++){
            int count = 0;
            for (int j=0; j < arr.length; j++){
                if (arr[j] == i){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
