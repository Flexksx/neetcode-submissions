class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean zeroSeenOnce = false;

        int totalProductExceptZeroes = 1;
        int[] result = new int[nums.length];
        boolean[] indexHasZero = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                indexHasZero[i] = true;
                if (!zeroSeenOnce) {
                    zeroSeenOnce = true;
                } else {
                    return new int[nums.length];
                }
            } else {
                totalProductExceptZeroes *= nums[i];
            }
        }

        if (zeroSeenOnce) {
            for (int i = 0; i < result.length; i++) {
                if (indexHasZero[i]) {
                    result[i]=totalProductExceptZeroes;
                }
            }
            return result;
        }

        for (int i=0;i<nums.length;i++){
            result[i] = totalProductExceptZeroes/nums[i];
        }
        return result;
    }

}
