import java.util.*;

class Solution {
    
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        //우선순위 큐를 만들어서 적을 해치울때마다 병사가 -되면 해치웠던 적중 가장 큰 값을 제거 병사는 원래대로
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        //마지막에 나왔을때 다 처리하면 라운드여야함
        answer = enemy.length;
        for(int i=0; i<enemy.length; i++){
            n -= enemy[i];
            q.add(enemy[i]);
            if(n < 0){
                if(k > 0 && !q.isEmpty()){
                    int x = q.poll();
                    k--;
                    n += x;
                }else{
                    answer = i;
                    break;
                }
            }
        }
        
        return answer;
    }
}