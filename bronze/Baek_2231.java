import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = Integer.parseInt(input);
        int min = input.length() * 9;
        int[] arr = new int[min];
        int index = 0;

        for (int i = (num - min); i < num; i++) {
            int temp = i;
            int sum = i;
            for (int j = input.length() - 1; j > 0; j--) {
                sum += (int) (temp / Math.pow(10, j));
                temp = (int) (temp % Math.pow(10, j));
            }
            sum += temp;
            arr[index] = sum;
            index++;
        }

        int minConst = num;
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                if (minConst > (num - min + i)) {
                    minConst = num - min + i;
                }
            }
        }

        if (minConst == num) {
            System.out.println("0");
        } else {
            System.out.println(minConst);
        }
    }
}