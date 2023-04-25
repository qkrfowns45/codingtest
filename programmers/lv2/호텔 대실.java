import java.util.*;

class Solution {
    
    public int solution(String[][] book_time) {
        
        int[][] map = new int[book_time.length][2];
        
        for(int i=0; i<book_time.length; i++){
            String[] s = book_time[i][0].split(":");
            String[] e = book_time[i][1].split(":");
            int start = Integer.parseInt(s[0])*100 + Integer.parseInt(s[1]);
            int end = Integer.parseInt(e[0])*100 + Integer.parseInt(e[1])+10;
            if(end % 100 >= 60){
                end += 40;
            }
            map[i][0] = start;
            map[i][1] = end;
        }
        
        Arrays.sort(map,(a,b) -> {
            if(a[0] > b[0])
                return 1;
            else if(a[0] < b[0])
                return -1;
            else{
                if(a[1] > b[1])
                    return 1;
                else
                    return -1;
            }
        });
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i=0; i<map.length; i++){
            if(q.size() == 0){
                q.add(map[i][1]);
                continue;
            }
            
            int size = q.peek();
            if(map[i][0]>= size){
                q.poll();
                q.add(map[i][1]);
            }else{
                q.add(map[i][1]);
            }
        }
        
        return q.size();
    }
}