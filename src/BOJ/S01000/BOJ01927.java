package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ01927 {
	public static void BOJ01927(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int TC = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue();
		for(int tc=0; tc<TC; ++tc){
			int n = sc.nextInt();
			if(n==0){
				System.out.println(pq.isEmpty()?0:pq.poll());
			}else{
				pq.add(n);
			}
		}
		
		sc.close();
		br.close();
	}
}
