import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<tangerine.length; i++){
            if(map.containsKey(tangerine[i])){
                map.put(tangerine[i],map.get(tangerine[i])+1);
            }else{
                map.put(tangerine[i],1);
            }
        }
        
        List<Integer> listKeySet = new ArrayList<>(map.keySet());
        
        Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        
        for(Integer key : listKeySet) {
            if(k <= 0)
                break;
            k -= map.get(key);
            answer++;
		}
        
        return answer;
    }
}