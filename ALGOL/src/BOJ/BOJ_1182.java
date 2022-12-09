package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_1182 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder ab = new StringBuilder();
		st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int map[] = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++)
			map[i] = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int tmp = Integer.MAX_VALUE;
		Arrays.sort(map);
		ArrayList<Integer> subSet = new ArrayList<>();
		for (int i = 1; i < (1 << N); i++) {
			subSet = new ArrayList<>();
			tmp = 0;
			for (int j = 0; j < N; j++) {
				if (((1 << j) & i) != 0) {
					subSet.add(j);
				}
			}
			for (int j = 0; j < subSet.size(); j++) {
				tmp += map[subSet.get(j)];
			}
			if (tmp == S) {
//				System.out.println("===============================");
//				for (int j = 0; j < subSet.size(); j++) {
//					System.out.printf("%d ", map[subSet.get(j)]);
//				}
				cnt++;
			}

		}
		System.out.println(cnt);
	}
}
