import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];
        int pLen = p.length();

        // Populate frequencies for p and the first window in s
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window across string s
        for (int i = pLen; i < s.length(); i++) {
            // Add incoming character on the right
            sCount[s.charAt(i) - 'a']++;
            // Remove outgoing character on the left
            sCount[s.charAt(i - pLen) - 'a']--;

            // Compare frequency arrays in O(26) = O(1) time
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}