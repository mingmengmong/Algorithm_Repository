package BOJ.S02000;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ02629 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Scanner sc = new Scanner(System.in);
	static StringTokenizer st;
	
	static int N, M, MAX = 40_000;
	static List<Integer> list = new ArrayList<>();
	static Set<Integer> set = new HashSet<>(), addSet = new HashSet<>();
	static boolean[] visit = new boolean[MAX+1];
	
	static{
		visit[0] = true;
		set.add(0);
	}
	
	public static void BOJ02629(String[] args) throws Exception {
//		br = new BufferedReader(new FileReader(Main.class.getResource("").getPath() + "input"));
//		sc = new Scanner(new File(Main.class.getResource("").getPath() + "input"));
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i){
			int n = Integer.parseInt(st.nextToken());
			list.add(n);
		}
		
		list.sort((n1,n2) -> n2-n1);
		
		for(int i : list){
			addSet.clear();
			for(int j : set){
				int min = Math.abs(j-i);
				if(min >= 0 && !visit[min]){
					addSet.add(min);
					visit[min] = true;
				}
				
				int max = j+i;
				if(max <= MAX && !visit[max]){
					addSet.add(max);
					visit[max] = true;
				}
			}
			set.addAll(addSet);
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; ++i){
			bw.write((visit[Integer.parseInt(st.nextToken())] ? "Y " : "N "));
		}
		bw.newLine();
		
		bw.flush();
		
		System.out.println(set.stream().sorted().collect(Collectors.toList()));
		
		br.close();
		bw.close();
		sc.close();
	}
}