class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arrS = new int[26];
        int[] arrT = new int[26];

        for(int pointer = 0 ; pointer < s.length(); pointer++){
            arrS[s.charAt(pointer) - 'a']++;
            arrT[t.charAt(pointer) - 'a']++;
        }
        for(int pointer = 0; pointer < 26; pointer++){
            if(arrS[pointer] != arrT[pointer]){
                return false;
            }
        }
        return true;
    }
}
