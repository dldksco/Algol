package Softeer;
import java.util.*;
import java.io.*;


public class Softeer_슈퍼컴퓨터_클러스터
{
    static int N;
    static long B;
    static long sum;
    static long a[];
    public static void main(String args[]) throws Exception
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N=Integer.parseInt(st.nextToken());
        B=Long.parseLong(st.nextToken());
        a= new long[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ;i<N ; i++){
            a[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(a);
        binary();
    }
    static long check(long num){
        sum=0;
        for(int i = 0 ; i<N; i++){
            if(a[i]>=num)
                return sum;
                sum+=(num-a[i])*(num-a[i]);
            if(sum<0){
                return B+1;
            }
        }
        return sum;
    }
    static void binary(){
        long left=1;
        long right=2000000000;
        long mid =left+(right-left)/2;
        while(left<right){
            mid =left+(right-left)/2;
            // System.out.println(left+" "+ right+" "+check(mid));
            if(check(mid)>B){
                // System.out.println(check(mid)+" dasd "+left+" ad"+mid);
                right=mid;
                
            }   
                else
                left=mid+1;
        }
        System.out.println(right-1);
        
        
    }

}