import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            char[] com = br.readLine().toCharArray();
            int arrSize = Integer.parseInt(br.readLine());
            Deque<Integer> d = new LinkedList<>();
            boolean flag = true;
            boolean error = false;

            String strArr = br.readLine();
            if (arrSize > 0) {
                String[] numArr = strArr.substring(1, strArr.length() - 1).split(",");
                for (String num : numArr) {
                    d.addLast(Integer.parseInt(num));
                }
            }

            for (char command : com) {
                if (command == 'R') {
                    flag = !flag;
                } else {
                    if (d.isEmpty()) {
                        error = true;
                        break;
                    } else {
                        if (flag) {
                            d.removeFirst();
                        } else {
                            d.removeLast();
                        }
                    }
                }
            }

            if (error) {
                bw.write("error\n");
            } else {
                bw.write("[");
                while (!d.isEmpty()) {
                    if (flag) {
                        bw.write(String.valueOf(d.removeFirst()));
                    } else {
                        bw.write(String.valueOf(d.removeLast()));
                    }
                    if (!d.isEmpty()) {
                        bw.write(",");
                    }
                }
                bw.write("]\n");
            }
        }
        bw.close();
    }
}
