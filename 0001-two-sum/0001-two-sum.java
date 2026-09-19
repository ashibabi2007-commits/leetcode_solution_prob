class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr=new int[2];
        for (int l=0;l<nums.length;l++){
            for (int r=l+1;r<nums.length;r++){
                if (nums[l]+nums[r]==target){
                    arr[0]=l;
                    arr[1]=r;
                    return arr;
                }
            }
        }  
          return arr;
    }
}