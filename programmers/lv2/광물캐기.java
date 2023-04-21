import java.util.*;

class Solution {
    
    int result = 987654321;
    
    private void dig(int[][] arr,int[] picks,int lastIdx,int mineralIdx,int sum){
        //종료조건 삽갯수 넘어가거나 광물을 다캤을때 종료
        if(lastIdx == 0 || mineralIdx == arr.length){
            result = Math.min(sum,result);
            return;
        }
        
        for(int i=0; i<3; i++){
            if(picks[i]> 0){
                picks[i]--;
                dig(arr,picks,lastIdx-1,mineralIdx+1,sum+arr[mineralIdx][i]);
                picks[i]++;
            }
        }
        
    }
    
    public int solution(int[] picks, String[] minerals) {
        
        int answer = 0;
        int[][] arr = new int[minerals.length/5+1][3];
        int check = 0;
        int num = 0;
        
        for(int i=0; i<minerals.length;i++){
            if(minerals[i].equals("diamond")){
                arr[num][0] += 1;
                arr[num][1] += 5;
                arr[num][2] += 25;
                check++;
            }else if(minerals[i].equals("iron")){
                arr[num][0] += 1;
                arr[num][1] += 1;
                arr[num][2] += 5;
                check++;
            }else{
                arr[num][0] += 1;
                arr[num][1] += 1;
                arr[num][2] += 1;
                check++;
            }
            if(check == 5){
                check = 0;
                num++;
            }
        }
        
        int lastidx = picks[0]+picks[1]+picks[2];
        dig(arr,picks,lastidx,0,0);
        return result;
    }
}