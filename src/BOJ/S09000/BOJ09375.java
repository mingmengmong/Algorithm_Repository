package BOJ.S09000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ09375 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static void BOJ09375(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			Map<String, Integer> map = new HashMap<>();
			for(int i=0; i<N; ++i){
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				str = st.nextToken();
				map.put(str, map.getOrDefault(str, 1) + 1);
			}
			
			List<Integer> list = new ArrayList<>(map.values());
			int result = 1;
			for(int i : list){
				result *= i;
			}
			System.out.println(result - 1);
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}