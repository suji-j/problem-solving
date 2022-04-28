package BaekJoon;

import java.io.*;

//1475- 방 번호
public class Baek_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String numStr = br.readLine();
        int[] numArr = new int[10];
        int[] roomNum = new int[numStr.length()];
        int max = 0;

        for (int i = 0; i < roomNum.length; i++) {
            roomNum[i] = numStr.charAt(i) - '0';
            if (roomNum[i] == 9) {
                roomNum[i] = 6;
            }
            int cnt = roomNum[i];
            numArr[cnt]++;
        }

        if (numArr[6] % 2 == 0) {
            numArr[6] = numArr[6] / 2;
        } else {
            numArr[6] = numArr[6] / 2 + 1;
        }

        for (int i = 0; i < numArr.length; i++) {
            if (max < numArr[i]){
                max = numArr[i];
            }
        }

        bw.write(max+"");

        bw.close();
        br.close();
    }
}
