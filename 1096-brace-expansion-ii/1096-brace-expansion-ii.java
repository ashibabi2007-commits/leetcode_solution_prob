import java.util.*;

class Solution {
    int i;

    public List<String> braceExpansionII(String expression) {
        i = 0;
        Set<String> set = parse(expression);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    Set<String> parse(String s) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {
            Set<String> part = new HashSet<>();

            if (s.charAt(i) == '{') {
                i++;
                part = parse(s);
                i++;
            } else if (s.charAt(i) == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;
                continue;
            } else {
                part.add(String.valueOf(s.charAt(i)));
                i++;
            }

            Set<String> temp = new HashSet<>();

            for (String a : current) {
                for (String b : part) {
                    temp.add(a + b);
                }
            }

            current = temp;
        }

        result.addAll(current);
        return result;
    }
}