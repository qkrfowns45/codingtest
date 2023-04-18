import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        int tyear = Integer.parseInt(today.substring(0,4));
        int tmonth = Integer.parseInt(today.substring(5,7));
        int tday = Integer.parseInt(today.substring(8,10));
        int tcount = (tyear*12*28) + (tmonth*28) + tday;
        
        int[] arr = new int[privacies.length];
        
        int cnt = 0;
        String br = "";
        for(String str : terms){
            String[] term = str.split(" ");
            for(int i=0; i<privacies.length; i++){
                String[] pri = privacies[i].split(" ");
                if(pri[1].equals(term[0])){
                    int year = Integer.parseInt(pri[0].substring(0,4));
                    int month = Integer.parseInt(pri[0].substring(5,7)) + Integer.parseInt(term[1]);
                    int day = Integer.parseInt(pri[0].substring(8,10));
                    
                    int ncount = (year*12*28) + (month*28) + day -1;
                    if(tcount > ncount){
                        cnt++;
                        arr[i] = i+1;
                    }
                }
            }
        }
        
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>0){
                answer[idx] = arr[i];
                idx++;
            }
        }
        return answer;
    }
}