import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, max = 0;
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        while (right < n) {
            if (map.getOrDefault(arr[right], 0) < k) {
                map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
                right++;
            } else {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }

            max = Math.max(max, right - left);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
