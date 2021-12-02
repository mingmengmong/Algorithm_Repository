import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ02470 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N;
	static int[] arr;
	
	public static void BOJ02470(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int target = Integer.MAX_VALUE;
		int n1 = 0, n2 =0;
		int l = 0, r = N-1;
		while(l<r){
			int s = arr[l] + arr[r];
			if(s < 0){
				if(-s < target){
					n1 = l;
					n2 = r;
					target = -s;
				}
				++l;
			}else if(s == 0){
				n1 = l;
				n2 = r;
				break;
			}else{
				if(s < target){
					n1 = l;
					n2 = r;
					target = s;
				}
				--r;
			}
		}
		
		System.out.println(arr[n1] + " " + arr[n2]);
		
		br.close();
		bw.close();
		sc.close();
	}
}