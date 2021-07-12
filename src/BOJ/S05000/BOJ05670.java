package BOJ.S05000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ05670 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static char[] stringArr;
	public static int result;
	
	public static class Node{
		public char c;
		public Node[] child;
		public int childCnt;
		public Node(){
			this.c = '\0';
			this.childCnt = 0;
			this.child = new Node[27];
		}
		
		public void add(int idx){
			if(idx == stringArr.length){
				return;
			}
			
			int index = changeIdx(stringArr[idx]);
			Node node = child[index];
			if(node == null){
				node = new Node();
				node.c = stringArr[idx];
				child[index] = node;
				this.childCnt++;
			}
			node.add(idx+1);
		}
		
		public void print(String indent){
			System.out.println(indent + (this.c == '\0' ? '-' : this.c) + " " + this.childCnt);
			for(Node node : child){
				if(node != null){
					node.print(indent + " ");
				}
			}
		}
		
		public void find(int cnt){
			if(this.childCnt > 1){
				++cnt;
			}
			
			if(this.childCnt == 0){
				result += cnt;
				return;
			}
			
			for(Node node : child){
				if(node != null) {
					if(node.c == '\0' && this.childCnt > 1){
						node.find(cnt-1);
					}else {
						node.find(cnt);
					}
				}
			}
		}
	}
	
	public static void BOJ05670(String[] args) throws Exception {
		String inputNum = "";
		while((inputNum = br.readLine()) != null){
			Node head = new Node();
			head.c = '-';
			head.childCnt = 2;
			result = 0;
			int N = Integer.parseInt(inputNum);
			for(int i=0; i<N; ++i){
				stringArr = (br.readLine() + "\0").toCharArray();
				head.add(0);
			}
			
//			head.print("");
			head.find(0);
//			System.out.println(result);
			System.out.printf("%.2f\n", (double)((double)result/(double)N));
			bw.write(String.format("%.2f\n", (double)((double)result/(double)N)));
		}
		
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int changeIdx(char c){
		if(c == '\0')
			return 0;
		return c - 'a' + 1;
	}
}