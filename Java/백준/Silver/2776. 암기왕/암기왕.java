import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int note1 = Integer.parseInt(br.readLine());
            arr1 = new int[note1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < note1; j++) {
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr1);

            int note2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < note2; j++) {
                int key = Integer.parseInt(st.nextToken());
                if (binarySearch(key, 0, arr1.length - 1) == 1) sb.append("1\n");
                else sb.append("0\n");
            }
        }

        System.out.println(sb);
    }

    public static int binarySearch(int key, int low, int high) {
        int mid;

        if (low <= high) {
            mid = (low + high) / 2;
            if (key == arr1[mid]) {
                return 1;
            } else if (key > arr1[mid]) {
                return binarySearch(key, mid + 1, high);
            } else {
                return binarySearch(key, low, mid -1);
            }
        }

        return 0;
    }
}