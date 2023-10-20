import java.io.*;
import java.util.Arrays;

public class baek_1157_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toUpperCase().toCharArray();
        int[] cntArr = new int[arr.length];
        Arrays.sort(arr);
//        System.out.println("arr : " + Arrays.toString(arr));

        int count = 1;
        cntArr[0] = count;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                count += 1;
                cntArr[i] = count;
            } else if (arr[i - 1] != arr[i]) {
                count = 1;
                cntArr[i] = count;
            }
        }

        int highNum = cntArr[0];
        int highIndex = 0;
        int same = 0;

        if (arr.length != 1) {
            for (int i = 1; i < cntArr.length; i++) {
                if (highNum < cntArr[i]) {
                    highNum = cntArr[i];
                    highIndex = i;
                    same = 0;
                } else if (highNum == cntArr[i] && i != highIndex) {
                    same = 1;
                }
            }
        }

//        System.out.println("cntArr : " + Arrays.toString(cntArr));
//        System.out.println("HighNum : " + highNum);
//        System.out.println("highIndex : " + highIndex);

        if (same == 1) {
            System.out.println("?");
        } else {
            System.out.println(arr[highIndex]);
        }
    }
}
