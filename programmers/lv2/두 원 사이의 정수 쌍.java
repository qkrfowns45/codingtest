import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        //1.두 점 사이의 정수쌍을 구한다
        for(int i=1; i<r2; i++){
            if(i<r1){
                double large = Math.sqrt(r2*r2 -i*i);
                double small = Math.sqrt(r1*r1 -i*i);
                
                int largeInt = (int)large;
                int smallInt = (int)small;
                
                if(small - smallInt == 0.0){
                    smallInt -= 1;
                }
                answer = answer + largeInt - smallInt;
            }else{
                double large = Math.sqrt((r2*r2) -(i*i));
                int largeInt = (int)large;
                
                answer = answer + largeInt;
            }
            
        }
        
        //2.*4를 한다.
        answer *= 4;
        
        //3.(두 점사이의 거리 +1)*4를 한다.
        answer += (r2-r1 + 1)*4;
        
        return answer;
    }
}