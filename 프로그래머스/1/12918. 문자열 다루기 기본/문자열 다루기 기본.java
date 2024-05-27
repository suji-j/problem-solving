class Solution {
    public boolean solution(String s) {
        char[] arr = s.toCharArray();
        
        if (arr.length == 4 || arr.length == 6) {
            for (int i = 0; i < arr.length; i++) {
                if (!(arr[i] > 47 && arr[i] < 58)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        
        return true;
    }
}