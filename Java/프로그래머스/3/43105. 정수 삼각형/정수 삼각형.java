import java.lang.Math;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
        int[][] score = new int[triangle.length][triangle.length];

        score[0][0] = 0;
        if (triangle.length > 1) {
            score[1][0] = triangle[0][0];
            score[1][1] = triangle[0][0];

            for (int i = 2; i < triangle.length; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if (j == 0) {
                        score[i][j] = score[i - 1][j] + triangle[i - 1][j];
                    } else if (j == triangle[i].length - 1) {
                        score[i][j] = score[i - 1][j - 1] + triangle[i - 1][j - 1];
                    } else {
                        score[i][j] = Math.max(score[i - 1][j - 1] + triangle[i - 1][j - 1], score[i - 1][j] + triangle[i - 1][j]);
                    }
                }
            }

            for (int i = 0; i < triangle[length - 1].length; i++) {
                int num = score[length - 1][i] + triangle[length - 1][i];
                if (answer < num) answer = num;
            }
        }

        return answer;
    }
}