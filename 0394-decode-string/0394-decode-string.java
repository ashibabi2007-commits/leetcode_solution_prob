class Solution {
    public String decodeString(String s) {
        Stack<Integer> count=new Stack<>();
        Stack<String> String = new Stack<>();
        int num=0;
        String current="";
        for (char c:s.toCharArray()){
            if (Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if (c=='['){
                count.push(num);
                String.push(current);
                num=0;
                current="";
            }
            else if(c==']'){
                int z=count.pop();
                String prev=String.pop();
                StringBuilder temp=new StringBuilder(prev);
                for(int i=0;i<z;i++){
                    temp.append(current);
                }
                current=temp.toString();
            }
            else {
                current+=c;
            }
        }
        return current;
    }
}