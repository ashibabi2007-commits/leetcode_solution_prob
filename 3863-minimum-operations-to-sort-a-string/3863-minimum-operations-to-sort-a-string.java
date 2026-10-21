class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean sorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] > chars[i + 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        if (n == 2) return -1;
        
        int minC = 0, maxC = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] < chars[minC]) minC = i;
            if (chars[i] >= chars[maxC]) maxC = i;
        }
        
        if (minC == 0 || maxC == n - 1) return 1;
        if (minC == n - 1 && maxC == 0) return 3;
        return 2;
    }
}