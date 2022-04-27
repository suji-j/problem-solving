package BaekJoon;
//1475-방 번호

import java.io.*;
import java.util.Arrays;

public class Baek_1275 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String roomNum = br.readLine();
        int[] arr = new int[roomNum.length()];
        int six = 1;
        int set = 1;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = roomNum.charAt(i) - '0';
            if (arr[i] == 9) {
                arr[i] = 6;
            }
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                if (arr[i] == 6) {
                    six++;
                } else {
                    set++;
                }
            }
        }

        if (six / 2 < set) {
            bw.write(set + "");
        } else {
            if (six % 2 == 0) {
                cnt = six / 2;
            } else {
                cnt = six / 2 + 1;
            }
            bw.write(cnt + "");
        }

        bw.close();
        br.close();
    }
}
