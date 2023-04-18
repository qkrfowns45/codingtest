import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        for(int i=0; i<s.length(); i++){
            char a = s.charAt(i);
            int count =1;
            while(count <= index){
                a++;    
                if(a > 'z')
                    a -= 26;
                if(skip.contains(a+""))
                    continue;
                else
                    count++;
            }
            answer += a;
        }
        return answer;
    }
}