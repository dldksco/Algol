package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_1175 {
	static char[][] map;
	static int N;
	static int M;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		Deque<Minsick> q = new ArrayDeque<>();
		StringTokenizer st;
		ArrayList<boolean[][][]> visited = new ArrayList<>();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			visited.add(new boolean[N][M][3]);
		}
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					for (int k = 0; k < 4; k++) {
						int nx = j + dx[k];
						int ny = i + dy[k];

						if (nx < 0 || ny < 0 || nx == M || ny == N)
							continue;
						visited.get(k)[i][j][0] = true;
						if (map[ny][nx] != '#') {
							q.add(new Minsick(ny, nx, k, 1, 0, -1, -1));
						}

					}
				}
				if (map[i][j] == 'C' && !flag) {
					map[i][j] = '1';
					flag = true;
				} else if (map[i][j] == 'C' && flag) {
					map[i][j] = '2';
				}
			}
		}
		Minsick tmp;
		int x = 0;
		int y = 0;
		int time = 0;
		int stat = 0;
		int cnt = 0;
		int cY = -1;
		int cX = -1;
		// 0 위 1 아래 왼 2 오 3
		while (!q.isEmpty()) {
			tmp = q.poll();
			x = tmp.x;
			y = tmp.y;
			cnt = tmp.cnt;
			time = tmp.time;
			stat = tmp.stat;
			cY = tmp.cY;
			cX = tmp.cX;
		
			if (!visited.get(stat)[y][x][cnt]) {
				visited.get(stat)[y][x][cnt] = true;

				if (map[y][x] == '1') {
					if (cnt == 0) {
						cnt = 1;
						cY = y;
						cX = x;
					} else if (cnt == 2) {
						System.out.println(time);
						return;
					}
				} else if (map[y][x] == '2') {
					if (cnt == 0) {
						cnt = 2;
						cY = y;
						cX = x;
					} else if (cnt == 1) {
						System.out.println(time);
						return;
					}
				}
				for (int i = 0; i < 4; i++) {
					
					if (i == stat) {
						continue;
					}
					int nx = x + dx[i];
					int ny = y + dy[i];
					if (nx < 0 || ny < 0 || nx == M || ny == N)
						continue;
					if (map[ny][nx] != '#') {
						q.add(new Minsick(ny, nx, i, time + 1, cnt, cY, cX));
						
					}
				}
			}
		}
		System.out.println(-1);

	}

	static class Minsick implements Comparable<Minsick> {
		int x;
		int y;
		int stat;
		int time;
		int cnt;
		int cY;
		int cX;

		Minsick(int y, int x, int stat, int time, int cnt, int cY, int cX) {
			this.x = x;
			this.y = y;
			this.stat = stat;
			this.time = time;
			this.cnt = cnt;
			this.cY = cY;
			this.cX = cX;
		}

		@Override
		public String toString() {
			return "Minsick [x=" + x + ", y=" + y + ", stat=" + stat + ", time=" + time + ", cnt=" + cnt + ", cY=" + cY
					+ ", cX=" + cX + "]";
		}

		@Override
		public int compareTo(Minsick minsick) {
//			if (this.time == minsick.time)
			if (minsick.cnt == this.cnt)
				return this.time - minsick.time;
			return minsick.cnt - this.cnt;
//			return this.time - minsick.time;
		}

	}
}