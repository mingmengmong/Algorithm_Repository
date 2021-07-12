package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ02565 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static class Node{
		public int s;
		public int e;
		public Node(int s, int e){
			this.s = s;
			this.e = e;
		}
		public String toString(){
			return String.format("(%d, %d)", s, e);
		}
	}
	
	public static void BOJ02565(String[] args) throws Exception {
		int N = sc.nextInt();
		List<Node> list = new ArrayList<>();
		for(int i=0; i<N; ++i){
			list.add(new Node(sc.nextInt() - 1, sc.nextInt()));
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.s > o2.s){
					return 1;
				}
				return -1;
			}
		});
		for(int i=0; i<N; ++i){
			list.get(i).s = i;
		}
		Collections.sort(list, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if(o1.e > o2.e){
					return 1;
				}
				return -1;
			}
		});
		
		int[] arr = new int[N];
		for(Node n : list){
			int i = n.s;
			arr[i] = findMax(arr, 0, i) + 1;
		}
		
		System.out.println(N - findMax(arr, 0, N-1));
		
		sc.close();
		bw.close();
		br.close();
	}
	
	
	public static int findMax(int[] arr, int s, int e){
		if(s == e){
			return arr[s];
		}
		
		int m = (s+e) / 2;
		int l = findMax(arr, s, m);
		int r = findMax(arr, m+1, e);
		return Math.max(l,r);
	}
}
/*

4 1 3 3 1
5 3 5 1 3 10
7 2 1 4 5 1 2 3
7 2 1 4 5 0 3 3
0

*/


/*

0 1 2 3 4 5 6 7

			0~7
			1
		0~3     4~7
		2       3
	0~1  2~3  4~5  6~7
	4    5     6     7
    0 1  2  3  4  5  6  7
    8 9  10 11 12 13 14 15
    
                0~10
                 1
           0~5         6~10
            2            3
      0~2    3~5    6~8    9~10
       4      5      6       7
	0~1 2   3~4 5  6~7 8  9    10
	 8  9   10  11 12  13 14   15
   0  1     3 4    6 7
   16 17   18 19  20 21
 */