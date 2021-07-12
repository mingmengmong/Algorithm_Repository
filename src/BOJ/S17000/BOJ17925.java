package BOJ.S17000;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ17925 {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static StringTokenizer st;
	
	public static int[][] base = new int[][]{
			{6, -4},
			{1, 0}
	};
	
	
	public static int[][] getBase(){
		int[][] nBase = new int[][]{
				{6, -4},
				{1, 0}
		};
		return nBase;
	}
	
	public static int[][] getMatrix(int n, int[][] mat){
		if(n == 1){
			return mat;
		}
		
		int hn = n/2;
		int mn = n&1;
		int[][] nmat = getMatrix(hn, mat);
		nmat = mulMatrix(nmat, nmat);
		if(mn == 1){
			nmat = mulMatrix(nmat, base);
		}
		return nmat;
	}
	
	public static int[][] mulMatrix(int[][] mat1, int[][] mat2){
		int[][] result = new int[2][2];
		for(int i=0; i<2; ++i){
			for(int j=0; j<2; ++j){
				for(int k=0; k<2; ++k){
					result[i][j] += mat1[i][k]*mat2[k][j];
				}
				result[i][j] %= 1000;
			}
		}
		return result;
	}
	
	public static void BOJ17925(String[] args) throws Exception {
		int TC = sc.nextInt();
		for(int i=1; i<=TC; ++i){
			int n = sc.nextInt() - 1;
//			int n = i;
			int[][] mat = getMatrix(n, getBase());
			int result = ((mat[1][0] * 28 + mat[1][1] * 6 - 1) % 1000 + 1000) % 1000;
			bw.write(String.format("Case #%d: %03d\n", i, result));
		}
		bw.flush();
		
		sc.close();
		bw.close();
		br.close();
	}
}