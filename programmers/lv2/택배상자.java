import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> main = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        
        //현재 컨테이너에서 1,2,3....순서로 온다
        //order목록에 맞으면 main에 넣고 아니면 sub 확인
        //있으면 - sub에서 있으면 pop하고 order땡기기  
        //둘다 없으면 현재거는 sub에 push하고 현재거는 땡기기
        //sub맨앞과 현재 컨테이너가 동나면 종료 main에 size를 리턴
        int curr = 1; //현재 컨테이너
        int idx = 0;  //order의 dix
        
        while(true){
            if(idx>=order.length)
                break;
            
            if(curr > order.length+1)
                break;
            
            
            if(order[idx] == curr){
                main.push(curr);
                idx++;
                curr++;
                continue;
            }else{
                if(!sub.empty()){
                    if(sub.peek() == order[idx]){
                        main.push(sub.pop());
                        idx++;
                        continue;
                    }
                }
            }
            
            sub.push(curr);
            curr++;
            
        }
        
       
        //System.out.println(main.size());
        return main.size();
    }
}