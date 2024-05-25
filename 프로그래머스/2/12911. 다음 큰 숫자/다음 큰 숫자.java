class Solution {
    public int solution(int n) {
        int nBinary = Integer.bitCount(n);
        
        while(true) {
            n++;
            int answerBinary = Integer.bitCount(n);
            if (nBinary == answerBinary) {
                break;
            }
        }
        return n;
    }
}