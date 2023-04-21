import java.util.*;

class Solution {
    
    public boolean[][] visited;
    public int[][] map;
    public int[] dx = {-1,0,1,0};
    public int[] dy = {0,-1,0,1};
    
    class Pos {
        int x, y, cnt;
        Pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public Pos getPos(int idx,Pos now){
        int x = now.x;
        int y = now.y;
        int ix = dx[idx];
        int iy = dy[idx];
        while(x + ix >= 0 && y + iy >= 0 && x+ ix<map.length && y+iy<map[0].length && map[x + ix][y + iy] != 1){
            x += ix;
            y += iy;
        }
        return new Pos(x,y,now.cnt+1);
    }
    
    public int bfs(Pos start,Pos target){
        Queue<Pos> q = new LinkedList<>();
        visited[start.x][start.y] = true;
        q.add(start);
        while(!q.isEmpty()){
            Pos curr = q.poll();
            int x = curr.x;
            int y = curr.y;
            int cnt = curr.cnt;
            
            if(x == target.x && y == target.y)
                return cnt;
            for(int i=0; i<4; i++){
                Pos next = getPos(i,curr);
                if(!visited[next.x][next.y]){
                    visited[next.x][next.y] = true;
                    q.add(next);
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] board) {
        
        int answer = 0;
        map = new int[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        Pos start  = null;
        Pos target = null;
        
        for(int i=0; i<board.length; i++){
            for(int j=0;j<board[i].length();j++){
                if(board[i].charAt(j)=='.')
                    map[i][j] = 0;
                else if(board[i].charAt(j) == 'D')
                    map[i][j] = 1;
                else if(board[i].charAt(j) == 'G'){
                    target = new Pos(i,j,0);
                    map[i][j] = 2;
                }else{
                    start = new Pos(i,j,0);
                    map[i][j] = 3;
                }
            }
        }
        
        answer = bfs(start,target);
        
        return answer;
    }
}