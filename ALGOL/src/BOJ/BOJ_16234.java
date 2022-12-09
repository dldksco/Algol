package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_16234 {
	static int N;
	static int L;
	static int R;
	static int[][][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	// 0 방문 X -1 방문 O 그이상값 합치기
	// bfs 쓸거임 3차원배열 테스트를 했는데 개방해야돼 근데 이미개방된곳이네? 큐에 넣어야함 -> 사방탐색ㅇ
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		Deque<int[]> q = new ArrayDeque<>();
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = false;
		int cnt = 0;
		int x = 0;
		int y = 0;
		int nx = 0;
		int ny = 0;
		int idx = 1;
		while (!flag) {
			cnt++;
			flag = true;
			idx = 1;
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					map[i][j][1] = 0;
			q = new ArrayDeque<>();
			q.add(new int[] { 0, 0 });
			while (!q.isEmpty()) {
				y = q.peek()[0];
				x = q.poll()[1];
				// 방문체크나중에
				if (map[y][x][1] == -1)
					continue;
				if (map[y][x][1] == 0)
					map[y][x][1] = -1;

				for (int i = 0; i < 4; i++) {
					nx = x + dx[i];
					ny = y + dy[i];
					if (nx < 0 || ny < 0 || nx == N || ny == N)
						continue;
					if ((map[ny][nx][1] > 0 && map[ny][nx][1] == map[y][x][1]) || map[ny][nx][1] == -1)
						continue;
					if (check(map[ny][nx][0], map[y][x][0])) {
						if (map[y][x][1] > 0) {
							map[ny][nx][1] = map[y][x][1];
						} else {
							flag = false;
							map[y][x][1] = idx;
							map[ny][nx][1] = idx;
						}
						q.addFirst(new int[] { ny, nx });
					} else if (map[ny][nx][1] == 0)
						q.add(new int[] { ny, nx });
				}
				if (!flag)
					idx++;

			}
			if (idx > 1) {
				List<int[]> sum = new ArrayList<>();
				for (int i = 0; i < idx; i++) {
					sum.add(new int[] { 0, 0 });
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j][1] > 0) {
							sum.get(map[i][j][1])[0]++;
							sum.get(map[i][j][1])[1] += map[i][j][0];
						}
					}
				}
				for (int i = 0; i < sum.size(); i++) {
					if (sum.get(i)[0] > 0)
						sum.get(i)[1] = sum.get(i)[1] / sum.get(i)[0];
				}
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j][1] > 0) {
							map[i][j][0] = sum.get(map[i][j][1])[1];
						}
					}

				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.printf("%d ", map[i][j][1]);
//				}
//				System.out.println();
//			}
//			System.out.println(cnt + "=========================================");
		}

		System.out.println(cnt - 1);
	}

	static boolean check(int a, int b) {
		int diff = Math.abs(a - b);
//		System.out.println(diff);
		if (diff >= L && diff <= R)
			return true;
		return false;
	}
}