import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		
		
		br.close();
		bw.close();
		sc.close();
	}
}