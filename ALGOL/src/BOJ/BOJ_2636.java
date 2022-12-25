package BOJ;

import java.util.*;
import java.io.*;

class BOJ_2636 {
	static int R;
	static int C;
	static int N = 0;
	static int[][] map;
	static Deque<int[]> q;
	static Deque<int[]> c;
	static int y;
	static int x;
	static int ny, nx;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<>();
		map = new int[C][R];
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < R; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					N++;
			}

		}
		int idx = 0;
		int tmpN = N;
		int size = 0;

		while (N != 0) {
//			System.out.println(idx);
//			for (int i = 0; i < C; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println("=====================================");
			tmpN = N;
			idx++;

			check();

			size = q.size();
			for (int i = 0; i < size; i++) {
				y = q.peek()[0];
				x = q.poll()[1];
				map[y][x] = 0;
				N--;
				for (int j = 0; j < 4; j++) {
					ny = dy[j] + y;
					nx = dx[j] + x;
					if (ny < 0 || nx < 0 || ny == C || nx == R)
						continue;
					if (map[ny][nx] == 1) {
						q.add(new int[] { ny, nx });
						map[ny][nx] = 2;
					}
				}
			}
		}
		System.out.println(idx);
		System.out.println(tmpN);
	}

	static void check() {

		c = new ArrayDeque<>();
		visited = new boolean[C][R];
		c.add(new int[] { 0, 0 });

		while (!c.isEmpty()) {
			y = c.peek()[0];
			x = c.poll()[1];
			for (int i = 0; i < 4; i++) {
				ny = dy[i] + y;
				nx = dx[i] + x;
				if (ny < 0 || nx < 0 || ny == C || nx == R)
					continue;
				if (!visited[ny][nx]) {
					if (map[ny][nx] == 0) {
						visited[ny][nx] = true;
						c.add(new int[] { ny, nx });
					} else if (map[ny][nx] == 1) {
						map[ny][nx] = 2;
						q.add(new int[] { ny, nx });
					}

				}

			}
		}
	}
}