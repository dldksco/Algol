package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_10815 {
	static int N;
	static int M;
	static int card[];
	static int ans[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(bf.readLine());

		card = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++)
			card[i] = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(bf.readLine());
		ans = new int[M];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < M; i++)
			ans[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(card);
		for(int i = 0 ; i< M ; i++) {
			binary(ans[i]);
		}
		System.out.println(sb.toString());
	}

	public static void binary(int target) {
		int start = 0;
		int end = N - 1;
		int mid = (start + end) / 2;
		
		while(start<=end) {
			mid=(start+end)/2;
			if(card[mid]==target) {
				sb.append(1).append(" ");
				return;
			}else if(card[mid]>target) {
				end=mid-1;
			}else
				start=mid+1;
			
		}
		
		
		sb.append(0).append(" ");
	}
}