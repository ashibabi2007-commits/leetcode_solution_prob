class Solution {
    public boolean isValid(String s) {
        Stack<Character> list = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                list.push(')');
            }
            else if (ch == '{') {
                list.push('}');
            }
            else if (ch == '[') {
                list.push(']');
            }
            else if (list.isEmpty() || list.pop() != ch) {
                return false;
            }
        }

        return list.isEmpty();

    }
}