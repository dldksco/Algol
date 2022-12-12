package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1111 {
	static int N;
	static int map[];
	static int a, b;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		map = new int[N];
		for (int i = 0; i < N; i++)
			map[i] = Integer.parseInt(st.nextToken());
		if (N == 1) {
			System.out.println('A');
			return;
		}
		if (N == 2) {
			if (map[0] == map[1]) {
				System.out.println(map[0]);
				return;
			} else {
				System.out.println('A');
				return;
			}
		}
		if (map[0] == map[1]) {
			a = 1;
			b = 0;

		} else {
			if ((map[1] - map[2]) % (map[0] - map[1]) != 0) {
				System.out.println('B');
				return;
			} else {
				a = (map[1] - map[2]) / (map[0] - map[1]);
				b = map[1] - (map[0] * a);
			}
		}
		for (int i = 1; i < N; i++) {
			if (map[i] != map[i - 1] * a + b) {
				System.out.println('B');
				return;
			}
		}
		if (map[0] == map[1]) {
			System.out.println(map[0]);
		} else
			System.out.println(map[N - 1] * a + b);
	}

}
