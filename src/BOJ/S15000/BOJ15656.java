package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ15656 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;

	public static int N;
	public static int M;
	public static List<Integer> list = new ArrayList<>();
	public static List<Integer> result = new ArrayList<>();
	
	public static void BOJ15656(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			list.add( Integer.parseInt(st.nextToken()) );
		}
		Collections.sort(list);
		
		for(int i=0; i<M; ++i){
			result.add(0);
		}
		
		NM(0);
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void NM(int idx) throws Exception {
		if(idx == M){
			for(int i=0; i<M; ++i){
				bw.write(result.get(i) + " ");
			}
			bw.newLine();
			return;
		}
		
		for(int i=0; i<N; ++i){
			result.set(idx, list.get(i));
			NM(idx+1);
		}
	}
}