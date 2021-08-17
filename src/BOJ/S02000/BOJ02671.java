package BOJ.S02000;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ02671 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ02671(String[] args) throws Exception {
		//br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
		
		// (100~1~|01)~
		char[] str = br.readLine().toCharArray();
		char stage = 'a';
		boolean isSubmarine = true;
		for(char c : str){
			if(!isSubmarine)
				break;
			boolean cb0 = c == '0';
			switch(stage){
				case 'a':
					if(cb0) stage = 'b';
					else stage = 'c';
					break;
					
				case 'b':
					if(cb0) isSubmarine = false;
					else stage = 'a';
					break;
					
				case 'c':
					if(cb0) stage = 'd';
					else isSubmarine = false;
					break;
					
				case 'd':
					if(cb0) stage = 'e';
					else isSubmarine = false;
					break;
					
				case 'e':
					if(cb0) stage = 'e';
					else stage = 'f';
					break;
					
				case 'f':
					if(cb0) stage = 'b';
					else stage = 'g';
					break;
					
				case 'g':
					if(cb0) stage = 'h';
					else stage = 'g';
					break;
					
				case 'h':
					if(cb0) stage = 'e';
					else stage = 'a';
					break;
					
				default:
					isSubmarine = false;
					break;
			}
		}
		
		System.out.println( (isSubmarine && (stage == 'a' || stage == 'f' || stage == 'g')) ? "SUBMARINE" : "NOISE" );
		
		sc.close();
		bw.close();
		br.close();
	}
}
