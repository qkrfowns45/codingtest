import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        Map<Character,Integer> map = new HashMap<>();
        
        int[] answer = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            if(map.containsKey(a)){
                answer[i] = i - map.get(a);
                map.put(a,i);
            }else{
                answer[i] = -1;
                map.put(a,i);
            }
        }
        
        return answer;
    }
}