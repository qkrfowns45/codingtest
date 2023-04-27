import java.util.*;

class Solution {
    
    public class Pos{
        int r;
        int c;
        int level;
        
        Pos(int r,int c, int level){
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }
    
    public int[] solution(String[] maps) {

        int[][] map = new int[maps.length][maps[0].length()];
        boolean[][] visitied = new boolean[maps.length][maps[0].length()];
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        for(int i=0; i<maps.length;i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'X'){
                    map[i][j] = 0;
                }else{
                    map[i][j] = (int)maps[i].charAt(j)-'0';
                }
            }
        }
        String ans = "";
        int cnt = 0;
        for(int i=0; i<map.length;i++){
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] != 0 && !visitied[i][j]){
                    Queue<Pos> q = new LinkedList<>();
                    q.add(new Pos(i,j,map[i][j]));
                    visitied[i][j] = true;
                    int sum = map[i][j];
                    while(!q.isEmpty()){
                        Pos curr = q.poll();
                        int r = curr.r;
                        int c = curr.c;
                        
                        for(int x=0; x<4; x++){
                            int nr = r + dr[x];
                            int nc = c + dc[x];
                            
                            if(nr < 0 || nr >= map.length || nc < 0 || nc>=map[i].length){
                                continue;
                            }
                            
                            if(!visitied[nr][nc] && map[nr][nc] != 0){
                                sum += map[nr][nc];
                                q.add(new Pos(nr,nc,sum));
                                visitied[nr][nc] = true;
                            }
                        }
                    }
                    cnt++;
                    ans += sum+" ";
                }
            }
        }
        
        int[] answer = {};
        
        if(cnt == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        else{
            String[] arr = ans.split(" ");
            answer = new int[cnt];
            
            for(int i = 0; i<cnt; i++){
                answer[i] = Integer.parseInt(arr[i]);
            }
            Arrays.sort(answer);
            return answer;
        }
    }
}