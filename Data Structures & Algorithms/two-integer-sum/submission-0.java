class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int current = 0 ; current < nums.length; current++){
            if(map.containsKey(target - nums[current])){
                return new int[]{map.get(target-nums[current]),current};
            }
            map.put(nums[current],current);
        }
        return new int[]{0,0};
    }
}
