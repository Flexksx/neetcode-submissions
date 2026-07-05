class Solution {
    public int[] productExceptSelf(int[] nums) {
        boolean zeroSeenOnce = false;
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (!zeroSeenOnce) {
                    zeroSeenOnce = true;
                } else {
                    return new int[nums.length];
                }
            }
        }

        
        if (zeroSeenOnce) {
            return handleSingleZero(nums);
        }
        return handleGeneralCase(nums);
    }

    private int[] handleGeneralCase(int[] nums) {
        int totalProduct = 1;
        for (int num : nums) {
            totalProduct *= num;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = totalProduct / nums[i];
        }
        return result;
    }

    private int[] handleSingleZero(int[] nums) {
        boolean[] indicesHaveZero = new boolean[nums.length];
        int totalProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                indicesHaveZero[i] = true;
            } else {
                indicesHaveZero[i] = false;
                totalProduct *= nums[i];
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            if (indicesHaveZero[i]) {
                result[i] = totalProduct;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    private int countZeros(int nums[]) {
        int counter = 0;
        for (int num : nums) {
            if (num == 0) {
                counter++;
            }
        }
        return counter;
    }
}
