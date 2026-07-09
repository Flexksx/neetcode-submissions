class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seenNumbers = new HashSet<>();

        for (int num : nums) {
            seenNumbers.add(num);
        }

        int maxSequence = 0;
        for (Integer num : seenNumbers) {
            if (seenNumbers.contains(num - 1)) {
                continue;
            }

            int sequenceForNumber = 1;
            int currentNumber = num;
            while (seenNumbers.contains(currentNumber + 1)) {
                currentNumber++;
                sequenceForNumber++;
            }
            if (sequenceForNumber > maxSequence) {
                maxSequence = sequenceForNumber;
            }
        }

        return maxSequence;
    }
}
