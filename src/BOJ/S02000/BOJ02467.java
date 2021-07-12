package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02467 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ02467(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = N-1;
		int n1 = 0, n2 = 0;
		int min = Integer.MAX_VALUE;
		while(left < right){
			int s = arr[left] + arr[right];
			if(Math.abs(s) < min){
				min = Math.abs(s);
				n1 = arr[left];
				n2 = arr[right];
			}
			
			if(s < 0){
				++left;
			}else{
				--right;
			}
		}
		
		System.out.println(n1 + " " + n2);
		
		sc.close();
		br.close();
		bw.close();
	}
}