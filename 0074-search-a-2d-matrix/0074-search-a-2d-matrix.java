class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
        int l=0;
        int right=r*c-1;
        while(l<=right){
           int mid=l+(right-l)/2;
           int i=mid/c;
           int j=mid%c;
           if (matrix[i][j]==target){
            return true;
           }
           else if (matrix[i][j]<target){
            l=mid+1;
           }
           else{
            right=mid-1;
           }
        }return false;
    }
}