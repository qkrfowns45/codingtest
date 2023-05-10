import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        map1.put(topping[0],1);
        for(int i=1; i<topping.length; i++){
            if(map2.containsKey(topping[i])){
                map2.put(topping[i],map2.get(topping[i])+1);
            }else{
                map2.put(topping[i],1);
            }
        }
        if(map1.size() == map2.size())
            answer++;
        
        for(int i=1; i<topping.length; i++){
            
            if(map1.containsKey(topping[i])){
                map1.put(topping[i],map1.get(topping[i])+1);
            }else{
                map1.put(topping[i],1);
            }
            
            map2.put(topping[i],map2.get(topping[i])-1);
            if(map2.get(topping[i]) == 0)
                map2.remove(topping[i]);
            
            if(map1.size() == map2.size())
                answer++;
        }
        
        return answer;
    }
}