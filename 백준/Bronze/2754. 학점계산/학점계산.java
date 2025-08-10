import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        String[] arr = str.split("");
        if (arr[0].equals("A")) {
            if (arr[1].equals("+")) bw.write("4.3");
            else if (arr[1].equals("0")) bw.write("4.0");
            else bw.write("3.7");
        } else if (arr[0].equals("B")) {
            if (arr[1].equals("+")) bw.write("3.3");
            else if (arr[1].equals("0")) bw.write("3.0");
            else bw.write("2.7");
        } else if (arr[0].equals("C")) {
            if (arr[1].equals("+")) bw.write("2.3");
            else if (arr[1].equals("0")) bw.write("2.0");
            else bw.write("1.7");
        } else if (arr[0].equals("D")) {
            if (arr[1].equals("+")) bw.write("1.3");
            else if (arr[1].equals("0")) bw.write("1.0");
            else bw.write("0.7");
        } else {
            bw.write("0.0");
        }

        bw.close();
    }
}
