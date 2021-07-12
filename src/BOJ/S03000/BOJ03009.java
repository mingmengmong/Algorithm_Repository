package BOJ.S03000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ03009 {
	public static void BOJ03009(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		Map<Integer, Integer> xMap = new HashMap<>();
		Map<Integer, Integer> yMap = new HashMap<>();
		
		for(int i=0; i<3; ++i){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			xMap.put(x, xMap.getOrDefault(x, 0)+1);
			yMap.put(y, yMap.getOrDefault(y, 0)+1);
			
		}
		
		int x = 0;
		for(int i : xMap.keySet()){
			if(xMap.get(i) == 1){
				x = i;
			}
		}
		
		int y = 0;
		for(int i : yMap.keySet()){
			if(yMap.get(i) == 1){
				y = i;
			}
		}
		
		System.out.println(x + " " + y);
		
		sc.close();
		br.close();
	}
}
