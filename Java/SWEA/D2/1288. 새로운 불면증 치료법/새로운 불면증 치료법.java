import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[10];
            int mul = 1, ans = 0;

            while (!check(arr)) {
                int curNum = n * mul++;
                String str = String.valueOf(curNum);

                for (int i = 0; i < str.length(); i++) {
                    int num = Integer.parseInt(String.valueOf(str.charAt(i)));
                    arr[num]++;
                }
                ans++;
            }
            bw.write("#" + tc + " " + (ans * n) + "\n");
        }
        bw.close();
    }

    static boolean check(int[] arr) {
        for (int i = 0; i < 10; i++) {
            if (arr[i] < 1) {
                return false;
            }
        }
        return true;
    }
}
