import java.io.*;
import java.util.*;

public class BOJ09934 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N;
	static List<Integer> arr = new ArrayList();
	static List<Integer>[] list = new List[11];
	static {
		for (int i=0; i<=10; ++i)
			list[i] = new ArrayList<>();
	}
	
	static void init(int left, int right, int depth){
		if(left == right){
			list[depth].add(arr.get(left));
			return;
		}
		
		int mid = (left + right) >>> 1;
		list[depth].add(arr.get(mid));
		init(left, mid-1, depth+1);
		init(mid+1, right, depth+1);
	}
	
	public static void BOJ09934 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()){
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		init(0, arr.size()-1, 1);
		for(int i=1; i<=N; ++i){
			for(int iter : list[i]){
				System.out.printf("%d ", iter);
			}
			System.out.println();
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}