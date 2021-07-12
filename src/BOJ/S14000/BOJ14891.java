package BOJ.S14000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14891 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	// N=0, S=1 | 12시부터 시계방향
	public static int[][] gear = new int[4][8];
	
	public static int[] gear1 = new int[8];
	public static int[] gear2 = new int[8];
	public static int[] gear3 = new int[8];
	public static int[] gear4 = new int[8];
	
	public static class Node{
		public int gearIdx;
		public int direction;
		public Node(int g, int d){
			gearIdx = g;
			direction = d;
		}
	}
	
	public static void BOJ14891(String[] args) throws Exception {
		for(int i=0; i<4; ++i){
			String str = br.readLine();
			for(int j=0; j<8; ++j){
				gear[i][j] = str.charAt(j) - '0';
			}
		}
		
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken());
			
			boolean[] isMove = new boolean[4];
			List<Node> list = new ArrayList<>();
			list.add(new Node(g, d));
			while(!list.isEmpty()){
				Node node = list.remove(0);
				int gearIdx = node.gearIdx;
				int direction = node.direction;

				if(isMove[gearIdx]){
					continue;
				}

				isMove[gearIdx] = true;
				if(gearIdx > 0){
					if(gear[gearIdx-1][2] != gear[gearIdx][6]){
						list.add(new Node(gearIdx-1, direction * -1));
					}
				}
				if(gearIdx < 3){
					if(gear[gearIdx][2] != gear[gearIdx+1][6]){
						list.add(new Node(gearIdx+1, direction * -1));
					}
				}
				rotate(gearIdx, direction);
			}
		}
		int result = 0;
		for(int i=0; i<4; ++i){
			result += Math.pow(2, i) * gear[i][0];
		}
		System.out.println(result);
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static void rotate(int gearIdx, int direction){
		if(direction > 0){
			int temp = gear[gearIdx][7];
			for(int i=7; i>0; --i){
				gear[gearIdx][i] = gear[gearIdx][i-1];
			}
			gear[gearIdx][0] = temp;
		}else{
			int temp = gear[gearIdx][0];
			for(int i=0; i<7; ++i){
				gear[gearIdx][i] = gear[gearIdx][i+1];
			}
			gear[gearIdx][7] = temp;
		}
	}
}