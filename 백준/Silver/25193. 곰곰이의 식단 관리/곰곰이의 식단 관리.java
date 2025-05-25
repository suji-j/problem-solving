import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int cntC = 0;
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'C') cntC++;
        }

        int left = 1;
        int right = cntC;
        int answer = cntC;

        while (left <= right) {
            int mid = (left + right) / 2;
            int groupCount = (cntC + mid - 1) / mid;
            int requiredX = groupCount - 1;
            int cntX = N - cntC;

            if (cntX >= requiredX) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}