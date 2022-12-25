package BOJ;
import java.util.*;
import java.io.*;

class BOJ_12865 {
	static int N;
	static int K;
	static List<int[]> env = new ArrayList<>();;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(bf.readLine());
			env.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		dp=new int[N][K+1];
		for(int i = env.get(0)[0] ; i<K+1 ; i++)
			dp[0][i]=env.get(0)[1];
		for(int i = 1 ; i< N ; i++) {
			for(int k= 0 ; k< K+1; k++) {
				if(k-env.get(i)[0]>=0)
				dp[i][k]=Math.max(dp[i-1][k],dp[i-1][k-env.get(i)[0]]+env.get(i)[1]);
				else
					dp[i][k]=dp[i-1][k];
			}
		}
		System.out.println(dp[N-1][K]);
	}
}