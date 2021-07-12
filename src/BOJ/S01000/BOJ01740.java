package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01740 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int[][] arr = new int[9][9];
	public static List<Node> list = new ArrayList<>();
	public static int zeroCnt = 0;
	
	public static class Node{
		public int r;
		public int c;
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static boolean isFinish = false;
	public static void find(int idx){
		if(idx == zeroCnt){
			isFinish = true;
			return;
		}
		
		Node node = list.get(idx);
		int r = node.r;
		int c = node.c;
		List<Integer> numbers = makeNumbers(r,c);
		
		for(int num : numbers){
			arr[r][c] = num;
			find(idx+1);
			if(isFinish){
				break;
			}
		}
		
		if(!isFinish){
			arr[r][c] = 0;
		}
	}
	
	public static void BOJ01740(String[] args) throws Exception {
		for(int i=0; i<9; ++i){
			char[] str = br.readLine().toCharArray();
			for(int j=0; j<9; ++j){
				arr[i][j] = str[j] - '0';
				if(arr[i][j] == 0){
					++zeroCnt;
					list.add( new Node(i, j) );
				}
			}
		}
		
		find(0);
		
		for(int i=0; i<9; ++i){
			String str = "";
			for(int j=0; j<9; ++j){
				str += arr[i][j];
			}
			System.out.println(str);
		}
		
		sc.close();
		br.close();
		bw.close();
	}
	
	public static List<Integer> makeNumbers(int r, int c){
		List<Integer> numbers = new ArrayList<Integer>(){{
			for(int i=1; i<=9; ++i){
				add(i);
			}
		}};
		
		for(int i=0; i<3; ++i){
			for(int j=0; j<3; ++j){
				numbers.remove(Integer.valueOf(arr[r][i*3+j]));
				numbers.remove(Integer.valueOf(arr[i*3+j][c]));
				numbers.remove(Integer.valueOf(arr[r/3*3+i][c/3*3+j]));
			}
		}
		
		return numbers;
	}
}