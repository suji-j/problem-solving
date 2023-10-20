import java.io.*;

public class baek_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] strArr = str.split("");
        int[] ascii = new int[strArr.length];
        int[] cnt = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int asciiNum = strArr[i].charAt(0);
            if (asciiNum > 96) {
                asciiNum -= 32;
            }
            ascii[i] = asciiNum;
        }

        for (int i = 0; i < ascii.length; i++) {
            int num = ascii[i] - (int) 'A';
            cnt[num]++;
        }

        int max = cnt[0];
        int maxIndex = 0;
        boolean overlap = false;

        for (int i = 1; i < cnt.length; i++) {
            if (max == 0) {
                max = cnt[i];
                maxIndex = i;
            } else {
                if (max < cnt[i]) {
                    max = cnt[i];
                    maxIndex = i;
                    overlap = false;
                }

            }
        }

        if (overlap == true) {
            System.out.println("?");
        } else {
            System.out.println((char) (maxIndex + 65));
        }
    }
}
