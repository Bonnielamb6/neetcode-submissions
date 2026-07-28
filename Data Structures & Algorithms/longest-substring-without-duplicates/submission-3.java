class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> string = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            while (string.contains(s.charAt(right))) {
                string.remove(s.charAt(left));
                left++;
            }
            string.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
