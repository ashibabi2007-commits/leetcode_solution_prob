class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", 0, 0, n, result);
        return result;
    }

    public void generate(String s, int open, int close, int n, List<String> result) {

        if (s.length() == 2 * n) {
            result.add(s);
            return;
        }

        if (open < n) {
            generate(s + "(", open + 1, close, n, result);
        }

        if (close < open) {
            generate(s + ")", open, close + 1, n, result);
        }
    }
}