package BaekJoon;
//1181
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Baek_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        String[] arr = new String[cnt];
        for (int i=0;i<cnt;i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                } else{
                    return o1.length() - o2.length();
                }
            }
        });

        bw.write(arr[0] + "\n");
        for (int i=1; i<cnt; i++){
            if (!arr[i].equals(arr[i-1])){
                bw.write(arr[i] + "\n");
            }
        }

        bw.close();
        br.close();
    }
}
