class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String num = String.valueOf(storey);
        char[] arr = num.toCharArray();
        int idx = num.length()-1;
        int check = storey;
        
        while(check != 0){
            int curr = arr[idx] -'0';
            if(idx -1 >=0){
                if(curr > 5){
                    answer += (10-curr);
                    arr[idx] = '0';
                    arr[idx-1] +=1;
                }else if(curr <5){
                    answer += curr;
                    arr[idx] = '0';
                }else{
                    if(arr[idx-1]-'0' >= 5){
                        answer += (10-curr);
                        arr[idx] = '0';
                        arr[idx-1] +=1;
                    }else{
                        answer += curr;
                        arr[idx] = '0';
                    }
                }
                idx--;
            }else{
                if(curr > 5){
                    answer += (10 - curr)+1;
                }else if(curr <= 5){
                    answer += curr;
                }
                check = 0;
            }
        }
        
        
        return answer;
    }
}