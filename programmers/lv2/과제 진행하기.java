import java.util.*;

class Solution {
    
    static class Node{
        int idx;
        int start;
        int remain;
        
        public Node(int idx, int start, int remain){
            this.idx = idx;
            this.start = start;
            this.remain = remain;
        }
    }
    
    public List<String> solution(String[][] plans) {
        List<String> ans = new ArrayList<>();
        
        Node[] node = new Node[plans.length];
        for(int i=0; i<plans.length; i++){
            String[] arr = plans[i][1].split(":");
            node[i] = new Node(i,Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]),Integer.parseInt(plans[i][2]));
        }
        
        Arrays.sort(node,(o1,o2) -> {return o1.start - o2.start;});
        
        Stack<Node> st = new Stack<>();
        for(int i=0; i<node.length-1; i++){
            int curr = node[i].start + node[i].remain;
            int next = node[i+1].start;
            
            if(curr <= next){
                ans.add(plans[node[i].idx][0]);
                
                int remain = next - curr;
                while(remain > 0 && !st.isEmpty()){
                    int del = st.peek().remain - remain;
                    st.peek().remain = Math.max(0,del);
                    if(del <= 0){
                        remain = -1*del;
                        ans.add(plans[st.pop().idx][0]);
                    }else{
                        remain = 0;
                    }
                }
            }else{
                node[i].remain = (curr - next);
                st.push(node[i]);
            }
        }
        
        ans.add(plans[node[node.length-1].idx][0]);
        
        while(!st.isEmpty()){
            ans.add(plans[st.pop().idx][0]);
        }
        
        return ans;
    }
}