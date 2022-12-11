package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2573 {
	static int N, M;
	static int map[][];
	static List<Ice> ice;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Deque<int[]> checkQ = new ArrayDeque<>();
	static boolean visited[][];
	static int nx, x;
	static int ny, y;
	static int size;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ice = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					ice.add(new Ice(i, j, map[i][j]));
				}
			}
		}
		int cnt = 0;
		while (check()) {
			for (int i = 0; i < ice.size(); i++) {
				y = ice.get(i).y;
				x = ice.get(i).x;
				size = ice.get(i).h;
				for (int j = 0; j < 4; j++) {
					ny = y + dy[j];
					nx = x + dx[j];
					if (ny < 0 || nx < 0 || ny == N || nx == M)
						continue;
					if (map[ny][nx] == 0) {
						size--;
					}
					if (size == 0) {
						ice.get(i).setH(size);
						break;
					}
					ice.get(i).setH(size);
				}
			}
			for (int i = ice.size() - 1; i > -1; i--) {
				y = ice.get(i).y;
				x = ice.get(i).x;
				size = ice.get(i).h;
				if (size <= 0) {
					map[y][x] = 0;
					ice.remove(i);
				} else
					map[y][x] = size;
			}
			cnt++;

		}
		if (ice.size() == 0)
			System.out.println(0);
		else
			System.out.println(cnt);
	}

	static boolean check() {
		if (ice.size() <= 1) {
			return false;
		}
		int kx = ice.get(0).x;
		int ky = ice.get(0).y;
		size = 0;

		visited = new boolean[N][M];
		checkQ.add(new int[] { ky, kx });
		while (!checkQ.isEmpty()) {
			y = checkQ.peek()[0];
			x = checkQ.poll()[1];
			size++;
			visited[y][x] = true;
			for (int i = 0; i < 4; i++) {
				ny = y + dy[i];
				nx = x + dx[i];
				if (ny < 0 || nx < 0 || ny == N || nx == M)
					continue;
				if (visited[ny][nx] == false && map[ny][nx] > 0) {
					visited[ny][nx] = true;
					checkQ.add(new int[] { ny, nx });
				}
			}
		}
		if (size != ice.size()) {
			return false;
		}
		return true;

	}

}

class Ice {
	int x;
	int y;
	int h;

	Ice(int y, int x, int h) {
		this.y = y;
		this.x = x;
		this.h = h;
	}

	void setH(int h) {
		this.h = h;
	}
}