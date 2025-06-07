import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int kingY, kingX, pawnY, pawnX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] location = new String[2];
        location[0] = st.nextToken();
        location[1] = st.nextToken();
        
        int t = Integer.parseInt(st.nextToken());

        char[] row = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};

        for (int i = 0; i < 2; i++) {
            char[] cur = location[i].toCharArray();
            for (int j = 0; j < 8; j++) {
                if (cur[0] == row[j]) {
                    if (i == 0) {
                        kingY = 8 - (cur[1] - '0');
                        kingX = j;

                    } else {
                        pawnY = 8 - (cur[1] - '0');
                        pawnX = j;

                    }
                    break;
                }
            }
        }

        for (int tc = 0; tc < t; tc++) {
            String order = br.readLine();
            move(order);
        }

        bw.write(row[kingX] + "" + (8 - kingY) + "\n");
        bw.write(row[pawnX] + "" + (8 - pawnY));
        bw.close();
    }

    static void move(String order) {
        if (order.equals("R")) {
            if (isValid(kingY, kingX + 1)) {
                if (kingX + 1 == pawnX && kingY == pawnY) {
                    if (isValid(pawnY, pawnX + 1)) {
                        pawnX += 1;
                        kingX += 1;
                    }
                } else {
                    kingX += 1;
                }
            }
        } else if (order.equals("L")) {
            if (isValid(kingY, kingX - 1)) {
                if (kingX - 1 == pawnX && kingY == pawnY) {
                    if (isValid(pawnY, pawnX - 1)) {
                        pawnX -= 1;
                        kingX -= 1;
                    }
                } else {
                    kingX -= 1;
                }
            }
        } else if (order.equals("B")) {
            if (isValid(kingY + 1, kingX)) {
                if (kingY + 1 == pawnY && kingX == pawnX) {
                    if (isValid(pawnY + 1, pawnX)) {
                        pawnY += 1;
                        kingY += 1;
                    }
                } else {
                    kingY += 1;
                }
            }
        } else if (order.equals("T")) {
            if (isValid(kingY - 1, kingX)) {
                if (kingY - 1 == pawnY && kingX == pawnX) {
                    if (isValid(pawnY - 1, pawnX)) {
                        pawnY -= 1;
                        kingY -= 1;
                    }
                } else {
                    kingY -= 1;
                }
            }
        } else if (order.equals("RT")) {
            if (isValid(kingY - 1, kingX + 1)) {
                if (kingY - 1 == pawnY && kingX + 1 == pawnX) {
                    if (isValid(pawnY - 1, pawnX + 1)) {
                        pawnY -= 1;
                        kingY -= 1;

                        pawnX += 1;
                        kingX += 1;
                    }
                } else {
                    kingY -= 1;
                    kingX += 1;
                }
            }
        } else if (order.equals("LT")) {
            if (isValid(kingY - 1, kingX - 1)) {
                if (kingY - 1 == pawnY && kingX - 1 == pawnX) {
                    if (isValid(pawnY - 1, pawnX - 1)) {
                        pawnY -= 1;
                        kingY -= 1;

                        pawnX -= 1;
                        kingX -= 1;
                    }
                } else {
                    kingY -= 1;
                    kingX -= 1;
                }
            }
        } else if (order.equals("RB")) {
            if (isValid(kingY + 1, kingX + 1)) {
                if (kingY + 1 == pawnY && kingX + 1 == pawnX) {
                    if (isValid(pawnY + 1, pawnX + 1)) {
                        pawnY += 1;
                        kingY += 1;

                        pawnX += 1;
                        kingX += 1;
                    }
                } else {
                    kingY += 1;
                    kingX += 1;
                }
            }
        } else {
            if (isValid(kingY + 1, kingX - 1)) {
                if (kingY + 1 == pawnY && kingX - 1 == pawnX) {
                    if (isValid(pawnY + 1, pawnX - 1)) {
                        pawnY += 1;
                        kingY += 1;

                        pawnX -= 1;
                        kingX -= 1;
                    }
                } else {
                    kingY += 1;
                    kingX -= 1;
                }
            }
        }
    }

    static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < 8 && x < 8;
    }
}
