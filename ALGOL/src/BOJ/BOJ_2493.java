package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2493 {
	static int N;
	static int map[][];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		// 인덱스 높이
		Deque<int[]> d = new ArrayDeque<>();
		int h = 0;
		for (int i = 1; i <= N; i++) {
			h = Integer.parseInt(st.nextToken());
			while (!d.isEmpty()) {
				if (d.peekFirst()[1] > h) {
					sb.append(d.peekFirst()[0]).append(" ");
					d.addFirst(new int[] { i, h });
					break;
				} else
					d.pollFirst();
			}
			if (d.isEmpty()) {
				d.addFirst(new int[] { i, h });
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
}