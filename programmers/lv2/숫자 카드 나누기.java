import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int minA = arrayA[0];
        int minB = arrayB[0];
        int i =2;
        while(true){
            boolean A = false;
            boolean B = false;
            if(i>minA && i>minB){
                break;
            }
            
            //철수카드가 다 나눌수있고 영희가 못나눌때
            if(minA % i == 0 && minB % i != 0){
                A = true;
                for(int j=1; j<arrayA.length; j++){
                    if(arrayA[j]%i != 0){
                        A = false;
                        break;
                    }
                }
                if(A){
                  B = true;
                  for(int j=1; j<arrayB.length; j++){
                    if(arrayB[j]%i == 0){
                        B = false;
                        break;
                    }
                   }  
                }
            }
            if(A && B){
                answer = i;
            }
            A = false;
            B = false;
            
            //철수카드가 다 나눌수없고 영희가 나눌때
            if(minA % i != 0 && minB % i == 0){
                A = true;
                for(int j=1; j<arrayA.length; j++){
                    if(arrayA[j]%i == 0){
                        A = false;
                        break;
                    }
                }
                if(A){
                  B = true;
                  for(int j=1; j<arrayB.length; j++){
                    if(arrayB[j]%i != 0){
                        B = false;
                        break;
                    }
                   }  
                }
            }
            if(A && B){
                answer = i;
            }
            
            i++;
        }
        
        return answer;
    }
}