import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] s = st.nextToken().split(":");
        int sHour = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        String[] e = st.nextToken().split(":");
        int eHour = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        String[] q = st.nextToken().split(":");
        int qHour = Integer.parseInt(q[0]) * 60 + Integer.parseInt(q[1]);

        HashMap<String, Integer> map = new LinkedHashMap<>();
        String str;
        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            if (!st.hasMoreTokens()) {
                break;
            }

            String[] time = st.nextToken().split(":");
            int hour = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            String nickname = st.nextToken();
            if (hour <= sHour) {
                map.put(nickname, 1);
            } else if (hour >= eHour && hour <= qHour && map.containsKey(nickname)) {
                map.put(nickname, 2);
            }
        }

        int ans = 0;
        for (String cur : map.keySet()) {
            if (map.get(cur) == 2) {
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.close();
    }
}
