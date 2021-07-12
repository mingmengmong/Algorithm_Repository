package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02606 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	
	public static void BOJ02606(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N];
		List<Integer>[] link = new List[N];
		for(int i=0; i<N; ++i){
			link[i] = new ArrayList<>();
		}
		for(int i=0; i<M; ++i){
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			link[n1].add(n2);
			link[n2].add(n1);
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(0);
		int result = 0;
		arr[0] = true;
		while(!list.isEmpty()){
			++result;
			int n = list.remove(0);
			for(int i : link[n]){
				if(!arr[i]){
					arr[i] = true;
					list.add(i);
				}
			}
		}
		System.out.println(result-1);
		
		sc.close();
		bw.close();
		br.close();
	}
}