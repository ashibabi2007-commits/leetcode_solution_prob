class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int k=0;
        int l=1;
        int r=nums.length-1;
        int[] arr=new int[nums.length];
        for (int i=0;i<=r;i++){
            if (nums[i]%2==0){
                arr[k]=nums[i];
                k=k+2;
            }
            else{
                arr[l]=nums[i];
                l=l+2;
            }
        }
        return arr;
    }
}