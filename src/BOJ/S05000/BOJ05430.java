package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ05430 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	
	public static void BOJ05430(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			String func = br.readLine().replaceAll("(RR)", "");
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine().substring(1).replaceAll("\\[|\\]", ""), ",");
			
			List<Integer> list = new ArrayList<>();
			for(int i=0; i<N; ++i){
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean b = true;
			boolean r = false;
			int length = func.length();
			for(int i=0; i<length && b; ++i){
				char c = func.charAt(i);
				if(c == 'R'){
					r = !r;
				}else if(c == 'D'){
					if(N == 0){
						b = false;
					}else{
						--N;
						int idx = r ? N : 0;
						list.remove(idx);
					}
				}
			}
			
			if(r){
				Collections.reverse(list);
			}
			
			if(b){
				bw.write(list.toString().replaceAll("\\s", "") + "\n");
			}else{
				bw.write("error\n");
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}