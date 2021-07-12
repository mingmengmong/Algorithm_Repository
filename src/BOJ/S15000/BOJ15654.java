package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ15654 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;

	public static int N;
	public static int M;
	public static List<Integer> list = new ArrayList<>();
	
	public static void BOJ15654(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			list.add( Integer.parseInt(st.nextToken()) );
		}
		Collections.sort(list);
		
		NM(0, new int[M]);
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void NM(int idx, int[] result) throws Exception {
		if(idx == M){
			bw.write(String.valueOf(result[0]));
			for(int i=1; i<M; ++i){
				bw.write(String.format(" %d", result[i]));
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0; i<N-idx; ++i){
			result[idx] = list.remove(i);
			NM(idx+1, result);
			list.add(i, result[idx]);
		}
	}
}