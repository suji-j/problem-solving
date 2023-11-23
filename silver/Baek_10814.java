package BaekJoon;
//10814
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        String[][] strArr = new String[cnt][2];

        for (int i=0; i<cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            strArr[i][0] = st.nextToken();
            strArr[i][1] = st.nextToken();
        }

        Arrays.sort(strArr, new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                    }
                }
        );

        for(int i=0;i<cnt;i++){
            bw.write(strArr[i][0] + " " + strArr[i][1] + "\n");
        }

        bw.close();
        br.close();
    }
}
