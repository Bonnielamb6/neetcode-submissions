class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;
        int left = 1;
        for(int pile : piles){
            right = Math.max(right, pile);
        }
        int time = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(eatBananas(mid,piles,h)){
                time = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return time;
    }

    public boolean eatBananas(int speed,int[] piles,int max){
        int time = 0;
        for(int pile : piles){
            time += (pile + speed - 1) / speed;
        }
        if( time <= max){
            return true;
        }else{
            return false;
        }
    }
}
