package BOJ.S15000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ15663 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;

	public static int N;
	public static int M;
	public static List<Integer> list = new ArrayList<>();
	public static List<Integer> result = new ArrayList<>();
	public static Set<String> set = new HashSet<>();
	
	public static void BOJ15663(String[] args) throws Exception {
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
			String resultStr = "";
			for(int i=0; i<M; ++i){
				resultStr +=result.get(i) + " ";
			}
			if(!set.contains(resultStr)){
				bw.write(resultStr);
				bw.newLine();
				set.add(resultStr);
			}
			return;
		}
		
		for(int i=0; i<N-idx; ++i){
			result.set(idx, list.remove(i));
			NM(idx+1);
			list.add(i, result.get(idx));
		}
	}
}