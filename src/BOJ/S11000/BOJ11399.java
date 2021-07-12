package BOJ.S11000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ11399 {
	public static void BOJ11399(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		String[] strSpl = br.readLine().split(" ");
		
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			list.add(Integer.parseInt(strSpl[i]));
		}
		Collections.sort(list);
		
		int result = 0;
		int bt = 0;
		for(int i=0; i<N; ++i){
			bt += list.get(i);
			result += bt;
		}
		
		System.out.println(result);
		
		br.close();
	}
}
