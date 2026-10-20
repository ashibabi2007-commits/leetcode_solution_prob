class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null||digits.isEmpty()){
            return result;
        }
        backtrack(digits,0,new StringBuilder(),result);
        return result;
    }
    private static final String[] keypad={
        " "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
    };
    public void backtrack(String digits,int idx,StringBuilder sb,List<String> result){
        if(idx==digits.length()){
            result.add(sb.toString());
            return;
        }
        String letters=keypad[digits.charAt(idx)-'0'];
        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            backtrack(digits,idx+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}