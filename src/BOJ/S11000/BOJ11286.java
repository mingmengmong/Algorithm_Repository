package BOJ.S11000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11286 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ11286(String[] args) throws Exception {
		int TC = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int abs1 = Math.abs(o1);
				int abs2 = Math.abs(o2);
				if(abs1 > abs2){
					return 1;
				}else if(abs1 == abs2){
					return o1 > o2 ? 1 : -1;
				}
				return -1;
			}
		});
		while(TC-- > 0){
			int n = sc.nextInt();
			if(n == 0){
				if(pq.size() == 0){
					bw.write("0\n");
				}else{
					bw.write(pq.poll() + "\n");
				}
			}else{
				pq.offer(n);
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}