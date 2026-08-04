class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1count = new int[26];
        int[] window = new int[26];

        if(s1.length() > s2.length()){
            return false;
        }

        for(int position = 0 ; position < s1.length(); position++){
            s1count[s1.charAt(position) - 'a']++;
            window[s2.charAt(position) - 'a']++;
        }
        if(Arrays.equals(s1count,window)){
            return true;
        }
        for(int position = s1.length(); position < s2.length(); position++){
            window[s2.charAt(position) - 'a']++;
            window[s2.charAt(position - s1.length()) - 'a']--;
            if(Arrays.equals(window, s1count)){
                return true;
            }
        }
        return false;
    }
}
