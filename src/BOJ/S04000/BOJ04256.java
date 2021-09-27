import java.io.*;
import java.util.*;

public class BOJ04256 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int TC, N;
	static int[] preorder, preorderIdx, inorder, inorderIdx;
	static int[][] G;
	
	static void init(int preL, int preR, int inL, int inR) throws Exception {
		if(preL == preR){
			bw.write(String.format("%d ", preorder[preL]));
			return;
		}
		if(preL > preR) return;
		
		int u = preorder[preL];
		int inorderUIdx = inorderIdx[u];
		
		int inLLIdx = inL;
		int inLRIdx = inorderUIdx-1;
		int preLLIdx = preL+1;
		int preLRIdx = preLLIdx + (inLRIdx - inLLIdx);
		init(preLLIdx, preLRIdx, inLLIdx, inLRIdx);
		
		int inRRIdx = inR;
		int inRLIdx = inorderUIdx+1;
		int preRLIdx = preLRIdx + 1;
		int preRRIdx = preR;
		init(preRLIdx, preRRIdx, inRLIdx, inRRIdx);
		
		bw.write(String.format("%d ", u));
	}
	
	public static void BOJ04256 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			N = Integer.parseInt(br.readLine());
			preorder = new int[N];
			preorderIdx = new int[N+1];
			inorder = new int[N];
			inorderIdx = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; ++i){
				int n = Integer.parseInt(st.nextToken());
				preorder[i] = n;
				preorderIdx[n] = i;
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; ++i){
				int n = Integer.parseInt(st.nextToken());
				inorder[i] = n;
				inorderIdx[n] = i;
			}
			
			init(0, N-1, 0, N-1);
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}