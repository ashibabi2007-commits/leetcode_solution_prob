class Solution {
    public String reverseParentheses(String s) {
        StringBuilder str = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                int i = str.length() - 1;

                while (str.charAt(i) != '(') {
                    i--;
                }

                String temp = str.substring(i + 1);
                str.delete(i, str.length());
                str.append(new StringBuilder(temp).reverse());
            } 
            else {
                str.append(c);
            }
        }

        return str.toString();
    }
}