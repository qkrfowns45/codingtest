import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long di = (long)d*d;
        
        for(int i=0; i <= d; i+=k){
            long ii = (long)i*i;
            int t = (int)Math.sqrt(di-ii);
            answer += t/k +1;
        }
        return answer;
    }
}