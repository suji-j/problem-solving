import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> nArr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nArr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> mArr = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            mArr.add(Integer.parseInt(st.nextToken()));
        }

        for (Integer mNum : mArr) {
            int low = 0;
            int high = nArr.size() - 1;
            boolean isFind = false;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (mNum.equals(nArr.get(mid))) {
                    isFind = true;
                    break;
                } else if (mNum < nArr.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (isFind) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}