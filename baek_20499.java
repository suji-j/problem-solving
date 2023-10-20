import java.io.*;

public class baek_20499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String[] arr = str.split("/");

        int K = Integer.parseInt(arr[0]);
        int D = Integer.parseInt(arr[1]);
        int A = Integer.parseInt(arr[2]);

        if ((K + A < D) || (D == 0)){
            System.out.println("hasu");
        } else {
            System.out.println("gosu");
        }
    }
}
