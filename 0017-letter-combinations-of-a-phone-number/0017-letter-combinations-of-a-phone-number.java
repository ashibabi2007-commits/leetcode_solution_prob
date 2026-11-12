class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits==null || digits.isEmpty()){
            return result;
        }
        backtrack(digits,0,new StringBuilder(),result);
        return result;
    }
    private static String[] keypad={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void backtrack(String digits,int index, StringBuilder sb, List<String> result){
        if (index==digits.length()){
            result.add(sb.toString());
            return;
        }
        String letter=keypad[digits.charAt(index)-'0'];
        for(int i=0;i<letter.length();i++){
            sb.append(letter.charAt(i));
            backtrack(digits,index+1,sb,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}