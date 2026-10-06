class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer,Integer> map=new HashMap<>();
        for(int i:nums){ 
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Step 3: Keep only the top k frequent elements in the heap
        for (int key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll(); // Remove element with smallest frequency
            }
        }

        // Step 4: Extract elements from heap into array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}