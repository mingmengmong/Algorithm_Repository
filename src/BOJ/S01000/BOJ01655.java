package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01655 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ01655(String[] args) throws Exception {
		int N = sc.nextInt();
		if(N == 1){
			System.out.println(sc.nextInt());
			return;
		}
		
		PriorityQueue<Integer> minPq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 < o2 ? 1 : -1;
			}
		});
		PriorityQueue<Integer> maxPq = new PriorityQueue<>();
		
		for(int i=0; i<N; ++i){
			int n = sc.nextInt();
			if(i%2 == 0){
				if (minPq.size() == 0) {
					minPq.offer(n);
				}else{
					if(n <= maxPq.peek()){
						minPq.offer(n);
					}else{
						minPq.offer(maxPq.poll());
						maxPq.offer(n);
					}
				}
			}else{
				if(n >= minPq.peek()){
					maxPq.offer(n);
				}else{
					maxPq.offer(minPq.poll());
					minPq.offer(n);
				}
			}
			bw.write("---------------\n");
			bw.write(n + "\n");
			bw.write(minPq.toString() + "\n");
			bw.write(maxPq.toString() + "\n");
			bw.write(minPq.peek() + "\n");
			bw.write("---------------\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}