import java.io.*;
import java.util.*;

public class BOJ01759 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M;
	static char[] arr, iter;
	static List<String> list = new ArrayList<>();
	
	static void comb(int idx, int n){
		if(idx == M){
			StringBuilder res = new StringBuilder();
			int n1 = 0;
			int n2 = 0;
			for(char c : iter){
				res.append(c);
				if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ++n1;
				else ++n2;
			}
			if(n2 >= 2 && n1 >= 1) list.add(res.toString());
			return;
		}
		if(n == N) return;
		
		iter[idx] = arr[n];
		comb(idx+1, n+1);
		comb(idx, n+1);
	}
	
	public static void BOJ01759 (String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new char[N];
		iter = new char[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i)
			arr[i] = st.nextToken().charAt(0);
		Arrays.sort(arr);
		
		comb(0, 0);
		
//		list.sort(String::compareTo);
		
		for(String str : list){
			bw.write(str);
			bw.newLine();
		}
		
		bw.flush();
		
		br.close();
		bw.close();
		sc.close();
	}
}