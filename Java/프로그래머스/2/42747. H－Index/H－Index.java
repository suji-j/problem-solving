import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int[] h = new int[citations.length];
        int hIndex = 0;
        
        for (int i = 0; i < citations.length; i++) {
            int overQuote = citations[i];
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= overQuote) {
                    hIndex++;
                }
            }  
            
            if (overQuote > hIndex)h[i] = hIndex; 
            else h[i] = overQuote;
            
            hIndex = 0;
        }
        Arrays.sort(h);
        return h[h.length-1];
    }
}