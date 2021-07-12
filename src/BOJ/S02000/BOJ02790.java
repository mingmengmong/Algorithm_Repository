package BOJ.S02000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ02790 {
	public static void BOJ02790(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; ++i){
			int n = Integer.parseInt(br.readLine());
			set.add(n);
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		int n = 0;
		int max = -1;
		for(int i : list){
			n += map.get(i);
			max = Math.max(max, n + i);
		}
		
		
		int result = 0;
		for(int i : set){
			if((i+n) >= max){
				result += map.get(i);
			}
		}
		System.out.println(result);
		
		br.close();
	}
}
