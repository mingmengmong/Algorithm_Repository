package BOJ.S07000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ07662 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ07662(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int N = Integer.parseInt(br.readLine());
			TreeSet<Integer> set = new TreeSet<>();
			Map<Integer, Integer> map = new HashMap<>();
			while(N-- > 0){
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if("I".equals(cmd)){
					map.put(n, map.getOrDefault(n, 0)+1);
					set.add(n);
				}else{
					try {
						if (n < 0) {
							int num = set.first();
							if(map.get(set.first()) > 1){
								map.put(num, map.get(num)-1);
							}else {
								set.pollFirst();
								map.remove(num);
							}
						} else {
							int num = set.last();
							if(map.get(set.last()) > 1){
								map.put(num, map.get(num)-1);
							}else {
								set.pollLast();
								map.remove(num);
							}
						}
					}catch(Exception e){}
				}
			}
			if(set.isEmpty()){
				bw.write("EMPTY\n");
			}else{
				bw.write(String.format("%d %d\n", set.last(),set.first()));
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}