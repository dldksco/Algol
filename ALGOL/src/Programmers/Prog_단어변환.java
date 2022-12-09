package Programmers;
import java.util.*;

class Prog_단어변환 {
    boolean visited[];
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean flag = false;
        Deque<int []> idx = new ArrayDeque<>();
       
        for(int i = 0 ; i< words.length ; i++){
            if(target.equals(words[i])){
                flag=true;
                break;
            }
        }
        visited=new boolean[words.length] ;
        if(!flag){
            answer=0;
            return answer;
        }
        idx.add(new int[] {-1,0});
        int tmp;
        String str;
        while(!idx.isEmpty()){
            tmp=idx.peek()[0];
            answer=idx.poll()[1];
            if(tmp==-1)
                str=begin;
            else
                str=words[tmp];
            for(int i=0; i<words.length ; i++){
                if(visited[i])continue;
                if(findOne(str,words[i])!=1)continue;
                if(words[i].equals(target)){
                    return answer+1;
                }
                
                visited[i]=true;
                idx.add(new int[] {i,answer+1 });
            }

        }
        return 0;
    }
    public int findOne(String origin, String a){
        int b=0;
        for(int i = 0 ; i<origin.length(); i++){
            if(i>2 && b<i-1){
                return 0;
            }
            if(origin.charAt(i)==a.charAt(i))
                b++;
        }
        if(b==origin.length()-1)
        return 1;
        else
            return 0;
    }
}