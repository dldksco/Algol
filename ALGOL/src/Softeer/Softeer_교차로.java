package Softeer;
import java.util.*;
import java.io.*;


public class Softeer_교차로
{
       static Deque<car> A = new ArrayDeque<>();
        static int sizeA=0;
        static Deque<car> B = new ArrayDeque<>();
        static int sizeB=0;
        static Deque<car> C = new ArrayDeque<>();
        static int sizeC=0;
        static int sizeD=0;
        static Deque<car> D = new ArrayDeque<>();
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        ArrayList<car> carList = new ArrayList<>();
        Deque<Integer> idx = new ArrayDeque<>();

        int N = Integer.parseInt(bf.readLine());
        int time=0;
        char stat=0;
        idx.add(-1);
        for(int i = 0 ; i< N ; i++){
            st=new StringTokenizer(bf.readLine());
            time=Integer.parseInt(st.nextToken());
            stat=st.nextToken().charAt(0);
            carList.add(new car(i, time , stat));
            if(idx.peekLast()<time)
            {idx.add(time);
            }
        }
        idx.poll();
        int carIdx=0;
        time=0;
        int tmpTime=0;
        car c;
        boolean flag=false;
        while(time<Integer.MAX_VALUE-1){
            flag=true;
            if(carIdx==carList.size() && sizeA==0 && sizeB==0 && sizeC==0 && sizeD==0)
                break;
            if(sizeA==0 && sizeB==0 && sizeC==0 && sizeD==0){
                if(idx.size()==0)
                    break;
                time=idx.poll();
                flag=false;
            }else{
                if(!idx.isEmpty()){
                tmpTime=idx.peek();
                if(tmpTime==time){
                    tmpTime=idx.poll();
                    flag=false;
                }
                }
            }
            if(!flag)
            for(int i = carIdx ; i<carList.size(); i++){
                c=carList.get(i);
                if(c.time!=time){
                    carIdx=i;
                    break;
                }

                check(c);
            }
            if(sizeA>0 && sizeB>0 && sizeC>0&& sizeD>0){
                
                break;
            }
            
            if(sizeA>0 && sizeD==0 ){
                c=A.poll();
                c.outtime(time);
            }if(sizeB>0 && sizeA==0){
                c=B.poll();
                c.outtime(time);
            }if(sizeC>0 && sizeB==0){
                c=C.poll();
                c.outtime(time);
            }if(sizeD>0 && sizeC==0){
                c=D.poll();
                c.outtime(time);
            }
            sizeA=A.size();
            sizeB=B.size();
            sizeC=C.size();
            sizeD=D.size();
            time++;
        }
        for(car z : carList){
            System.out.println(z.outtime);
        }
        
    }
    static void check(car k){
        char stat=k.stat;
       
        if(stat=='A'){
            A.add(k);
            sizeA++;
        }else if(stat=='B'){
            B.add(k);
            sizeB++;
        }else if(stat=='C'){
            C.add(k);
            sizeC++;
        }else if(stat=='D'){
            D.add(k);
            sizeD++;
        }
    }
}

class car implements Comparable<car> {
    int num;
    int time;
    int outtime=-1;
    char stat;
    car(int num, int time, char stat){
        this.num=num;
        this.time=time;
        this.stat=stat;
    }
    public void outtime(int t){
        this.outtime=t;
    }
    @Override
    public int compareTo(car a){
        return this.num-a.num;
    }
    
}