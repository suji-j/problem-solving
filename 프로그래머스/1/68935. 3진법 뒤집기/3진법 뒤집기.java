class Solution {
    public int solution(int n) {
        String three = Integer.toString(n, 3);
        String[] arr = three.split("");
        String reverse = "";
        
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse += arr[i];
        }
        
        return Integer.parseInt(reverse, 3);
    }
}