import java.util.*;

class Solution {
    
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int Left = 0;
        int Right = sequence.length;
        int sum = 0;
        
        for(int i = 0, j = 0; i<sequence.length; i++){
            while(j<sequence.length && sum < k){
                sum += sequence[j];
                j++;
            }
            
            if(sum == k){
                int r = j - i -1;
                if((Right - Left) > r){
                    Left = i;
                    Right = j -1;
                }
            }
            
            sum -= sequence[i];
        }
        answer[0] = Left;
        answer[1] = Right;
        
        return answer;
    }
}