package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ01043 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int N;
	public static int M;
	public static List<Integer>[] arr;
	public static List<Integer>[] party;
	public static int[] people;
	
	public static void BOJ01043(String[] args) throws Exception {
		st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		people = new int[N+1];
		arr = new List[N+1];
		party = new List[M+1];
		for(int i=1; i<=N; ++i){
			arr[i] = new ArrayList<>();
		}
		for(int i=1; i<=M; ++i){
			party[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int knowSize = Integer.parseInt(st.nextToken());
		int[] know = new int[knowSize];
		for(int i=0; i<knowSize; ++i){
			know[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<=M; ++i){
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			for(int j=0; j<s; ++j){
				int n = Integer.parseInt(st.nextToken());
				arr[n].add(i);
				party[i].add(n);
			}
		}
		
		if(knowSize == 0){
			System.out.println(M);
			return;
		}
		
		visit = new boolean[N+1];
		for(int kp : know){
			if(people[kp] == 0){
				dfs(kp);
			}
		}
		
//		System.out.println(Arrays.toString(people));
		
		List<Integer> list = new ArrayList<>();
		for(int i=1; i<=M; ++i){
			list.add(i);
		}
		for(int i=1; i<=N; ++i){
			if(visit[i]){
				for(int p : arr[i]){
					int idx = Collections.binarySearch(list, p);
					if(idx >= 0){
						list.remove(idx);
					}
				}
			}
		}
		
		System.out.println(list.size());
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static boolean[] visit;
	public static void dfs(int peopleNum){
		visit[peopleNum] = true;
		for(int p : arr[peopleNum]){
			for(int n : party[p]){
				if(!visit[n]){
					dfs(n);
				}
			}
		}
	}
}