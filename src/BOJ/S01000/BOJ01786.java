package BOJ.S01000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ01786 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static void BOJ_01786(String[] args) throws Exception {
		char[] t = br.readLine().toCharArray();
		char[] p = br.readLine().toCharArray();
		
		int[] pi = getPi(p);
		int tl = t.length;
		int pl = p.length;
		
		List<Integer> idxList = new ArrayList<>();
		for(int i=0, j=0; i<tl; ++i){
			while(j>0 && t[i] != p[j]){
				j = pi[j-1];
			}
			if(t[i] == p[j]){
				if(j == pl-1){
					idxList.add(i-pl+1);
					j = pi[j];
				}else{
					++j;
				}
			}
		}
		
		bw.write(idxList.size() + "\n");
		for(int idx : idxList){
			bw.write((idx+1) + "\n");
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
	
	public static int[] getPi(char[] str){
		int l = str.length;
		int[] pi = new int[l];
		for(int i=1, j=0; i<l; ++i){
			while(j>0 && str[i] != str[j]){
				j = pi[j-1];
			}
			if(str[i] == str[j]){
				pi[i] = ++j;
			}
		}
		return pi;
	}
}