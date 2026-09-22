class Solution {
    public boolean isValid(String s) {
        char[] arr = new char[s.length()];
        int k = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                arr[k++] = ')';
            } 
            else if (c == '{') {
                arr[k++] = '}';
            } 
            else if (c == '[') {
                arr[k++] = ']';
            } 
            else {
                if (k == 0 || arr[--k] != c) {
                    return false;
                }
            }
        }

        return k == 0;
    }
}