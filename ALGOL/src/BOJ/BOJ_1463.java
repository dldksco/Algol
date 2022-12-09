package BOJ;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_1463 {

	public static void main(String[] args) throws Exception {
			Deque<int []> q = new ArrayDeque<>();
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(bf.readLine());
			q.add(new int[] {n,0});
			int tmp=0;
			int time=0;
			int k =0;
			if(n==1) {
				System.out.println(0);
				return;
			}
				
			while(!q.isEmpty()) {
				tmp=q.peek()[0];
				time=q.poll()[1];
				if(tmp%3 ==0) {
					k=tmp/3;
					if(k==1) {
						System.out.println(time+1);
						return;
					}
					q.add(new int[] {k,time+1});
				} if(tmp%2 ==0) {
					k=tmp/2;
					if(k==1) {
						System.out.println(time+1);
						return;
					}
					q.add(new int[] {k,time+1});
				}
				k=tmp-1;
				if(k==1) {
					System.out.println(time+1);
					return;
				}
				q.add(new int[] {k,time+1});
				
					
			}
	    }
	
}