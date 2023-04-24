import java.util.*;

class Solution {
    public int[][] map;
    public int[][] map2;
    public int m;
    public int n;
    public boolean[][] visitied;
    public boolean[][] visitied2;
    public int[] dr = {-1,1,0,0};
    public int[] dc = {0,0,1,-1};
    
    Pos findL;
    
    public class Pos{
        int r;
        int c;
        int level;
        Pos(int r, int c, int level){
            this.r = r;
            this.c = c;
            this.level = level;
        }
    }
    
    public int find(Pos start,Pos target){
        Queue<Pos> q = new LinkedList<>();
        q.add(start);
        visitied[start.r][start.c] = true;
        
        while(!q.isEmpty()){
            Pos curr = q.poll();
            int nowr = curr.r;
            int nowc = curr.c;
            for(int i=0; i<4; i++){
                int nextr = nowr + dr[i];
                int nextc = nowc + dc[i];
                
                if(nextr >= m || nextr < 0 || nextc >= n || nextc < 0){
                    continue;
                }
                
                if(!visitied[nextr][nextc] && map[nextr][nextc] != 3){
                    q.add(new Pos(nextr,nextc, curr.level+1));
                    visitied[nextr][nextc] = true;
                }
                
                if(nextr == target.r && nextc == target.c){
                    return curr.level+1;
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        m = maps.length;
        n = maps[0].length();
        map = new int[maps.length][maps[0].length()];
        visitied = new boolean[maps.length][maps[0].length()];
        Pos start = new Pos(0,0,0);
        Pos findL = new Pos(0,0,0);
        Pos target = new Pos(0,0,0);
        
        for(int i=0; i<maps.length; i++){
            for(int j =0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    start = new Pos(i,j,0);
                    map[i][j] = 1;
                }else if(maps[i].charAt(j) == 'O'){
                    map[i][j] = 0;
                }else if(maps[i].charAt(j) == 'L'){
                    map[i][j] = 2;
                    findL = new Pos(i,j,0);
                }else if(maps[i].charAt(j) == 'X'){
                    map[i][j] = 3;
                }else if(maps[i].charAt(j) == 'E'){
                    map[i][j] = 4;
                    target = new Pos(i,j,0);
                }
            }
        }
        answer = find(start,findL);
        if(answer != -1){
            visitied = new boolean[maps.length][maps[0].length()];
            int tmp = find(findL,target);
            if(tmp == -1)
                return -1;
            answer += tmp;
        }
            
        return answer;
    }
}