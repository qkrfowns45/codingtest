import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets,(o1,o2) -> {return o1[1]-o2[1];});
        
        int lastchk = -1;
        
        for(int[] target : targets){
            if(lastchk == -1){
                answer++;
                lastchk = target[1] -1;
                continue;
            }
            
            if(lastchk >= target[0] && lastchk <= target[1])
                continue;
            
            answer++;
            lastchk = target[1] -1;
        }
        
        return answer;
    }
}