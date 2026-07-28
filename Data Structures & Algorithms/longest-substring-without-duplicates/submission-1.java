class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> string = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right = 0; right < s.length(); right++){
            if(string.contains(s.charAt(right))){
                max = Math.max(max, right - left);
                while(string.contains(s.charAt(right))){
                    string.remove(s.charAt(left));
                    left++;
                }
            }
            string.add(s.charAt(right));
        }
        max = Math.max(max, s.length() - left);
        return max;
    }
}
