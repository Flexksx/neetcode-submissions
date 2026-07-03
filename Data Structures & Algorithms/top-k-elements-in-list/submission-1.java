class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(number);
        }

        int[] result = new int[k];
        int currentResultIndex = 0;

        for (int freq = buckets.length - 1; freq > 0 && currentResultIndex < k; freq--) {
            if (buckets[freq] == null) {
                continue;
            }

            for (int number : buckets[freq]) {
                result[currentResultIndex++] = number;

                if (currentResultIndex == k) {
                    return result;
                }
            }
        }

        return result;
    }
}