package BOJ.S09000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ09205 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static class Node{
		public int r;
		public int c;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public String toString(){
			return String.format("(%d,%d)", r,c);
		}
	}
	
	public static void BOJ09205(String[] args) throws Exception {
		int TC = Integer.parseInt(br.readLine());
		while(TC-- > 0){
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int homeR = Integer.parseInt(st.nextToken());
			int homeC = Integer.parseInt(st.nextToken());
			
			List<Node> list = new ArrayList<>();
			for(int i=0; i<N; ++i){
				st = new StringTokenizer(br.readLine());
				list.add( new Node( Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) ) );
			}
			
			st = new StringTokenizer(br.readLine());
			int goalR = Integer.parseInt(st.nextToken());
			int goalC = Integer.parseInt(st.nextToken());
			
			if((Math.abs(goalR-homeR) + Math.abs(goalC-homeC)) <= 1000){
				bw.write("happy\n");
				continue;
			}
			
			List<Integer> homeToCVS = new ArrayList<>();
			boolean[] bArr = new boolean[N];
			Set<Integer> goalByCVS = new HashSet<>();
			for(int i=0; i<N; ++i){
				Node node = list.get(i);
				int r = node.r;
				int c = node.c;
				if((Math.abs(homeR-r) + Math.abs(homeC-c)) <= 1000){
					homeToCVS.add(i);
					bArr[i] = true;
				}
				
				if((Math.abs(goalR-r) + Math.abs(goalC-c)) <= 1000){
					goalByCVS.add(i);
				}
			}
			
			boolean check = false;
			while(!homeToCVS.isEmpty()){
				int idx = homeToCVS.remove(0);
				if(goalByCVS.contains(idx)){
					check = true;
					break;
				}
				
				Node node = list.get(idx);
				int r = node.r;
				int c = node.c;
				for(int i=0; i<N; ++i){
					if(i == idx){
						continue;
					}
					
					if(bArr[i]){
						continue;
					}
					
					Node nNode = list.get(i);
					if((Math.abs(r-nNode.r) + Math.abs(c-nNode.c)) <= 1000){
						bArr[i] = true;
						homeToCVS.add(i);
					}
				}
			}
			
			if(check){
				bw.write("happy\n");
			}else{
				bw.write("sad\n");
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}