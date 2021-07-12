package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01654 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ01654(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		List<Long> list = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		long G = Long.parseLong(st.nextToken());
		for(int i=0; i<N; ++i){
			list.add(Long.parseLong(br.readLine()));
		}
		
		if(N == 1){
			System.out.println((list.get(0) / G));
			return;
		}
		
		Collections.sort(list);
		
		long sLength = 1;
		long eLength = list.get(N-1) + 1;
		
		while((sLength+1) < eLength){
			long mLength = (sLength + eLength) / 2;
			long cnt = 0;
			for(long i : list){
				cnt += i/mLength;
			}
			
			if(cnt >= G){
				sLength = mLength;
			}else{
				eLength = mLength;
			}
		}
		
		System.out.println(sLength);
		
		
		sc.close();
		bw.close();
		br.close();
	}
}