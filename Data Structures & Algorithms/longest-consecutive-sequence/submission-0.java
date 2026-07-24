class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        for(int current : set){
            if(set.contains(current - 1)){
                continue;
            }
            int length = 1;
            int actual = current;
            while(set.contains(actual + 1)){
                length++;
                actual++;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
