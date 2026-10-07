class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.add(s);
        set.add(s);
        boolean found = false;
        while (!q.isEmpty()) {
            String str = q.poll();
            if (valid(str)) {
                ans.add(str);
                found = true;
            }
            if (found)
                continue;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')')
                    continue;
                String next = str.substring(0, i) + str.substring(i + 1);
                if (!set.contains(next)) {
                    set.add(next);
                    q.add(next);
                }
            }
        }
        return ans;
    }
    public boolean valid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')') {
                count--;
                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }
}