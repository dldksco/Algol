package Programmers;
import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int tmp=0;
        for(int i = 0 ; i< enemy.length ; i++){
            if(n-enemy[i]<0){
                if(k==0)
                    return i;
                else{
                    if(!q.isEmpty()){
                        tmp=q.poll();
                        if(enemy[i]>tmp){
                            q.add(tmp);
                            k-=1;
                            continue;
                        }
                        k-=1;
                        n+=tmp;
                        i--;    
                    }else{
                        k-=1;
                        continue;
                    }
                    
                }
            }
            else{
                n-=enemy[i];
                q.add(enemy[i]);
            }
        }
        answer=enemy.length;
        return answer;
    }
}