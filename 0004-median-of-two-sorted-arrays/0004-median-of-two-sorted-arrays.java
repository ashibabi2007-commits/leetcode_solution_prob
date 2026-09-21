class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m=nums1.length;
        int n=nums2.length;
        int[] arr=new int[m+n];
        for(int i=0;i<m;i++){
            arr[i]=nums1[i];
        }
        for(int i=0;i<nums2.length;i++){
            arr[m+i]=nums2[i];
        }
        Arrays.sort(arr);
        int mid=0;
        int mid2=0;
        if(arr.length%2==0){
            mid=arr[(arr.length/2)-1];
            mid2=arr[(arr.length/2)];
            return (mid+mid2)/2.0;
        }
        else{
            mid=arr[arr.length/2];
            return (mid);
        }
    }

}