class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length];
        int k = 0;

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    arr[k] = arr1[j];
                    k++;
                    arr1[j] = -1;
                }
            }
        }

        Arrays.sort(arr1);

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != -1) {
                arr[k] = arr1[i];
                k++;
            }
        }

        return arr;
    }
}