package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01541 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	
	
	public static void BOJ01541(String[] args) throws Exception {
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, "-+");
		List<Integer> list = new ArrayList<>();
		while(st.hasMoreTokens()){
			list.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(input, "0123456789");
		int i = 0;
		boolean b = false;
		long result = list.get(i++);
		while(st.hasMoreTokens()){
			String s = st.nextToken();
			if("-".equals(s)){
				b = true;
			}
			if(b){
				result -= list.get(i++);
			}else{
				result += list.get(i++);
			}
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
}