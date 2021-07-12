package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ01904 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static void BOJ01904(String[] args) throws Exception {
		int N = sc.nextInt();
		if(N <= 2){
			System.out.println(N);
			return;
		}
		
		int[] arr = new int[N];
		arr[0] = 1;
		arr[1] = 2;
		for(int i=2; i<N; ++i){
			arr[i] = (arr[i-1] + arr[i-2]) % 15746;
		}
		System.out.println(arr[N-1]);
		
		sc.close();
		bw.close();
		br.close();
	}
}