package BOJ;
import java.util.*;
import java.io.*;

class BOJ_1655 {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(bf.readLine());
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min = new PriorityQueue<>();
		int tmp = 0;
		int qTmp = 0;
		for (int i = 0; i < N; i++) {
			tmp = Integer.parseInt(bf.readLine());
			if (max.isEmpty()) {
				max.add(tmp);
			} else if (min.isEmpty()) {
				if (max.peek() <= tmp)
					min.add(tmp);
				else {
					min.add(max.poll());
					max.add(tmp);
				}
			} else {
				if (min.peek() <= tmp)
					min.add(tmp);
				else
					max.add(tmp);
			}
			if (min.size() > max.size())
				max.add(min.poll());
			else if(min.size()+2 == max.size()){
				min.add(max.poll());
			}
			sb.append(max.peek()).append("\n");
		}
		System.out.println(sb.toString());
	}
}