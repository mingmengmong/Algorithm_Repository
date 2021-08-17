package BOJ.S12000;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ12015_2 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static List<Integer> list = new ArrayList<>();
	
	public static void BOJ12015_2(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		list.add(Integer.parseInt(st.nextToken()));
		for(int i=1; i<N; ++i){
			int n = Integer.parseInt(st.nextToken());
			int idx = lowerBound(n);
			if(idx == list.size()) list.add(n);
			else list.set(idx, n);
		}
		
		System.out.println(list.size());
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int lowerBound(int n){
		if(list.isEmpty()) return 0;
		
		int l = 0, r = list.size();
		while(l < r){
			int mid = (l+r) >>> 1;
			int midN = list.get(mid);
			if(n <= midN){
				r = mid;
			}else{
				l = mid + 1;
			}
		}
		return l;
	}
}
