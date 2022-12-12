package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1261 {
	static int N, M;
	static int map[][][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static Deque<Node> q = new ArrayDeque<>();
	static int nx, x;
	static int ny, y, cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M][2];
		String str;
		for (int i = 0; i < N; i++) {
			str = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j][0] = str.charAt(j) - '0';
				map[i][j][1] = Integer.MAX_VALUE;
			}
		}
		q.add(new Node(0, 0, 0));
		while (!q.isEmpty()) {
			y = q.peek().y;
			x = q.peek().x;
			cnt = q.poll().cnt;
			if (map[y][x][1] < cnt)
				continue;
			if (y == N - 1 && x == M - 1) {
				map[y][x][1] = cnt;
				continue;
			}
			for (int i = 0; i < 4; i++) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx == M || ny == N)
					continue;
				if (map[ny][nx][0] == 1) {
					if (map[ny][nx][1] > cnt + 1) {
						map[ny][nx][1] = cnt + 1;
						q.addLast(new Node(ny, nx, cnt + 1));
					}
				} else {
					if (map[ny][nx][1] > cnt) {
						q.addFirst(new Node(ny, nx, cnt));
						map[ny][nx][1] = cnt;
					}
				}

			}
		}
		System.out.println(map[N - 1][M - 1][1]);
	}
}

class Node {
	int x;
	int y;
	int cnt;

	Node(int y, int x, int cnt) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
	}

}
