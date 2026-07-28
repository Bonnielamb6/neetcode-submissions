class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqs = new int[26];
        int maxFreq = 0;
        int maxLength = 0;
        int left = 0;
        for(int pointer = 0; pointer < s.length();pointer++){
            int index = s.charAt(pointer) - 'A';
            freqs[index]++;
            maxFreq = Math.max(maxFreq,freqs[index]);
            while((pointer - left + 1) - maxFreq > k){
                freqs[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, pointer - left + 1);
        }
        return maxLength;
    }
}
