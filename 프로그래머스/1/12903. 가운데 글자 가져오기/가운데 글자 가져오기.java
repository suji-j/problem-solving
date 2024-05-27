class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        
        if (arr.length % 2 == 0) {
            sb.append(arr[(arr.length / 2) - 1]).append(arr[arr.length / 2]);
        } else {
            sb.append(arr[arr.length / 2]);
        }
        
        return sb.toString();
    }
}