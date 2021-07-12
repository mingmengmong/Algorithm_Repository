package BOJ.S02000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ02580 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringBuilder sb = new StringBuilder();
	
	public static int[][] arr = new int[9][9];
	
	public static void BOJ02580(String[] args) throws Exception {
		List<Node> list = new ArrayList<>();
		for(int r=0; r<9; ++r){
			for(int c=0; c<9; ++c){
				arr[r][c] = sc.nextInt();
				if(arr[r][c] == 0){
					list.add(new Node(r, c));
				}
			}
		}
		
		for(int i=0; i<list.size(); ++i){
			Node n = list.get(i);
			List<Integer> numList = getNumList(n.r, n.c);
			if(numList.size() == 1){
				arr[n.r][n.c] = numList.get(0);
				list.remove(i);
				--i;
			}
		}
		
//		System.out.println(list.size() + " " + list.toString());
//		System.out.println("--------------");
		find(list, 0);
		
//		System.out.println(list);
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static class Node{
		public int r;
		public int c;
		
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}
		
		public String toString(){
			return String.format("(%d, %d)", r, c);
		}
	}
	
	public static boolean find(List<Node> list, int index){
		if(list.size() == index){
			return true;
		}
		
		Node n = list.get(index);
		List<Integer> numList = getNumList(n.r, n.c);
		if(numList.size() == 0){
			return false;
		}
		
		for(int i : numList){
			arr[n.r][n.c] = i;
			if (find(list, index + 1)) {
				return true;
			}
			arr[n.r][n.c] = 0;
		}
		
		return false;
	}
	
	public static List<Integer> getNumList(int r, int c){
		List<Integer> numList = new ArrayList<Integer>(){{
			for(int i=1; i<=9; ++i){
				add(i);
			}
		}};
		
//		System.out.println(numList);
		
//		System.out.println("-----------------");
		for(int i=0; i<9; ++i){
			numList.remove(new Integer(arr[i][c]));
			numList.remove(new Integer(arr[r][i]));
//			System.out.println(numList);
		}
//		System.out.println("-----------------");
		
		int ri = r/3;
		int ci = c/3;
		for(int i=0; i<3; ++i){
			for(int j=0; j<3; ++j){
				numList.remove(new Integer(arr[i+ri*3][j+ci*3]));
			}
		}
		
		System.out.printf("(%d, %d) : %s\n", r,c,numList.toString());
		
		return numList;
	}
}

/*

0 3 5 4 0 9 2 7 8
0 0 2 1 0 0 6 0 9
0 6 0 2 7 8 1 3 0
0 2 1 0 4 6 0 9 7
8 0 4 9 0 3 5 0 6
5 0 6 8 2 0 4 1 3
9 1 0 6 0 0 0 8 0
6 0 3 7 0 1 0 5 2
2 5 0 3 9 4 7 6 0

0 0 0 4 0 9 2 0 8
0 0 2 1 0 0 0 0 0
0 6 0 2 7 8 1 3 0
0 2 0 0 4 6 0 9 7
8 0 4 9 0 0 0 0 6
5 0 6 8 2 0 0 1 3
0 0 0 0 0 0 0 8 0
0 0 3 7 0 1 0 5 2
2 0 0 0 0 4 7 6 0

1 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 0 0
0 0 0 0 0 0 1 0 0
0 1 0 0 0 0 0 0 0
0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 1 0
0 0 1 0 0 0 0 0 0
0 0 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 1

 */