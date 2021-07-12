package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01005 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static List<Integer>[] idxArr;
	public static int[] lArr;
	public static int[] lengthArr;
	
	public static int length(int idx){
		if(lengthArr[idx] != -1){
			return lengthArr[idx];
		}
		
		int max = 0;
		for(int i : idxArr[idx]){
			max = Math.max(max, length(i));
		}
		
		return lengthArr[idx] = (max + lArr[idx]);
	}
	
	public static void BOJ01005(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			lArr = new int[N+1];
			lengthArr = new int[N+1];
			idxArr = new List[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; ++i){
				idxArr[i] = new ArrayList<>();
				lArr[i] = Integer.parseInt(st.nextToken());
				lengthArr[i] = -1;
			}
			
			for(int i=0; i<K; ++i){
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				idxArr[e].add(s);
			}
			
			int findIdx = Integer.parseInt(br.readLine());
			bw.write(length(findIdx) + "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}