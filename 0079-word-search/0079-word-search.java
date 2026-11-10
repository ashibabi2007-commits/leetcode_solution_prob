class Solution {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        for(int r=0;r<row;r++){
            for(int c=0;c<col;c++){
                if(dfs(board,word,r,c,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word,int r,int c,int index) {
        if (index==word.length()){
            return true;
        }
        if (r<0 || c<0 || r>=board.length ||c>=board[0].length || board[r][c]!=word.charAt(index)){
            return false;
        }
        char temp=board[r][c];
        board[r][c]='#';
        boolean found=dfs(board,word,r+1,c,index+1) ||
                      dfs(board,word,r-1,c,index+1) ||
                      dfs(board,word,r,c+1,index+1) ||
                      dfs(board,word,r,c-1,index+1) ;
        board[r][c]=temp;
        return found;
    }
}