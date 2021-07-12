package BOJ.S18000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ18258 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void BOJ18258(String[] args) throws Exception {
		Deque<String> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		while(N-- > 0){
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if("push".equals(cmd)){
				q.push(st.nextToken());
			}else if("pop".equals(cmd)){
				if(q.isEmpty()){
					bw.write("-1\n");
				}else{
					bw.write(q.pollLast() + "\n");
				}
			}else if("size".equals(cmd)){
				bw.write(q.size() + "\n");
			}else if("empty".equals(cmd)){
				bw.write(q.isEmpty() ? "1\n" : "0\n");
			}else if("front".equals(cmd)){
				if(q.isEmpty()){
					bw.write("-1\n");
				}else{
					bw.write(q.peekLast()+"\n");
				}
			}else if("back".equals(cmd)){
				if(q.isEmpty()){
					bw.write("-1\n");
				}else{
					bw.write(q.peek()+"\n");
				}
			}
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}