package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_11660 {

	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] k = new int[N+1][N+1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= N; j++)
				k[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+k[i][j];
			}
		}
		int x1=0;
		int x2=0;
		int y1=0;
		int y2=0;
		int answer=0;
		for(int i = 0 ; i<M ; i++) {
			st=new StringTokenizer(bf.readLine());
			x1=Integer.parseInt(st.nextToken());
			y1=Integer.parseInt(st.nextToken());
			x2=Integer.parseInt(st.nextToken());
			y2=Integer.parseInt(st.nextToken());
			answer=dp[x2][y2]-dp[x1-1][y2]-dp[x2][y1-1]+dp[x1-1][y1-1];
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}