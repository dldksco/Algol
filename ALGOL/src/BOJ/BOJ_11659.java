package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_11659 {

	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] k = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0 ; i < N ; i++)
			k[i]=Integer.parseInt(st.nextToken());
		int[] dp = new int[N];
		dp[0]=k[0];
		for(int i = 1 ; i<N ; i++) {
			dp[i]=dp[i-1]+k[i];
		}
		int start=0;
		int end =0;
		for(int i = 0 ; i<M ; i++) {
			st = new StringTokenizer(bf.readLine());
			start=Integer.parseInt(st.nextToken())-1;
			end=Integer.parseInt(st.nextToken())-1;
			sb.append(dp[end]-dp[start]+k[start]).append("\n");
		}
		System.out.println(sb.toString());
	}
}