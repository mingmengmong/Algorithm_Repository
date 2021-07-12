package BOJ.S14000;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ14753 {
	public static void BOJ14753(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		
		int N = Integer.parseInt(br.readLine());
		String[] strSpl = br.readLine().split(" ");
		List<Integer> list = new ArrayList<>();
		for(String str : strSpl){
			list.add(Integer.parseInt(str));
		}
		Collections.sort(list);
		
		int n1 = list.get(0) * list.get(1);
		int n2 = list.get(N-1) * list.get(N-2);
		int n3 = n1 * list.get(N-1);
		int n4 = n2 * list.get(N-3);
		int max = Integer.MIN_VALUE;
		max = Math.max(max,n1);
		max = Math.max(max,n2);
		max = Math.max(max,n3);
		max = Math.max(max,n4);
		
		System.out.println(max);
		
		sc.close();
		br.close();
	}
}
