package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02263 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int[] inOrder;
	public static int[] postOrder;
	public static int[] arr;
	
	public static void BOJ02263(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		inOrder = new int[N];
		postOrder = new int[N];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			inOrder[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			postOrder[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		for(int i=0; i<N; ++i){
			arr[inOrder[i]] = i;
		}
		
		preOrder(0, N-1, 0, N-1);
		bw.newLine();
		
		sc.close();
		bw.close();
		br.close();
	}
	public static void preOrder(int inS, int inE, int postS, int postE) throws Exception {
		if(inS > inE || postS > postE){
			return;
		}
		
		int root = postOrder[postE];
		bw.write((root+1) + "\n");
		
		preOrder(inS, arr[root]-1, postS, postS + arr[root]-inS-1);
		preOrder(arr[root]+1, inE, postS + arr[root]-inS, postE-1);
	}
}