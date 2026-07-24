class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[]suffix = new int[nums.length];
        int[]prefix = new int[nums.length];
        int[]result = new int[nums.length];
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for(int pointer = 1 ; pointer < nums.length; pointer++){
            prefix[pointer] = prefix[pointer - 1] * nums[pointer];
            suffix[nums.length - 1 - pointer] = suffix[nums.length - pointer] * nums[nums.length - 1 -pointer];
        }
        result[0] = suffix[1];
        result[nums.length - 1] = prefix[nums.length -2];
        for(int pointer = 1 ; pointer < nums.length - 1 ; pointer++){
            result[pointer] = prefix[pointer - 1] * suffix[pointer + 1];
        }
        return result;
    }
}  
