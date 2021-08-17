package BOJ.S01000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01644 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int N;
	public static List<Integer> list = new ArrayList<>();
	
	public static void make(){
		boolean[] arr = new boolean[N+1];
		int sqrt = Double.valueOf(Math.sqrt(N)).intValue();
		for(int i=2; i<=sqrt; ++i){
			if(arr[i])
				continue;
			for(int j=2*i; j<=N; j+=i){
				arr[j] = true;
			}
		}
		
		for(int i=2; i<=N; ++i){
			if(!arr[i])
				list.add(i);
		}
	}
	
	public static void BOJ01644(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		make();
		
		int result = 0;
		int sum = 0;
		List<Integer> list2 = new ArrayList<>();
		for(int num : list){
			list2.add(num);
			sum += num;
			if(sum == N){
				++result;
			}
			
			while(sum > N && !list2.isEmpty()){
				sum -= list2.remove(0);
				if(sum == N){
					++result;
				}
			}
		}
		
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}