package BOJ.S15000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15953 {
	public static void BOJ15953(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		Map<Integer, Integer> aMap = new LinkedHashMap<Integer, Integer>(){{
			put(0, 0);
			put(1, 500);
			put(3, 300);
			put(6, 200);
			put(10, 50);
			put(15, 30);
			put(21, 10);
			put(100, 0);
		}};
		
		System.out.println(aMap.keySet());
		
		List<Integer> aGrade = new ArrayList<Integer>(){{
			add(0);
			add(1);
			add(3);
			add(6);
			add(10);
			add(15);
			add(21);
			add(100);
		}};
		
		Map<Integer, Integer> bMap = new HashMap<Integer, Integer>(){{
			put(0, 0);
			put(1, 512);
			put(3, 256);
			put(7, 128);
			put(15, 64);
			put(31, 32);
			put(64, 0);
		}};
		List<Integer> bGrade = new ArrayList<Integer>(){{
			add(0);
			add(1);
			add(3);
			add(7);
			add(15);
			add(31);
			add(64);
		}};
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; ++tc){
			String[] strSpl = br.readLine().split(" ");
			int a = Integer.parseInt(strSpl[0]);
			int b = Integer.parseInt(strSpl[1]);
			
			for(int i : aGrade){
				if(a <= i){
					a = i;
					break;
				}
			}
			for(int i : bGrade){
				if(b <= i){
					b = i;
					break;
				}
			}
			
			System.out.println(
					(aMap.get(a) + bMap.get(b)) * 10000
			);
			
		}
		
		br.close();
	}
}
