class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set=new HashSet<>(Arrays.asList(words));
        for(String w:words){
            for(int i=1;i<w.length();i++){
                set.remove(w.substring(i));
            }
        }
        int ans=0;
        for(String w:set){
            ans+=w.length()+1;
        }
        return ans;
    }
}