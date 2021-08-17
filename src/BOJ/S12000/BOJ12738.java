package BOJ.S12000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12738 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int[] arr;
	public static List<Integer> list = new ArrayList<>();
	
	public static void BOJ12738(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		//sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		for(int num : arr){
			int idx = lowerBound(0, list.size(), num);
			if(idx == list.size()) list.add(num);
			else list.set(idx, num);
		}
		
		System.out.println(list.size());
		
		br.close();
		bw.close();
		sc.close();
	}
	
	public static int lowerBound(int s, int e, int num){
		while(s < e){
			int m = (s+e) >>> 1;
			int mm = list.get(m);
			if(num <= mm) e = m;
			else s = m+1;
		}
		return s;
	}
}