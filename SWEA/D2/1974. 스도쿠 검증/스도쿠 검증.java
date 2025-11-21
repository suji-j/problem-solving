import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            arr = new int[9][9];

            for (int y = 0; y < 9; y++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x < 9; x++) {
                    arr[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            boolean isValid = true;
            // 가로
            for (int i = 0; i < 9; i++) {
                if (!row(arr, i)) {
                    isValid = false;
                    break;
                }
            }

            // 세로
            for (int i = 0; i < 9; i++) {
                if (!column(arr, i)) {
                    isValid = false;
                    break;
                }
            }

            // 3*3
            for (int y = 0; y < 9; y += 3) {
                for (int x = 0; x < 9; x += 3) {
                    if (!block(arr, y, x)) {
                        isValid = false;
                        break;
                    }
                }
            }

            bw.write("#" + tc + " ");
            bw.write(isValid ? "1\n" : "0\n");
        }
        bw.close();
    }

    static boolean row(int[][] arr, int y) {
        number = new int[10];

        for (int x = 0; x < 9; x++) {
            number[arr[y][x]] += 1;
        }

        if (sudoku(number)) {
            return true;
        }
        return false;
    }

    static boolean column(int[][] arr, int x) {
        number = new int[10];

        for (int y = 0; y < 9; y++) {
            number[arr[y][x]] += 1;
        }

        if (sudoku(number)) {
            return true;
        }
        return false;
    }

    static boolean block(int[][] arr, int y, int x) {
        number = new int[10];

        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                number[arr[i][j]] += 1;
            }
        }

        if (sudoku(number)) {
            return true;
        }
        return false;
    }

    static boolean sudoku(int[] number) {
        for (int i = 1; i <= 9; i++) {
            if (number[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
