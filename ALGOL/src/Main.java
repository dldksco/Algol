import java.util.*;
import java.io.*;

class Main {
	static int R;
	static int C;
	static int N = 0;
	static char[][] map;
	static Deque<int[]> q;
	static Deque<int[]> water = new ArrayDeque<>();
	static int wanX;
	static int wanY;
	static int y;
	static int x;
	static int ny, nx;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int size;

	// 치즈갯수샐꺼야
	// 공기와 맞닿은 치즈 탐색 큐에넣음 넣으면서 값2
	// 다음턴 큐꺼내면서 체크 1인놈들 큐에넣어줌
	// 큐 비었는데 치즈 살아있으면 다시반복
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		q = new ArrayDeque<>();
		map = new char[C][R];
		String str;
		visited = new boolean[C][R];
		boolean[][] vis = new boolean[C][R];
		for (int i = 0; i < C; i++) {
			str = bf.readLine();
			for (int j = 0; j < R; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'X') {
					q.add(new int[] { i, j });
				} else if (map[i][j] == 'L') {

					wanX = j;
					wanY = i;

				}

			}
		}
		water.add(new int[] { wanY, wanX });
		size = q.size();
		for (int i = 0; i < size; i++) {
			y = q.peek()[0];
			x = q.poll()[1];
			for (int k = 0; k < 4; k++) {
				ny = y + dy[k];
				nx = x + dx[k];
				if (ny < 0 || nx < 0 || ny == C || nx == R)
					continue;
				if (map[ny][nx] == '.' || map[ny][nx] == 'L') {
					vis[ny][nx] = true;
					q.add(new int[] { y, x });
					break;
				}
			}
		}
		size = q.size();
		int idx = 0;
		while (!check()) {

			idx++;
			size = q.size();
			for (int i = 0; i < size; i++) {
				y = q.peek()[0];
				x = q.poll()[1];
				map[y][x] = '.';
				for (int j = 0; j < 4; j++) {
					ny = y + dy[j];
					nx = x + dx[j];
					if (ny < 0 || nx < 0 || ny == C || nx == R)
						continue;
					if (map[ny][nx] == 'X' && !vis[ny][nx]) {
						q.add(new int[] { ny, nx });
						vis[ny][nx] = true;
					}
				}
			}
		}
		System.out.println(idx);
	}

	static boolean check() {
		size = water.size();
		Deque<int[]> cq = new ArrayDeque<>();
		for (int i = 0; i < size; i++) {
			cq.add(water.poll());
			while (!cq.isEmpty()) {
				y = cq.peek()[0];
				x = cq.poll()[1];
				if (visited[y][x])
					continue;
				visited[y][x] = true;
				for (int j = 0; j < 4; j++) {
					ny = y + dy[j];
					nx = x + dx[j];
					if (ny < 0 || nx < 0 || ny == C || nx == R)
						continue;
					if (map[ny][nx] == 'L' && !visited[ny][nx])
						return true;
					if (!visited[ny][nx] && map[ny][nx] == '.')
						cq.add(new int[] { ny, nx });
					else if (map[ny][nx] == 'X') {
						water.add(new int[] { ny, nx });
					}
				}
			}
		}
		return false;
	}
}