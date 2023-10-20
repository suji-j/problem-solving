import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c1 = 'A';
        char c2 = 'A';

        if (c1 == c2){
            System.out.println("똑같음");
        } else {
            System.out.println("다름");
        }

    }
}
