package BOJ.S01000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ01026 {
	public static void BOJ01026(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = sc.nextInt();
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for(int j=0; j<N; ++j){
			a.add(sc.nextInt());
		}
		for(int j=0; j<N; ++j){
			b.add(sc.nextInt());
		}
		
		Collections.sort(a);
		Collections.sort(b, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 > o2 ? -1 : 1;
			}
		});
		
		int r = 0;
		for(int i=0; i<N; ++i){
			r += a.get(i)*b.get(i);
		}
		System.out.println(r);
		
		sc.close();
		br.close();
	}
}