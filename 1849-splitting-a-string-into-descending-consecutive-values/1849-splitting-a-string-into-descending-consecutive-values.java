class Solution {
    public boolean splitString(String s) {
        int n = s.length();
        long firstVal = 0;

        for (int i = 0; i < n - 1; i++) {
            firstVal = firstVal * 10 + (s.charAt(i) - '0');
            if (dfs(s, i + 1, firstVal)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(String s, int index, long prevVal) {
        if (index == s.length()) {
            return true;
        }

        long currVal = 0;
        for (int i = index; i < s.length(); i++) {
            currVal = currVal * 10 + (s.charAt(i) - '0');

            if (currVal == prevVal - 1) {
                if (dfs(s, i + 1, currVal)) {
                    return true;
                }
            } else if (currVal >= prevVal) {
                break; // Early pruning
            }
        }
        return false;
    }
}