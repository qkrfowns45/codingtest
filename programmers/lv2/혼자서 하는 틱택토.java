class Solution {
    
    public int checkmap2(int[][] map){
        int check = 0;
        if(map[0][0] == 2 && map[0][1] == 2 && map[0][2] == 2)
            check++;
        if(map[1][0] == 2 && map[1][1] == 2 && map[1][2] == 2)
            check++;
        if(map[2][0] == 2 && map[2][1] == 2 && map[2][2] == 2)
            check++;
        if(map[0][0] == 2 && map[1][0] == 2 && map[2][0] == 2)
            check++;
        if(map[0][1] == 2 && map[1][1] == 2 && map[2][1] == 2)
            check++;
        if(map[0][2] == 2 && map[1][2] == 2 && map[2][2] == 2)
            check++;
        if(map[0][0] == 2 && map[1][1] == 2 && map[2][2] == 2)
            check++;
        if(map[2][0] == 2 && map[1][1] == 2 && map[0][2] == 2)
            check++;
        return check;
    }
    
    public int checkmap(int[][] map){
        int check = 0;
        if(map[0][0] == 1 && map[0][1] == 1 && map[0][2] == 1)
            check++;
        if(map[1][0] == 1 && map[1][1] == 1 && map[1][2] == 1)
            check++;
        if(map[2][0] == 1 && map[2][1] == 1 && map[2][2] == 1)
            check++;
        if(map[0][0] == 1 && map[1][0] == 1 && map[2][0] == 1)
            check++;
        if(map[0][1] == 1 && map[1][1] == 1 && map[2][1] == 1)
            check++;
        if(map[0][2] == 1 && map[1][2] == 1 && map[2][2] == 1)
            check++;
        if(map[0][0] == 1 && map[1][1] == 1 && map[2][2] == 1)
            check++;
        if(map[2][0] == 1 && map[1][1] == 1 && map[0][2] == 1)
            check++;
        return check;
    }
    
    public int check(int[][] map, int numO, int numX){
        
        int bingoO = checkmap(map);
        int bingoX = checkmap2(map);;
        
        if(numX>numO || numO > numX+1)
            return 0;
        
        if(bingoX>0 && bingoO>0)
            return 0;
        
        if(bingoO > 0) {
            if(numO == numX)
                return 0;
        }
        if(bingoX > 0) {
            if(numO > numX)
                return 0;
        }
        
        return 1;
    }
    
    public int solution(String[] board) {
        int answer = -1;
        int numO = 0;
        int numX = 0;
        
        int[][] map = new int[3][3];
        for(int i=0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(board[i].charAt(j) == 'O'){
                    map[i][j] = 1;
                    numO++;
                }else if(board[i].charAt(j)=='X'){
                    map[i][j] = 2;
                    numX++;
                }
            }
        }
        
        answer = check(map,numO,numX);
        
        return answer;
    }
}