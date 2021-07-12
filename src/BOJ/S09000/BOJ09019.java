package BOJ.S09000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ09019 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;

	public static class Node{
		public int n;
		public long cmd;

		public Node(int n, long cmd) {
			this.n = n;
			this.cmd = cmd;
		}
	}

	public static String[] cmdArr = {"", "D", "S", "R", "L"};

	public static void BOJ09019(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			List<Node> list = new ArrayList<>();
			list.add(new Node(first, 0));
			boolean[] arr = new boolean[10000];
			long resultCmd = 0;
			while(!list.isEmpty()){
				Node node = list.remove(0);
				int n = node.n;
				long cmd = node.cmd;

				// D : double
				// S : -1 if 0 -> 9999
				// R : right move
				// L : left move
				int dNum = (n*2)%10000;
				int sNum = (n+9999)%10000;
				int rNum = n/1000*100+n/100%10*10+n/10%10+n%10*1000;
				int lNum = n/1000+n/100%10*1000+n/10%10*100+n%10*10;
				
				if(dNum == goal){
					resultCmd = cmd*5 + 1;
					break;
				}else{
					if(!arr[dNum]){
						arr[dNum] = true;
						list.add(new Node(dNum, cmd*5 + 1));
					}
				}
				if(sNum == goal){
					resultCmd = cmd*5 + 2;
					break;
				}else{
					if(!arr[sNum]){
						arr[sNum] = true;
						list.add(new Node(sNum, cmd*5 + 2));
					}
				}
				if(rNum == goal){
					resultCmd = cmd*5 + 3;
					break;
				}else{
					if(!arr[rNum]){
						arr[rNum] = true;
						list.add(new Node(rNum, cmd*5 + 3));
					}
				}
				if(lNum == goal){
					resultCmd = cmd*5 + 4;
					break;
				}else{
					if(!arr[lNum]){
						arr[lNum] = true;
						list.add(new Node(lNum, cmd*5 + 4));
					}
				}
			}

			StringBuilder sb = new StringBuilder();
			while(resultCmd > 0){
				sb.append(cmdArr[(int)(resultCmd%5)]);
				resultCmd /= 5;
			}
			bw.write(sb.reverse().toString() + "\n");
		}
		bw.flush();

		sc.close();
		bw.close();
		br.close();
	}
}