class Solution {
    static boolean[] visit;
    static int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        visit = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int i, int[][] computers) {
        visit[i] = true;
        
        for (int j = 0; j < computers[i].length; j++) {
            if (!visit[j] && computers[i][j] == 1) dfs(j, computers);
        }
    }
}