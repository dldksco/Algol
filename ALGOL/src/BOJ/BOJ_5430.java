package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_5430 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder ab = new StringBuilder();
		int TC = Integer.parseInt(bf.readLine());
		for (int T = 1; T <= TC; T++) {
			StringBuilder sb = new StringBuilder();
			String str = bf.readLine();
			int P = Integer.parseInt(bf.readLine());
			String k = bf.readLine();
			Deque<Integer> q = new ArrayDeque<>();
			int stat = 0;
			char a = '0';
//			if (k.length() == 2) {
//				
//				ab.append("error").append("\n");
//				continue;
//			}
			for (int i = 1; i < k.length() - 1; i++) {
				a = k.charAt(i);
				if ((int) a > 57 || (int) a < 48) {
					q.add(Integer.parseInt(sb.toString()));
					sb = new StringBuilder();
					continue;
				}
				sb.append(a);
			}
			if (!sb.toString().equals(""))
				q.add(Integer.parseInt(sb.toString()));
			boolean flag = false;
			for (int i = 0; i < str.length(); i++) {
				a = str.charAt(i);
				if (a == 'D') {
					if (q.isEmpty()) {
						flag = true;
						ab.append("error").append("\n");
						break;
					}
					if (stat == 1) {
						q.pollLast();
					}
					if (stat == 0) {
						q.pollFirst();
					}
				} else if (a == 'R') {
					if (stat == 1)
						stat = 0;
					else
						stat = 1;
				}

			}
			if (!flag) {
				ab.append("[");
				if (q.isEmpty())
					ab.append("[");
				while (!q.isEmpty()) {
					if (stat == 1) {
						ab.append(q.pollLast()).append(",");
					}
					if (stat == 0) {
						ab.append(q.pollFirst()).append(",");
					}
				}
				ab.deleteCharAt(ab.length() - 1);
				ab.append("]").append("\n");

			}

		}
		ab.deleteCharAt(ab.length() - 1);
		System.out.println(ab.toString());
	}
}