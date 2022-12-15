package BOJ;
import java.util.*;
import java.io.*;

public class BOJ_16139 {
	public static void main(String args[]) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str = bf.readLine();
		if (str.length() > 1) {
			int vis = 1 << 26;
			int k = 0;
			for (int i = 0; i < str.length(); i++) {
				k = (int) str.charAt(i) - 97;
				k = 1 << k;
				if ((k & vis) > 0)
					continue;
				else {
					vis = vis | k;
				}
			}
			ArrayList<int[]> map = new ArrayList<>();
			for (int i = 0; i < 26; i++) {
				if ((vis & 1 << i) > 0)
					map.add(new int[str.length()]);
				else
					map.add(new int[1]);
			}

			for (int i = 0; i < 26; i++) {
				if (map.get(i).length == 1)
					continue;
				map.get(i)[0] = ((int) str.charAt(0) - 97 - i == 0 ? 1 : 0);
				for (int j = 1; j < str.length(); j++) {
					if ((int) str.charAt(j) - 97 - i == 0) {
						map.get(i)[j] += map.get(i)[j - 1] + 1;
					} else
						map.get(i)[j] = map.get(i)[j - 1];
				}
			}
			int N = Integer.parseInt(bf.readLine());
			char a;
			int start = 0;
			int end = 0;
			int answer = 0;
//			for (int[] c : map)
//				System.out.println(Arrays.toString(c));
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				a = st.nextToken().charAt(0);
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				if (map.get((int) a - 97).length > 1) {
					if (start > 0)
						answer = map.get((int) a - 97)[end] - map.get((int) a - 97)[start - 1];
					else
						answer = map.get((int) a - 97)[end];
					sb.append(answer).append("\n");
				} else if (map.get((int) a - 97).length == 1) {
					sb.append(0).append("\n");
				}
			}
		} else if (str.length() == 1) {
			int N = Integer.parseInt(bf.readLine());
			char a;
			int start;
			int end;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());
				a = st.nextToken().charAt(0);
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				if (a == str.charAt(0))
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
			}
		}
		System.out.println(sb.toString());
		// 97 a
		// 122 z
	}

}