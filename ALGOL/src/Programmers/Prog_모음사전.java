package Programmers;
import java.util.*;
class Prog_모음사전 {
    List<String> dict = new ArrayList();
    String[] str = {"A","E","I","O","U"};
    public int solution(String word) {
        int answer = 0;
        for(int i = 0 ; i<5; i++)
        make(str[i],0);
        for(int i = 0 ; i<dict.size(); i++){
            if(word.equals(dict.get(i))){
                answer=i+1;
                break;
            }
                
        }
        return answer;
    }
    public void make(String k, int depth){
        if(depth==5)
            return;
        dict.add(k);
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i<5 ; i++){
            sb = new StringBuilder();
            sb.append(k);
            sb.append(str[i]);
            make(String.valueOf(sb),depth+1);
        }
    }
}