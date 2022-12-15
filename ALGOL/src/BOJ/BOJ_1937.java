package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_1937 {
	static int N;
	static int map[][];
	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { -1, 1, 0, 0 };
	static int dp[][];
	static int nx;
	static int ny;
	static int answer = 0;

	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0 ; i<N ; i++) {
			for(int j = 0 ; j<N ; j++)
				answer=Math.max(answer, dfs(i,j));
		}
		System.out.println(answer);
	}

	static int dfs(int y, int x) {
		if (dp[y][x] == 0) {
			dp[y][x] = 1;
			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (ny < 0 || nx < 0 || nx == N || ny == N)
					continue;
				if(map[ny][nx]>map[y][x])
				dp[y][x]=Math.max(dp[y][x], dfs(ny,nx)+1);
			}
		}
		return dp[y][x];
	}

}