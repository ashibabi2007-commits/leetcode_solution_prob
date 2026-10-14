class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        int pLen = p.length();
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }
        for (int i = pLen; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - pLen) - 'a']--;
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }
        return result;
    }
}