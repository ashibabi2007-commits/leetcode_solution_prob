class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();

        int left = 0;
        int right = 0;

        while (left < nums1.length && right < nums2.length) {

            if (nums1[left] == nums2[right]) {
                list.add(nums1[left]);
                left++;
                right++;
            }
            else if (nums1[left] < nums2[right]) {
                left++;
            }
            else {
                right++;
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}