class Solution {
    public String decodeString(String s) {
        Stack<Integer> count=new Stack<>();
        Stack<String> nimu=new Stack<>();
        int num=0;
        String result="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if(c=='['){
                count.push(num);
                nimu.push(result);
                result="";
                num=0;
            }
            else if(c==']'){
                int z=count.pop();
                String prev=nimu.pop();
                String temp=prev;
                for(int j=0;j<z;j++){
                    temp+=result;
                }
                result=temp;
            }
            else{
                result+=c;
            }
        }
        return result;
    }
}