class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {

                if (operation == '+') {
                    stack.push(num);
                } else if (operation == '-') {
                    stack.push(-num);
                } else if (operation == '*') {
                    stack.push(stack.pop() * num);
                } else if (operation == '/') {
                    stack.push(stack.pop() / num);
                }

                operation = c;
                num = 0;
            }
        }

        int result = 0;

        for (int x : stack) {
            result += x;
        }

        return result;
    }
}