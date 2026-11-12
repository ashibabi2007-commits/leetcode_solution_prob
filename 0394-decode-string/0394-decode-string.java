class Solution {
    public String decodeString(String s) {
        Stack<Integer> count=new Stack<>();
        Stack<String> String = new Stack<>();
        int num=0;
        String result="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if (c=='['){
                count.push(num);
                String.push(result);
                num=0;
                result="";
            }
            else if(c==']'){
                int z=count.pop();
                String prev=String.pop();
                StringBuilder temp=new StringBuilder(prev);
                for(int j=0;j<z;j++){
                    temp.append(result);
                }
                result=temp.toString();
            }
            else {
                result+=c;
            }
        }
        return result;
    }
}