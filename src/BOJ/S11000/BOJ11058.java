import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ11058 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, MAX=100;
	static long[] arr = new long[MAX+1];
	
	public static void BOJ11058(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = sc.nextInt();
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 4;
		arr[5] = 5;
		for(int i=6; i<=N; ++i){
			arr[i] = arr[i-1] + 1;
			for(int j=i-3,k=2; j>0; --j,++k){
				arr[i] = Math.max(arr[i], arr[j]*k);
			}
		}
		System.out.println(arr[N]);
		
		br.close();
		bw.close();
		sc.close();
	}
}