class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int max = 0, min = 0;
        
        for (int i : lottos) {
            if (i == 0) {
                max++;
            }
            
            for (int j : win_nums) {
                if (i == j) {
                    max++;
                    min++;
                }
            }
        }
        
        answer[0] = rank[max];
        answer[1] = rank[min];
        
        return answer;
    }
}