class Solution {
    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                arr[k] = ')';
                k++;
            } else if (ch == '{') {
                arr[k] = '}';
                k++;
            } else if (ch == '[') {
                arr[k] = ']';
                k++;
            } else {
                if (k == 0 || arr[k - 1] != ch) {
                    return false;
                }
                k--;
            }
        }

        return k == 0;
    }
}