class Solution {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] prefixProducts = new int[size];
        int[] suffixProducts = new int[size];
        int[] result = new int[size];

        prefixProducts[0] = 1;
        suffixProducts[size - 1] = 1;

        for (int i = 1; i < size; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }
        for (int i = size - 2; i >= 0; i--) {
            suffixProducts[i] = suffixProducts[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < size; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }

        return result;
    }
}
