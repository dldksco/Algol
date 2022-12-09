package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static int N;
	static int M;
	static int V;
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> map;

	public static void main(String[] args) throws Exception {
		Deque<Integer> q = new ArrayDeque<>();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		map = new ArrayList<>();

		map.add(new ArrayList<>());
		for (int i = 0; i < N; i++) {
			map.add(new ArrayList<>());
		}
		int from = 0;
		int to = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			map.get(from).add(to);
			map.get(to).add(from);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(map.get(i), (o1, o2) -> {
				return o1 - o2;
			});
		}
		ArrayList<Integer> ans = new ArrayList<>();
		dfs(ans, V);
		for (int a : ans) {
			sb.append(a).append(" ");
		}
		sb.append("\n");
		visited = new boolean[N + 1];
		q.add(V);
		int tmp = 0;
		while (!q.isEmpty()) {
			tmp = q.poll();
			if (visited[tmp])
				continue;
			visited[tmp] = true;
			sb.append(tmp).append(" ");
			for (int idx : map.get(tmp)) {
				if (visited[idx])
					continue;
				q.add(idx);
			}
		}
		sb.append("\n");
		System.out.println(sb.toString());
		
	}

	static void dfs(ArrayList<Integer> ans, int num) {
		if (visited[num])
			return;
		visited[num] = true;
		ans.add(num);
		for (int idx : map.get(num)) {
			if (visited[idx])
				continue;
			dfs(ans, idx);
		}
	}
}