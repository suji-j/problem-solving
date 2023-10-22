import java.io.*;
import java.util.StringTokenizer;

public class baek_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] arr = st.nextToken().toCharArray();
        int[] numArr = new int[arr.length];
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int ascii = Character.getNumericValue(arr[i]);
            numArr[i] = ascii;
        }

        int i = numArr.length - 1;
        while (i >= 0) {
            for (int j = 0; j < numArr.length; j++) {
                int pow = (int) Math.pow(B, i);
                sum += numArr[j] * pow;
                i -= 1;
            }
        }

        System.out.println(sum);
    }
}
