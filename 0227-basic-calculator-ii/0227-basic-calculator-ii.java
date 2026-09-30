class Solution {
    public int calculate(String s) {
        Stack<Integer> Stack=new Stack<>();
        int num=0;
        char operation='+';
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if((!Character.isDigit(c) && c!=' ') || (i==s.length()-1)){
                if (operation=='+'){
                    Stack.push(num);
                }
                if (operation=='-'){
                    Stack.push(-num);
                }
                if (operation=='*'){
                    Stack.push(Stack.pop()*num);
                }
                if (operation=='/'){
                    Stack.push(Stack.pop()/num);
                }
                num=0;
                operation=c;
            }
        
        }
        int result=0;
        for(int x:Stack){
            result+=x;
        }
        return result;
    }
}