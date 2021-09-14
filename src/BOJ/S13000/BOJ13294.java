package BOJ.S13000;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ13294 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static Map<String, Integer> map = new HashMap<>();
	static{
		map.put("1", 1);
		map.put("2", 2);
		map.put("6", 3);
		map.put("24", 4);
		map.put("120", 5);
		map.put("720", 6);
	}
	
	public static void BOJ13294(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		String input = br.readLine();
		if(map.containsKey(input)){
			System.out.println(map.get(input));
			return;
		}
		
		int l = input.length() - 1;
		double s = 0;
		int i = 0;
		while(true){
			++i;
			s += Math.log10(i);
			if((int)s == l){
				System.out.println(i);
				break;
			}
		}
		
		br.close();
		bw.close();
		sc.close();
	}
}