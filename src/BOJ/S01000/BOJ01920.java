package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01920 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ01920(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			int n = Collections.binarySearch(list, Integer.parseInt(st.nextToken()));
			bw.write((n > -1 ? 1 : 0 )+ "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}