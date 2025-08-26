import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int num = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0, right = 0;
        boolean isSame = false;
        for (int i = 0; i < size - 1; i++) {
            if (arr[i] < num && arr[i + 1] > num) {
                left = arr[i];
                right = arr[i + 1];
                break;
            } else if (arr[i] == num || arr[i + 1] == num) {
                isSame = true;
                break;
            } else {
                right = arr[0];
            }
        }

        if (isSame) {
            bw.write("0");
        } else {
            int start = num - left;
            int end = right - num;
            bw.write(String.valueOf(start * end - 1));
        }

        bw.close();
    }
}
